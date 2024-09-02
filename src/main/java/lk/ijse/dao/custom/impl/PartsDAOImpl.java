package lk.ijse.dao.custom.impl;

import lk.ijse.Model.OrderDetailDTO;
import lk.ijse.Model.SupplierOrderDetailDTO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PartsDAO;
import lk.ijse.entity.Parts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartsDAOImpl implements PartsDAO {
    public List<String> genarateCode() throws SQLException {
        String sql = "SELECT itemCode FROM parts";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<String>code = new ArrayList<>();

        while (resultSet.next()){
            code.add(resultSet.getString(1));
        }
        return code;
    }

    public boolean delete(String id) throws SQLException {
        String sql =  "DELETE FROM parts WHERE itemCode = ?";
        return SQLUtil.execute(sql,id);
    }

    public Parts search(String id) throws SQLException {
        String sql = "SELECT * FROM parts WHERE itemCode= ?";
        ResultSet resultSet = SQLUtil.execute(sql,id);

        if (resultSet.next()){
            String pid = resultSet.getString(1);
            String name = resultSet.getString(2);
            String type= resultSet.getString(3);
            Double price = Double.valueOf(resultSet.getString(4));
            Integer qty = Integer.valueOf(resultSet.getString(5));

            return new Parts(pid,name,type,price,qty);
        }
        return null;
    }

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
            String[] strings = currentId.split("O00");
            int id = Integer.parseInt(strings[1]);
            id++;

            return "O00"+id;
        }
        return "O001";
    }
    public boolean updateQtyOrder(List<OrderDetailDTO> orderDtoList) throws SQLException {
        for (OrderDetailDTO dto : orderDtoList) {
            if (!updateQtyOrder(dto)){
                return false;
            }
        }
        return true;
    }

    private boolean updateQtyOrder(OrderDetailDTO dto) throws SQLException {
        String sql = "UPDATE parts SET qtyOnStock = (qtyOnStock - ?) WHERE itemCode = ?";
        return SQLUtil.execute(sql,dto.getQty(),dto.getCode());
    }
    public boolean updateQtyOrder1(List<SupplierOrderDetailDTO> orderDtoList) throws SQLException {
        for (SupplierOrderDetailDTO dto : orderDtoList) {
            if (!updateQtyOrder1(dto)){
                return false;
            }
        }
        return true;
    }

    public boolean updateQtyOrder1(SupplierOrderDetailDTO dto) throws SQLException {
        String sql = "UPDATE parts SET qtyOnStock = (qtyOnStock + ?) WHERE itemCode = ?";
        return SQLUtil.execute(sql,dto.getOdrderQty(),dto.getItemCode());
    }

    public boolean save(Parts item) throws SQLException {
        String sql = "INSERT INTO parts (itemCode,description,vehicleBrand,unitPrice,qtyOnStock) VALUES (?,?,?,?,?)";
        return SQLUtil.execute(sql,item.getItemCode(),item.getDescription(),item.getVehicleBrand(),item.getUnitPrice(),item.getQtyOnStock());
    }

    public boolean Update(Parts item) throws SQLException {
        String sql = "UPDATE parts SET description=?,vehicleBrand=?,unitPrice=?,qtyOnStock=? WHERE itemCode=?";
        return SQLUtil.execute(sql,item.getDescription(),item.getVehicleBrand(),item.getUnitPrice(),item.getQtyOnStock(),item.getItemCode());
    }

    public int countItem() throws SQLException {
        String sql = "SELECT COUNT(*) as itemCount FROM sparepartsshop.parts;";
        ResultSet resultSet = SQLUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }
}
