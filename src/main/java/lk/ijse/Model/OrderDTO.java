package lk.ijse.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class OrderDTO {
    private String orderId;
    private Date orderDate;
    private String custId;
    private Double total;
}
