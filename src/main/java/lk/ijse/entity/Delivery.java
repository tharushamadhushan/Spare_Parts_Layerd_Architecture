package lk.ijse.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class Delivery {
    private String deliveryId;
    private String name;
    private Date date;
    private String contact;
}
