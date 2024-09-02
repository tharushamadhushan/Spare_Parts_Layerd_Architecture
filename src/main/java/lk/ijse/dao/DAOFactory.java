package lk.ijse.dao;

import lk.ijse.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

   }
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null)? daoFactory = new DAOFactory():daoFactory;
    }
   public enum DAOTypes{
        CUSTOMER,EMPLOYEE,SUPPLIER,ATTENDANCE,ORDER,ORDERDETAIL,PARTS,SUPPLIERORDER,SUPPLIERORDERDETAIL,USER
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ATTENDANCE:
                return new AttendanceDAOImpl();
            case USER:
                return new UserDAOImpl();
            case PARTS:
                return new PartsDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case ORDERDETAIL:
                return new OrderDetailDAOImpl();
            case SUPPLIERORDER:
                return new SupplierOrderDAOImpl();
            case SUPPLIERORDERDETAIL:
                return new SupplierOrderDetailDAOImpl();
            default:
                return null;
        }
    }
}
