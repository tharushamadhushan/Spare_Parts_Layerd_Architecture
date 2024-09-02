package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {
    private String custId;
    private String custName;
    private String contact;
    private String custNic;

//    public Customer(String custId,String custName,String contact,String custNic){
//        this.setCustId(custId);
//        this.setCustName(custName);
//        this.setContact(contact);
//        this.setCustNic(custNic);
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
//    public String getCustName() {
//        return custName;
//    }
//
//    public void setCustName(String custName) {
//        this.custName = custName;
//    }
//
//    public String getContact() {
//        return contact;
//    }
//
//    public void setContact(String contact) {
//        this.contact = contact;
//    }
//
//    public String getCustNic() {
//        return custNic;
//    }
//
//    public void setCustNic(String custNic) {
//        this.custNic = custNic;
//    }
}
