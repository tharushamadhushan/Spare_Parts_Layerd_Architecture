package lk.ijse.dao.custom;

import lk.ijse.Model.OrderDetailDTO;
import lk.ijse.Model.SupplierOrderDetailDTO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.entity.Parts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface PartsDAO extends CrudDAO<Parts> {

    public List<String> genarateCode() throws SQLException ;

    public String getNextId() throws SQLException ;


    public boolean updateQtyOrder(List<OrderDetailDTO> orderDtoList) throws SQLException ;


    public boolean updateQtyOrder1(List<SupplierOrderDetailDTO> orderDtoList) throws SQLException ;


    public int countItem() throws SQLException ;
}
