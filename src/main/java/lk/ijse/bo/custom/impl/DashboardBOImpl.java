package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.DashboardBO;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dao.custom.OrderDAO;
import lk.ijse.dao.custom.PartsDAO;
import lk.ijse.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.dao.custom.impl.OrderDAOImpl;
import lk.ijse.dao.custom.impl.PartsDAOImpl;

import java.sql.SQLException;

public class DashboardBOImpl implements DashboardBO {

    CustomerDAO customerDAO =new CustomerDAOImpl();
    OrderDAO orderDAO=new OrderDAOImpl();
    PartsDAO partsDAO=new PartsDAOImpl();
    @Override
    public int countCustomers() throws SQLException {
        return customerDAO.countCustomers();
    }

    @Override
    public int countOrders() throws SQLException {
        return orderDAO.countOrders();
    }

    @Override
    public double getTotalOrderSales() throws SQLException {
        return orderDAO.getTotalOrderSales();
    }

    @Override
    public int countItem() throws SQLException {
        return partsDAO.countItem();
    }
}
