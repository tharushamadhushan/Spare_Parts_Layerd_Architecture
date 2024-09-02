package lk.ijse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AttendanceDTO {
    private String employeeId;
    private Date date;
    private String attendance;


}
