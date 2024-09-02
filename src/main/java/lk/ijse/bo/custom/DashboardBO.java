package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;

import java.sql.SQLException;

public interface DashboardBO extends SuperBo {
    int countCustomers() throws SQLException;

    int countOrders() throws SQLException;

    double getTotalOrderSales() throws SQLException;

    int countItem() throws SQLException;
}
