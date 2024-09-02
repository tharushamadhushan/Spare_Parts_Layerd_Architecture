package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    public List<String> genarateId() throws SQLException {
        String sql = "SELECT custID FROM customer";
        ResultSet resultSet = SQLUtil.execute(sql);

        List<String>id=new ArrayList<>();

        while (resultSet.next()){
            id.add(resultSet.getString(1));
        }
        return id;
    }

    public Customer search(String id) throws SQLException {
        String sql="SELECT * FROM customer WHERE custID =? ";
        ResultSet resultSet= SQLUtil.execute(sql,id);

        if (resultSet.next()){

            String cid = resultSet.getString(1);
            String name = resultSet.getString(2);
            String contact = resultSet.getString(3);
            String nic = resultSet.getString(4);

            return new Customer(cid,name,contact,nic);

        }
        return null;
    }

    public boolean save(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (custID,custName,contact,custNic) VALUES (?,?,?,?)";
        return SQLUtil.execute(sql,customer.getCustId(),customer.getCustName(),customer.getCustNic(),customer.getContact());
    }

    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM customer WHERE custID=?";
        return SQLUtil.execute(sql,id);
    }

    public boolean Update(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET custName=?,contact=?,custNic=? WHERE custID=?";
        return SQLUtil.execute(sql,customer.getCustName(),customer.getContact(),customer.getCustNic(),customer.getCustId());
    }

    public String getName(String id) throws SQLException {
        String sql = "SELECT custName FROM customer WHERE custID = ?";
        ResultSet resultSet = SQLUtil.execute(sql,id);

        String name = "" ;

        if (resultSet.next()){
            name  = resultSet.getString(1);
        }
        return name;
    }

    public int countCustomers() throws SQLException {
        String sql = "SELECT COUNT(*) as customerCount FROM sparepartsshop.customer;";
        ResultSet resultSet = SQLUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }


}
