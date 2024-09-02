package lk.ijse.Model.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor

public class AttendanceTm {
    private String id;
    private String date;
    private LocalTime time;
    private String attendance;

    public AttendanceTm(String id, LocalDate date, LocalTime now, String text) {

    }
}

