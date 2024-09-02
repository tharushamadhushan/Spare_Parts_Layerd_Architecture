package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


import javafx.stage.Stage;
import lk.ijse.Model.PartsDTO;
import lk.ijse.Model.SupplierOrderDTO;
import lk.ijse.Model.SupplierOrderDetailDTO;
import lk.ijse.Model.tm.PlaceOrderTM;
import lk.ijse.Model.tm.PlaceSupplierTM;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.PlaceSupplierBO;
import lk.ijse.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class PlaceSupplierController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtQty;

    @FXML
    private Label lblQtyOnHand;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Label lblDescription;

    @FXML
    private JFXComboBox<String> cmbProductCode;

    @FXML
    private Label lblCustomerName;

    @FXML
    private JFXComboBox<String> cmbCustomerId;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblTime;

    @FXML
    private TableView<PlaceSupplierTM> tblOrderCart1;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private Label lblNetTotal;

    private ObservableList<PlaceSupplierTM> obList = FXCollections.observableArrayList();
    private java.awt.List tblOrderCart;

    PlaceSupplierBO placeSupplierBO= (PlaceSupplierBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.PLACESUPPLIER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDateAndTime();
        loadNextOrderId();
        loadCustomerId();
        loadProductCode();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    public void set(String id, String name) {
        cmbCustomerId.setId(id);
        lblCustomerName.setText(name);
    }

    private void loadProductCode() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> code = placeSupplierBO.genarateCode();

            for (String codes : code){
                obList.add(codes);
            }
            cmbProductCode.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadCustomerId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String>id = placeSupplierBO.genarateId();
            for (String ids : id){
                obList.add(ids);
            }
            cmbCustomerId.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadNextOrderId() {
        try {
            String nextOrderId = placeSupplierBO.generateNextOrderId();
            lblOrderId.setText(nextOrderId);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadDateAndTime() {
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
        lblTime.setText(String.valueOf(LocalTime.now()));
    }
    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    private void btnRemoveOnAction(Button btn) {
        btn.setOnAction((e)->{
            ButtonType yes = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.INFORMATION,"ARE YOU SURE REMOVE THIS MATTIRIAL",yes,no).showAndWait();

            if (buttonType.orElse(no)==yes){
                obList.remove(tblOrderCart1.getSelectionModel().getSelectedItem());
                tblOrderCart1.refresh();
                getNetTotal();
            }
        });
    }

    private void getNetTotal() {
        Double netTotal = 0.0;
        for (int i = 0; i < tblOrderCart1.getItems().size(); i++) {
            netTotal +=(Double) colTotal.getCellData(i);
        }
        lblNetTotal.setText(String.valueOf(netTotal));
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("DASH BORD");
        stage.centerOnScreen();
    }

    @FXML
    void btnNewCustomerOnAction(ActionEvent event) throws IOException {
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }
    private void addBill() throws JRException, SQLException {
        String id=lblOrderId.getText();
        JasperDesign load = null;
        load = JRXmlLoader.load(new File("C:\\Users\\Admin\\Desktop\\My Final Project\\finalproject\\src\\main\\resources\\report\\supplier.jrxml"));
        JRDesignQuery newQuery = new JRDesignQuery();
        String sql = "select i.description as name,i.unitPrice as unitPrice,oi.orderQTY , i.unitPrice*oi.orderQTY as subTotal  from parts i inner join suppliersorderdetail oi on  i.itemCode=oi.itemcode where oi.suppliersOrderID = '"+id+"'";
        newQuery.setText(sql);
        load.setQuery(newQuery);
        JasperReport js = JasperCompileManager.compileReport(load);
        HashMap<String,Object> hm=new HashMap<>();
        hm.put("sparepartsSupplies","Name");
        hm.put("orderId","K001");
        JasperPrint jp = JasperFillManager.fillReport(js, null, DBConnection.getInstance().getConnection());
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.show();
    }

    @FXML
    void cmbCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void cmbProductCodeOnAction(ActionEvent event) {

    }

    public void btnPlaceOrderOnAction(javafx.event.ActionEvent actionEvent) {
        String orderId = lblOrderId.getText();
        double total = Double.parseDouble(lblNetTotal.getText());
        String custId = cmbCustomerId.getSelectionModel().getSelectedItem();

        List<SupplierOrderDetailDTO> orderDto = new ArrayList<>();

        for (int i = 0; i < tblOrderCart1.getItems().size(); i++) {
            PlaceSupplierTM tm=obList.get(i);
            SupplierOrderDetailDTO supplierOrderDetailDTO = new SupplierOrderDetailDTO(orderId,tm.getCode(),tm.getQty(),tm.getTotal());

            orderDto.add(supplierOrderDetailDTO);
        }
        try {
            boolean isSave = placeSupplierBO.save(orderId,total,custId,orderDto);
            if (isSave){
                new Alert(Alert.AlertType.CONFIRMATION,"ORDER PLACED!!!").show();
                addBill();
            }
        } catch (SQLException | JRException e) {
            e.printStackTrace();
        }
    }

    public void cmbCustomerOnAction(javafx.event.ActionEvent actionEvent) {
        String id = String.valueOf(cmbCustomerId.getSelectionModel().getSelectedItem());

        try {
            String name =placeSupplierBO.getName(id);
            lblCustomerName.setText(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnNewCustomerOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customer_form.fxml"));
        Parent load= loader.load();
        root.getChildren().clear();
        root.getChildren().add(load);
    }

    public void cmbProductCodeOnAction(javafx.event.ActionEvent actionEvent) {
        String code = String.valueOf(cmbProductCode.getSelectionModel().getSelectedItem());

        try {
            PartsDTO product = placeSupplierBO.search(code);
            if (product != null){
                lblDescription.setText(product.getDescription());
                lblUnitPrice.setText(String.valueOf(product.getUnitPrice()));
                lblQtyOnHand.setText(String.valueOf(product.getQtyOnStock()));

                txtQty.requestFocus();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnAddToCartOnAction(javafx.event.ActionEvent actionEvent) {
        String code = (String) cmbProductCode.getSelectionModel().getSelectedItem();
        String description = lblDescription.getText();
        Integer qty = Integer.valueOf(txtQty.getText());
        Double price = Double.valueOf(lblUnitPrice.getText());
        Double total = qty*price;
        Button btn = new Button("Remove");
        btn.setCursor(Cursor.HAND);

        btnRemoveOnAction(btn);

        if (!obList.isEmpty()){
            for (int i = 0; i < tblOrderCart1.getItems().size(); i++) {
                if (colItemCode.getCellData(i).equals(code)) {
                    qty += (Integer) colQty.getCellData(i);
                    total = qty * price;

                    obList.get(i).setQty(qty);
                    obList.get(i).setTotal(total);

                    tblOrderCart1.refresh();
                    getNetTotal();
                    return;
                }
            }
        }

        PlaceSupplierTM tm = new PlaceSupplierTM(code, description, qty, price, total, btn);
        obList.add(tm);
        tblOrderCart1.setItems(obList);
        getNetTotal();
        txtQty.setText("");

    }

    public void btnBackOnAction(javafx.event.ActionEvent actionEvent) {

    }
}
