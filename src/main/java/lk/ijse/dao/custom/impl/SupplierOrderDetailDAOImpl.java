package lk.ijse.dao.custom.impl;

import lk.ijse.Model.SupplierDTO;
import lk.ijse.Model.SupplierOrderDetailDTO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.SupplierOrderDetailDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class SupplierOrderDetailDAOImpl implements SupplierOrderDetailDAO {
    public boolean save(String orderId, List<SupplierOrderDetailDTO> orderDtoList, double total) throws SQLException {
        for (SupplierOrderDetailDTO dto : orderDtoList){
            if (!save(orderId,dto,total)){
                return false;
            }
        }
        return true;
    }

    private boolean save(String orderId, SupplierOrderDetailDTO dto, double total) throws SQLException {
        String sql = "INSERT INTO suppliersorderdetail VALUES(?,?,?,?)";
        return SQLUtil.execute(sql,orderId,dto.getItemCode(),dto.getOdrderQty(),total);
    }

}
