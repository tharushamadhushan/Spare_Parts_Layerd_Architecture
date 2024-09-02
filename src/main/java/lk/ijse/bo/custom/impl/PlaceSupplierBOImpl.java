package lk.ijse.bo.custom.impl;

import lk.ijse.Model.PartsDTO;
import lk.ijse.Model.SupplierOrderDetailDTO;
import lk.ijse.bo.custom.PlaceSupplierBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.*;
import lk.ijse.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.dao.custom.impl.SupplierOrderDAOImpl;
import lk.ijse.dao.custom.impl.SupplierOrderDetailDAOImpl;
import lk.ijse.db.DBConnection;
import lk.ijse.entity.Parts;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlaceSupplierBOImpl implements PlaceSupplierBO {
    PartsDAO partsDAO = (PartsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PARTS);
    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    OrderDAO orderDAO= (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    SupplierOrderDetailDAO supplierOrderDetailDAO = new SupplierOrderDetailDAOImpl();
    SupplierOrderDAO supplierOrderDAO = new SupplierOrderDAOImpl();
    SupplierDAO supplierDAO = new SupplierDAOImpl();


    @Override
    public List<String> genarateCode() throws SQLException {
        return partsDAO.genarateCode();
    }

    @Override
    public List<String> genarateId() throws SQLException {
        return supplierDAO.genarateId();
    }

    @Override
    public String generateNextOrderId() throws SQLException {
        return orderDAO.getNextId();
    }

    @Override
    public String getName(String id) throws SQLException {
        return supplierDAO.getName(id);
    }

    @Override
    public boolean save(String orderId, double total, String custId, List<SupplierOrderDetailDTO> orderDto) throws SQLException {
        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSave = supplierOrderDAO.save(orderId, LocalDate.now(),total);
            if (isSave){
                boolean isUpdate = partsDAO.updateQtyOrder1(orderDto);
                if (isUpdate){
                    boolean isSaveOrderDetail = supplierOrderDetailDAO.save( orderId,orderDto,total);
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
        Parts parts=partsDAO.search(code);
        return new PartsDTO(parts.getItemCode(),parts.getDescription(),parts.getVehicleBrand(),parts.getUnitPrice(),parts.getQtyOnStock());
    }
}
