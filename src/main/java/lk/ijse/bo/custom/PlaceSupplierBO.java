package lk.ijse.bo.custom;

import lk.ijse.Model.PartsDTO;
import lk.ijse.Model.SupplierOrderDTO;
import lk.ijse.Model.SupplierOrderDetailDTO;
import lk.ijse.bo.SuperBo;

import java.sql.SQLException;
import java.util.List;

public interface PlaceSupplierBO extends SuperBo {

    List<String> genarateCode() throws SQLException;

    List<String> genarateId() throws SQLException;

    String generateNextOrderId() throws SQLException;

    String getName(String id) throws SQLException;

    boolean save(String orderId, double total, String custId, List<SupplierOrderDetailDTO> orderDto) throws SQLException;

    PartsDTO search(String code) throws SQLException;
}
