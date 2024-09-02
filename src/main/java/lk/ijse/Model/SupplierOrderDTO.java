package lk.ijse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class SupplierOrderDTO {
    private String supplierOrderID;
    private Date date;
    private double total;

}
