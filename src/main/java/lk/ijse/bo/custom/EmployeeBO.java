package lk.ijse.bo.custom;

import lk.ijse.Model.EmployeeDTO;
import lk.ijse.bo.SuperBo;

import java.sql.SQLException;

public interface EmployeeBO extends SuperBo {
    boolean save(EmployeeDTO employee) throws SQLException;

    EmployeeDTO search(String id) throws SQLException;

    boolean Update(EmployeeDTO employee) throws SQLException;

    boolean delete(String id) throws SQLException;
}
