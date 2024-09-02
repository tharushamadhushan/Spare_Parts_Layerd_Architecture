package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderDetail {
    private String code;
    private Integer qty;
    private Double unitPrice;
    private Double total;

//    public OrderDetail(String code, Integer qty, Double unitPrice, Double total){
//        this.setCode(code);
//        this.setQty(qty);
//        this.setUnitPrice(unitPrice);
//        this.setTotal(total);
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public Integer getQty() {
//        return qty;
//    }
//
//    public void setQty(Integer qty) {
//        this.qty = qty;
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
//    public Double getTotal() {
//        return total;
//    }
//
//    public void setTotal(Double total) {
//        this.total = total;
//    }
}
