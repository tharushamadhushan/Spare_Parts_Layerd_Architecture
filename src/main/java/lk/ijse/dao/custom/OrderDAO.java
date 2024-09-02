package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO extends SuperDAO {
    public String getNextId() throws SQLException ;

    public boolean save(String orderId, LocalDate date, String custId, double total) throws SQLException ;

    public int countOrders() throws SQLException ;

    public double getTotalOrderSales() throws SQLException ;

}
