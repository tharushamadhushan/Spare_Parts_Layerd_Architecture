package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.Model.CustomerDTO;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.impl.CustomerDAOImpl;


import java.sql.SQLException;

public class CustomerFormController {

    @FXML
    private TextField txtcontact;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtnic;

    CustomerBO customerBO= (CustomerBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.CUSTOMER);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[C0-9]{4}$")) {
            String id = txtid.getText();
            boolean isDelete = false;
            try {
                isDelete = customerBO.delete(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[C0-9]{4}$")) {
            String id = txtid.getText();
            String name = txtname.getText();
            String contact = txtcontact.getText();
            String nic = txtnic.getText();

            CustomerDTO customer = new CustomerDTO(id, name, contact, nic);

            boolean isSave = false;
            try {
                isSave = customerBO.save(customer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (isSave) {
                new Alert(Alert.AlertType.CONFIRMATION, "ok").show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[C0-9]{4}$")) {
            String id = txtid.getText();

            CustomerDTO customer = null;
            try {
                customer = customerBO.search(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (customer != null) {
                txtid.setText(customer.getCustId());
                txtname.setText(customer.getCustName());
                txtcontact.setText(customer.getContact());
                txtnic.setText(customer.getCustNic());
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (txtid.getText().matches("^[C0-9]{4}$")) {
            String id = txtid.getText();
            String name = txtname.getText();
            String nic = txtnic.getText();
            String contact = txtcontact.getText();

            CustomerDTO customer = new CustomerDTO(id, name,  contact,nic);
            boolean isUpdate = false;
            try {
                isUpdate = customerBO.Update(customer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "ID NOT VALIED !!!").show();
        }
    }
@FXML
    public void btnClearOnAction(ActionEvent actionEvent) {
        txtid.setText("");
        txtname.setText("");
        txtnic.setText("");
        txtcontact.setText("");
    }
}

