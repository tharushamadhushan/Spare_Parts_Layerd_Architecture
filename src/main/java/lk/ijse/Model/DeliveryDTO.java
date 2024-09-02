package lk.ijse.Model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryDTO {
    private String deliveryId;
    private String name;
    private Date date;
    private String contact;
}
