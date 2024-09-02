package lk.ijse.bo.custom;

import lk.ijse.Model.SupplierDTO;
import lk.ijse.bo.SuperBo;

import java.sql.SQLException;

public interface SuppliesBO extends SuperBo {
    boolean delete(String id) throws SQLException;

    boolean save(SupplierDTO supplier) throws SQLException;

    SupplierDTO search(String id) throws SQLException;

    boolean update(SupplierDTO suppliers) throws SQLException;


}
