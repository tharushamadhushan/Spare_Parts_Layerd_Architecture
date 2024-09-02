package lk.ijse.dao.custom.impl;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.SupplierDAO;
import lk.ijse.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    public boolean delete(String id) throws SQLException {
        String sql="DELETE FROM suppliers WHERE suppliersID=?";
        return SQLUtil.execute(sql,id);
    }

    @Override
    public boolean Update(Supplier suppliers) throws SQLException {
           String sql = "UPDATE suppliers SET contact=?,suppliersName=?,suppliersNic=?,suppliersAdress=? WHERE suppliersID=?";
        return SQLUtil.execute(sql,suppliers.getContact(),suppliers.getSuppliersName(),suppliers.getSuppliersNic(),suppliers.getSuppliersAdress(),suppliers.getSuppliersID());

    }

    public boolean save(Supplier supplier) throws SQLException {
        String sql="INSERT INTO suppliers(suppliersID,contact,suppliersName,suppliersNic,suppliersAdress)VALUES(?,?,?,?,?)";
        return SQLUtil.execute(sql,supplier.getSuppliersID(),supplier.getContact(),supplier.getSuppliersName(),supplier.getSuppliersNic(),supplier.getSuppliersAdress());
    }

    public Supplier search(String id) throws SQLException {
        String sql="SELECT * FROM suppliers WHERE suppliersID=?";
        ResultSet resultSet=SQLUtil.execute(sql,id);

        if (resultSet.next()){
            String suppliersID=resultSet.getString(1);
            String contact=resultSet.getString(2);
            String suppliersName=resultSet.getString(3);
            String suppliersNic=resultSet.getString(4);
            String suppliersAdress=resultSet.getString(5);

            return new Supplier(suppliersID,contact,suppliersName,suppliersNic,suppliersAdress);
        }
        return null;
    }

    public boolean update(Supplier suppliers) throws SQLException {
        String sql = "UPDATE suppliers SET contact=?,suppliersName=?,suppliersNic=?,suppliersAdress=? WHERE suppliersID=?";
        return SQLUtil.execute(sql,suppliers.getContact(),suppliers.getSuppliersName(),suppliers.getSuppliersNic(),suppliers.getSuppliersAdress(),suppliers.getSuppliersID());
    }

    public List<String> genarateId() throws SQLException {
        String sql = "SELECT suppliersID FROM suppliers";

        ResultSet resultSet = SQLUtil.execute(sql);
        List<String>id = new ArrayList<>();
        while (resultSet.next()){
            id.add(resultSet.getString(1));
        }
        return id;
    }

    public String generateNextOrderId() throws SQLException {

        String sql = "SELECT suppliersOrderID FROM suppliersorder ORDER BY suppliersOrderID DESC LIMIT 1";

        ResultSet resultSet = SQLUtil.execute(sql);
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private String splitOrderId(String orderId) {
        if (orderId != null) {
            String[]strings = orderId.split("K0");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "K0"+id;
        }
        return "K001";
    }


    public String getName(String id) throws SQLException {
        String sql = "SELECT suppliersName FROM suppliers WHERE suppliersID = ?";
        ResultSet resultSet = SQLUtil.execute(sql,id);

        String name = "" ;

        if (resultSet.next()){
            name  = resultSet.getString(1);
        }
        return name;
    }
}
