package lk.ijse.bo.custom.impl;

import lk.ijse.Model.EmployeeDTO;
import lk.ijse.bo.SuperBo;
import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.entity.Employee;

import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO= new EmployeeDAOImpl();
    @Override
    public boolean save(EmployeeDTO employee) throws SQLException {
        return employeeDAO.save(new Employee(employee.getEmployeeName(),employee.getContact(),employee.getEmployeeId(),employee.getEmployeenic(),employee.getEmployeeAdress()));
    }

    @Override
    public EmployeeDTO search(String id) throws SQLException {
        Employee employee = employeeDAO.search(id);
        return new EmployeeDTO(employee.getEmployeeName(),employee.getContact(),employee.getEmployeeId(),employee.getEmployeenic(),employee.getEmployeeAdress());
    }

    @Override
    public boolean Update(EmployeeDTO employee) throws SQLException {
        return employeeDAO.Update(new Employee(employee.getEmployeeName(),employee.getContact(),employee.getEmployeeId(),employee.getEmployeenic(),employee.getEmployeeAdress()));

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return employeeDAO.delete(id);
    }
}
