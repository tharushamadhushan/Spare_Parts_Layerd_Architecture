package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Attendance {
        private String employeeId;
        private Date date;
        private String attendance;

//        public Attendance(String employeeId,Date date,String attendance){
//                this.setEmployeeId(employeeId);
//                this.setDate(date);
//                this.setAttendance(attendance);
//        }
//
//        public String getEmployeeId() {
//                return employeeId;
//        }
//
//        public void setEmployeeId(String employeeId) {
//                this.employeeId = employeeId;
//        }
//
//        public Date getDate() {
//                return date;
//        }
//
//        public void setDate(Date date) {
//                this.date = date;
//        }
//
//        public String getAttendance() {
//                return attendance;
//        }
//
//        public void setAttendance(String attendance) {
//                this.attendance = attendance;
//        }
}
