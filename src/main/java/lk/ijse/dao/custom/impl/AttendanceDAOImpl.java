package lk.ijse.dao.custom.impl;

//import lk.ijse.Util.CrudUtil;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.AttendanceDAO;
import lk.ijse.entity.Attendance;

import java.sql.SQLException;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {

    @Override
    public boolean save(Attendance attendance) throws SQLException {
            String sql = "INSERT INTO attendance (employeeId,attendance,date) VALUES (?,?,?)";
            return SQLUtil.execute(sql,attendance.getEmployeeId(),attendance.getAttendance(),attendance.getDate());

    }

}
