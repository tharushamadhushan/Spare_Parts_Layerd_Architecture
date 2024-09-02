package lk.ijse.dao.custom;

import lk.ijse.Model.SupplierOrderDetailDTO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.SupplierOrderDetail;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface SupplierOrderDetailDAO extends SuperDAO {

    public boolean save(String orderId, List<SupplierOrderDetailDTO> orderDtoList, double total) throws SQLException;
}
