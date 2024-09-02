package lk.ijse.bo.custom.impl;

import lk.ijse.Model.AttendanceDTO;
import lk.ijse.bo.custom.AttendanceBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.AttendanceDAO;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.entity.Attendance;

import java.sql.SQLException;
import java.util.List;

public class AttendanceBOImpl implements AttendanceBO {

    AttendanceDAO attendanceDAO = (AttendanceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ATTENDANCE);
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public boolean saveAttendance(AttendanceDTO attendance) throws SQLException {
        return attendanceDAO.save(new Attendance(attendance.getEmployeeId(),attendance.getDate(),attendance.getAttendance()));

    }

    @Override
    public List<String> generateEmployeeAttendance() throws SQLException {
        return  employeeDAO.generateEmployeeAttendance();
    }

    @Override
    public List<String> generateEmployeeId() throws SQLException {
        return employeeDAO.generateEmployeeId();
    }

    @Override
    public String getEmployeeName(String valueOf) throws SQLException {
        return employeeDAO.getName(valueOf);
    }
}
