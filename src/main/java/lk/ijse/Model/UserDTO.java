package lk.ijse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private String userName;
    private String userId;
    private String employeeId;
    private String userPassword;
}
