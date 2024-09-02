package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ATTENDANCE,DASHBOARD,EMPLOYEE,ITEM,PLACEORDER,PLACESUPPLIER,SUPPLIES
    }

    public SuperBo getBo(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ATTENDANCE:
                return new AttendanceBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case SUPPLIES:
                return new SuppliesBOImpl();
            case DASHBOARD:
                return new DashboardBOImpl();
            case PLACEORDER:
                return new PlaceOrderBOImpl();
            case PLACESUPPLIER:
                return new PlaceSupplierBOImpl();
            default:
                return null;
        }
    }

}
