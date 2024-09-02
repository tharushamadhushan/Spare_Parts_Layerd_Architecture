package lk.ijse.bo.custom.impl;

import lk.ijse.Model.SupplierDTO;
import lk.ijse.bo.custom.SuppliesBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.SupplierDAO;
import lk.ijse.entity.Supplier;

import java.sql.SQLException;

public class SuppliesBOImpl implements SuppliesBO {

    SupplierDAO supplierDAO= (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean delete(String id) throws SQLException {
        return supplierDAO.delete(id);
    }

    @Override
    public boolean save(SupplierDTO supplier) throws SQLException {
        return supplierDAO.save(new Supplier(supplier.getSuppliersID(),supplier.getContact(),supplier.getSuppliersName(),supplier.getSuppliersNic(),supplier.getSuppliersAdress()));
    }

    @Override
    public SupplierDTO search(String id) throws SQLException {
        Supplier supplier=supplierDAO.search(id);
        return new SupplierDTO(supplier.getSuppliersID(),supplier.getContact(),supplier.getSuppliersName(),supplier.getSuppliersNic(),supplier.getSuppliersAdress());
    }

    @Override
    public boolean update(SupplierDTO suppliers) throws SQLException {
        return supplierDAO.Update(new Supplier(suppliers.getSuppliersID(),suppliers.getContact(),suppliers.getSuppliersName(),suppliers.getSuppliersNic(),suppliers.getSuppliersAdress()));
    }
}
