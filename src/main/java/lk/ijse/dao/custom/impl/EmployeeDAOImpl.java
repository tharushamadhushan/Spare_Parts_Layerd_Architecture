package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    public boolean delete(String id) throws SQLException {
        String sql =  "DELETE FROM employee WHERE employeeId = ?";
        return SQLUtil.execute(sql,id);
    }

    public boolean save(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (employeeName,contact,employeeId,employeenic,employeeAdress)VALUES (?,?,?,?,?)";
        return SQLUtil.execute(sql,employee.getEmployeeName(),employee.getContact(),employee.getEmployeeId(),employee.getEmployeenic(),employee.getEmployeeAdress());

    }

    public Employee search(String id) throws SQLException {
        String sql="SELECT * FROM employee WHERE employeeId = ?";
        ResultSet resultSet=SQLUtil.execute(sql,id);

        if (resultSet.next()) {
            String employeeName = resultSet.getString(1);
            String contact = resultSet.getString(2);
            String employeeId = resultSet.getString(3);
            String employeenic = resultSet.getString(4);
            String employeeAdress = resultSet.getString(5);

            return new Employee(employeeName,contact,employeeId,employeenic,employeeAdress);
        }
        return null;
    }

    public boolean Update(Employee employee) throws SQLException {
        String sql = "UPDATE employee SET employeeName=?,contact=?,employeenic=?,employeeAdress=? WHERE employeeId=?";
        return SQLUtil.execute(sql,employee.getEmployeeName(),employee.getContact(),employee.getEmployeenic(),employee.getEmployeeAdress(),employee.getEmployeeId());
    }

    public List<String> generateEmployeeId() throws SQLException {
        String sql="SELECT employeeId FROM Employee";
        List<String> id =new ArrayList<>();

        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()){
            id.add(resultSet.getString(1));
        }
        return id;
    }

    public List<String> generateEmployeeAttendance() throws SQLException {
        String sql="SELECT employeeId FROM Employee";
        List<String> id =new ArrayList<>();

        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()){
            id.add(resultSet.getString(1));
        }
        return id;
    }

    @Override
    public String getName(String code) throws SQLException {
        String sql = "SELECT employeeName FROM Employee ";
        ResultSet resultSet =   SQLUtil.execute(sql);
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }


}
