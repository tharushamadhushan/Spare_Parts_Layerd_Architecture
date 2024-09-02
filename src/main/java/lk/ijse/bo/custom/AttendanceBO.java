package lk.ijse.bo.custom;

import lk.ijse.Model.AttendanceDTO;
import lk.ijse.Model.EmployeeDTO;
import lk.ijse.bo.SuperBo;

import java.sql.SQLException;

import java.util.List;

public interface AttendanceBO extends SuperBo {
    boolean saveAttendance(AttendanceDTO attendance) throws SQLException;

       List<String> generateEmployeeAttendance() throws SQLException;

    List<String> generateEmployeeId() throws SQLException;

    String getEmployeeName(String valueOf) throws SQLException;
}
