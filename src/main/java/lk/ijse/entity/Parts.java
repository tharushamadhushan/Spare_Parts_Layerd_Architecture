package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Parts {
    private String itemCode;
    private String description;
    private String vehicleBrand;
    private Double unitPrice;
    private Integer qtyOnStock;

//    public Parts(String itemCode, String description, String vehicleBrand, Double unitPrice, Integer qtyOnStock){
//        this.setItemCode(itemCode);
//        this.setDescription(description);
//        this.setVehicleBrand(vehicleBrand);
//        this.setUnitPrice(unitPrice);
//        this.setQtyOnStock(qtyOnStock);
//    }
//
//    public String getItemCode() {
//        return itemCode;
//    }
//
//    public void setItemCode(String itemCode) {
//        this.itemCode = itemCode;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getVehicleBrand() {
//        return vehicleBrand;
//    }
//
//    public void setVehicleBrand(String vehicleBrand) {
//        this.vehicleBrand = vehicleBrand;
//    }
//
//    public Double getUnitPrice() {
//        return unitPrice;
//    }
//
//    public void setUnitPrice(Double unitPrice) {
//        this.unitPrice = unitPrice;
//    }
//
//    public Integer getQtyOnStock() {
//        return qtyOnStock;
//    }
//
//    public void setQtyOnStock(Integer qtyOnStock) {
//        this.qtyOnStock = qtyOnStock;
//    }
//
//    public String[] split(String o00) {
//        return new String[0];
//    }

}
