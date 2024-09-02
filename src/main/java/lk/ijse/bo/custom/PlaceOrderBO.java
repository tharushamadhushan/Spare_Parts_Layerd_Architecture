package lk.ijse.bo.custom;

import lk.ijse.Model.OrderDetailDTO;
import lk.ijse.Model.PartsDTO;
import lk.ijse.bo.SuperBo;

import java.sql.SQLException;
import java.util.List;

public interface PlaceOrderBO extends SuperBo {

    List<String> genarateItemCode() throws SQLException;

    List<String> genarateCustomerId() throws SQLException;

    String getNextOderId() throws SQLException;

    boolean save(String orderId, double total, String custId, List<OrderDetailDTO> orderDto) throws SQLException;

    PartsDTO search(String code) throws SQLException;

    String getName(String id) throws SQLException;
}
