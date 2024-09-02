package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.SupplierOrder;

import java.sql.SQLException;
import java.time.LocalDate;

public interface SupplierOrderDAO extends SuperDAO {
    public boolean save(String suppliesId , LocalDate date, Double total) throws SQLException;
}
