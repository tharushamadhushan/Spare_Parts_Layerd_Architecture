package lk.ijse.bo.custom;

import lk.ijse.Model.CustomerDTO;
import lk.ijse.bo.SuperBo;

import java.sql.SQLException;

public interface CustomerBO extends SuperBo {
    boolean delete(String id) throws SQLException;

    boolean save(CustomerDTO dto) throws SQLException;

    CustomerDTO search(String id) throws SQLException;

    boolean Update(CustomerDTO dto) throws SQLException;
}
