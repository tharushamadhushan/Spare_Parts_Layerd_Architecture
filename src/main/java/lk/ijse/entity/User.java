package lk.ijse.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String userName;
    private String userId;
    private String employeeId;
    private String userPassword;
}
