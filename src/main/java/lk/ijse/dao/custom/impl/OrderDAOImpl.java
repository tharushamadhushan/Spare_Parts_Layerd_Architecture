package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.OrderDAO;
import lk.ijse.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    public String getNextId() throws SQLException {
        String sql = "SELECT orderId FROM orders ORDER BY orderId DESC LIMIT 1";
        ResultSet resultSet = SQLUtil.execute(sql);

        if (resultSet.next()){
            return nextId(resultSet.getString(1));
        }
        return nextId(null);
    }

    private String nextId(String currentId) {
        if (currentId != null){
            String[] strings = currentId.split("O0");
            int id = Integer.parseInt(strings[1]);
            id++;

            return "O0"+id;
        }
        return "O001";
    }

    public boolean save(String orderId, LocalDate date, String custId, double total) throws SQLException {
        String sql = "INSERT INTO orders (orderId,orderDate,custId,total) VALUES (?,?,?,?)";
        return SQLUtil.execute(sql,orderId,date,custId,total);
    }

    public int countOrders() throws SQLException {
        String sql = "SELECT COUNT(*) FROM sparepartsshop.orders;";
        ResultSet resultSet = SQLUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }

    public double getTotalOrderSales() throws SQLException {
        String sql = "SELECT SUM(total)  FROM sparepartsshop.orders;";
        ResultSet resultSet = SQLUtil.execute(sql);
        double total = 0 ;
        if (resultSet.next()) {
            total =  resultSet.getInt(1);
        }
        return total;
    }
}
