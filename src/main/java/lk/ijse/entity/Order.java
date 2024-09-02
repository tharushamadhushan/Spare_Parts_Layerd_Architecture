package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Order {
    private String orderId;
    private Date orderDate;
    private String custId;
    private Double total;

//    public Order(String orderId,Date orderDate,String custId,Double total){
//        this.setOrderId(orderId);
//        this.setOrderDate(orderDate);
//        this.setCustId(custId);
//        this.setTotal(total);
//    }
//
//    public String getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
//    }
//
//    public Date getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(Date orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public String getCustId() {
//        return custId;
//    }
//
//    public void setCustId(String custId) {
//        this.custId = custId;
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
