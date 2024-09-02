package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.Attendance;

import java.sql.SQLException;
import java.util.List;

public interface AttendanceDAO extends SuperDAO {
    public boolean save(Attendance attendance) throws SQLException;
}
