package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.SupplierOrderDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class SupplierOrderDAOImpl implements SupplierOrderDAO {
    public boolean save(String suppliesId , LocalDate date, Double total) throws SQLException {
        String sql = "INSERT INTO suppliersOrder (suppliersOrderID,date,total) VALUES (?,?,?)";
        return SQLUtil.execute(sql,suppliesId,date,total);
    }
}
