package lk.ijse.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplierOrderDetail {
    private String supplierOrderId;
    private String itemCode;
    private Integer odrderQty;
    private Double total;
}
