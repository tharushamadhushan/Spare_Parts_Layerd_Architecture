package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Model.AttendanceDTO;
import lk.ijse.Model.EmployeeDTO;
import lk.ijse.Model.tm.AttendanceTm;
import lk.ijse.Model.tm.PlaceOrderTM;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.AttendanceBO;
import lk.ijse.dao.DAOFactory;
import lombok.SneakyThrows;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

public class AttendanceFormController implements Initializable {

    public ToggleGroup btnGroup;

    @FXML
    private ComboBox<String> txtEmployeeId;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblOrderTime;

    @FXML
    private Label lblName;

    @FXML
    private TableView<AttendanceTm> tblAttendens01;

    @FXML
    private TableColumn<?, ?> tblId;

    @FXML
    private TableColumn<?, ?> tblDate;

    @FXML
    private TableColumn<?, ?> tblTime;

    @FXML
    private TableColumn<?, ?> tblAttendens;


    private ObservableList<PlaceOrderTM> obList = FXCollections.observableArrayList();
    private java.awt.Label txtEmID;

    AttendanceBO attendanceBO = (AttendanceBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.ATTENDANCE);




    @FXML
    void btnSaveOnAction(ActionEvent event) throws ParseException {
        Object id = txtEmployeeId.getSelectionModel().getSelectedItem();
        RadioButton selectedButton = (RadioButton)btnGroup.getSelectedToggle();
        String text = selectedButton.getText();
        String date = String.valueOf(LocalTime.now());
        ObservableList<AttendanceTm> obList = FXCollections.observableArrayList();
        AttendanceTm tm = new AttendanceTm((String) id,date,LocalTime.now(),text);
        obList.add(tm);
        tblAttendens01.setItems(obList);

        AttendanceDTO attendance= new AttendanceDTO(id.toString(), Date.valueOf(LocalDate.now()),text);
        try {
            boolean isSave= attendanceBO.saveAttendance(attendance);
            if (isSave){
                new Alert(Alert.AlertType.CONFIRMATION,"OK").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void cbmIdOnAction(ActionEvent event) {
        Object id = txtEmployeeId.getSelectionModel().getSelectedItem();

        try {
            String employee =attendanceBO.getEmployeeName(String.valueOf(id));

            lblName.setText(employee);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadEmployeeId();
        loadAttendance();
        loadDateAndTime();
        setvaluefortable();
    }

    private void setvaluefortable() {
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tblTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        tblAttendens.setCellValueFactory(new PropertyValueFactory<>("attendance"));
    }

    private void loadDateAndTime() {
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
        lblOrderTime.setText(String.valueOf(LocalTime.now()));
    }


    private void loadAttendance() {
        ObservableList<String> obList= FXCollections.observableArrayList();
        try {
            List<String> names= attendanceBO.generateEmployeeAttendance();

            for (String name : names){
                obList.add(name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadEmployeeId() {
        ObservableList<String> obList= FXCollections.observableArrayList();
        try {
            List<String> ids= attendanceBO.generateEmployeeId();

            for (String id : ids){
                obList.add(id);
            }
            txtEmployeeId.setItems(obList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}