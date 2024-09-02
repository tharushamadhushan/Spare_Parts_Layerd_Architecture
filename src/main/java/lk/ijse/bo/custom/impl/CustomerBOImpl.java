package lk.ijse.bo.custom.impl;

import lk.ijse.Model.CustomerDTO;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.entity.Customer;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO=new CustomerDAOImpl();
    @Override
    public boolean delete(String id) throws SQLException {
       return customerDAO.delete(id);
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException {
        return customerDAO.save(new Customer(dto.getCustId(),dto.getCustName(),dto.getContact(),dto.getCustNic()));
    }

    @Override
    public CustomerDTO search(String id) throws SQLException {
        Customer customer=customerDAO.search(id);
        return new CustomerDTO(customer.getCustId(),customer.getCustName(),customer.getContact(),customer.getCustNic());
    }

    @Override
    public boolean Update(CustomerDTO dto) throws SQLException {
        return customerDAO.Update(new Customer(dto.getCustId(),dto.getCustName(),dto.getContact(),dto.getCustNic()));
    }
}
