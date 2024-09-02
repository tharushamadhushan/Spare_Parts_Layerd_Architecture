package lk.ijse.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;

@Data
@AllArgsConstructor
public class SupplierOrder {
    private String supplierOrderID;
    private Date date;
    private double total;
}
