package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.OrderDetail;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO  extends SuperDAO {
    public boolean save(String orderId, List<OrderDetail> orderDtoList) throws SQLException;
}
