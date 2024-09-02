package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.OrderDetailDAO;
import lk.ijse.entity.Order;
import lk.ijse.entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    public boolean save(String orderId, List<OrderDetail> orderDtoList) throws SQLException {
        for (OrderDetail dto : orderDtoList){
            if (!save(orderId,dto)){
                return false;
            }
        }
        return true;
    }

    private boolean save(String orderId,OrderDetail dto) throws SQLException {
        String sql = "INSERT INTO orderdetail (orderId,itemCode,orderQTY)VALUES(?,?,?)";
        return SQLUtil.execute(sql,orderId,dto.getCode(),dto.getQty());
    }
}
