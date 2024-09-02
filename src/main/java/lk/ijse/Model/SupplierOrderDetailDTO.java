package lk.ijse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SupplierOrderDetailDTO {
    private String supplierOrderId;
    private String itemCode;
    private Integer odrderQty;
    private Double total;
}