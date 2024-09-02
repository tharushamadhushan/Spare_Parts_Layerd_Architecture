package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.Model.SupplierDTO;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.SuppliesBO;

import java.sql.SQLException;

public class SuppliesFormController {

    @FXML
    private TextField txtadress;

    @FXML
    private TextField txtcontact;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtnic;

    SuppliesBO suppliesBO= (SuppliesBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.SUPPLIES);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[S0-9]{4}$")) {
            String id = txtid.getText();
            try {
                boolean isDelete = suppliesBO.delete(id);
                if (isDelete) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[S0-9]{4}$")){
        String id=txtid.getText();
        String contact=txtcontact.getText();
        String name=txtname.getText();
        String nic=txtnic.getText();
        String adress=txtadress.getText();

        SupplierDTO supplier=new SupplierDTO(id,contact,name,nic,adress);

        try {
            boolean isSave=suppliesBO.save(supplier);
            if (isSave){
                new Alert(Alert.AlertType.CONFIRMATION,"OK").show();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[S0-9]{4}$")){
        String id=txtid.getText();
        try {
            SupplierDTO supplier= suppliesBO.search(id);
            if (supplier!=null){
                txtid.setText(supplier.getSuppliersID());
                txtcontact.setText(supplier.getContact());
                txtname.setText(supplier.getSuppliersName());
                txtnic.setText(supplier.getSuppliersNic());
                txtadress.setText(supplier.getSuppliersAdress());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    } else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[S0-9]{4}$")){
        String id=txtid.getText();
        String contact=txtcontact.getText();
        String name=txtname.getText();
        String nic=txtnic.getText();
        String adress=txtadress.getText();

        SupplierDTO suppliers=new SupplierDTO(id,contact,name,nic,adress);
        try {
            boolean isUpdate=suppliesBO.update(suppliers);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"OK").show();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtid.setText("");
        txtcontact.setText("");
        txtname.setText("");
        txtnic.setText("");
        txtadress.setText("");
    }
}
