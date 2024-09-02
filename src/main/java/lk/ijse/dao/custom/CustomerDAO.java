package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer> {

    public List<String> genarateId() throws SQLException ;

    public String getName(String id) throws SQLException ;

    public int countCustomers() throws SQLException ;

}
