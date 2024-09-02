package lk.ijse.bo.custom.impl;

import lk.ijse.Model.OrderDetailDTO;
import lk.ijse.Model.PartsDTO;
import lk.ijse.bo.custom.PlaceOrderBO;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dao.custom.OrderDAO;
import lk.ijse.dao.custom.OrderDetailDAO;
import lk.ijse.dao.custom.PartsDAO;
import lk.ijse.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.dao.custom.impl.OrderDAOImpl;
import lk.ijse.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.dao.custom.impl.PartsDAOImpl;
import lk.ijse.db.DBConnection;
import lk.ijse.entity.OrderDetail;
import lk.ijse.entity.Parts;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    OrderDAO orderDAO = new OrderDAOImpl();
    PartsDAO partsDAO = new PartsDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
    @Override
    public List<String> genarateItemCode() throws SQLException {
        return partsDAO.genarateCode();
    }

    @Override
    public List<String> genarateCustomerId() throws SQLException {
        return customerDAO.genarateId();
    }

    @Override
    public String getNextOderId() throws SQLException {
       return orderDAO.getNextId();
    }

    @Override
    public boolean save(String orderId, double total, String custId, List<OrderDetailDTO> orderDto) throws SQLException {
        List<OrderDetail>orderDetails = new ArrayList<>();
        for (OrderDetailDTO orderDetailDTO : orderDto){
            orderDetails.add(new OrderDetail(orderDetailDTO.getCode(),orderDetailDTO.getQty(),orderDetailDTO.getUnitPrice(),orderDetailDTO.getTotal()));
        }

        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSave = orderDAO.save(orderId, LocalDate.now(),custId,total);
            if (isSave){
                boolean isUpdate = partsDAO.updateQtyOrder(orderDto);
                if (isUpdate){
                    boolean isSaveOrderDetail = orderDetailDAO.save( orderId,orderDetails);
                    if (isSaveOrderDetail){
                        connection.commit();
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public PartsDTO search(String code) throws SQLException {
        Parts parts = partsDAO.search(code);
        return new PartsDTO(parts.getItemCode(),parts.getDescription(),parts.getVehicleBrand(),parts.getUnitPrice(),parts.getQtyOnStock());
    }

    @Override
    public String getName(String id) throws SQLException {
        return customerDAO.getName(id);
    }
}
