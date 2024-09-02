package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SupplierDAO extends CrudDAO<Supplier> {



    public List<String> genarateId() throws SQLException ;

    public String generateNextOrderId() throws SQLException ;

    private String splitOrderId(String orderId) {
        if (orderId != null) {
            String[]strings = orderId.split("K0");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "K0"+id;
        }
        return "K001";
    }


    public String getName(String id) throws SQLException ;
}
