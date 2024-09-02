package lk.ijse.bo.custom.impl;

import lk.ijse.Model.PartsDTO;
import lk.ijse.bo.custom.ItemBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.PartsDAO;
import lk.ijse.dao.custom.impl.PartsDAOImpl;
import lk.ijse.entity.Parts;

import java.sql.SQLException;

public class ItemBOImpl  implements ItemBO {

    PartsDAO partsDAO= (PartsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PARTS);

    @Override
    public PartsDTO search(String id) throws SQLException {
        Parts parts = partsDAO.search(id);
        return new PartsDTO(parts.getItemCode(),parts.getDescription(),parts.getVehicleBrand(),parts.getUnitPrice(),parts.getQtyOnStock());
    }

    @Override
    public boolean save(PartsDTO dto) throws SQLException {
        return partsDAO.save(new Parts(dto.getItemCode(),dto.getDescription(),dto.getVehicleBrand(),dto.getUnitPrice(),dto.getQtyOnStock()));
    }

    @Override
    public boolean Update(PartsDTO dto) throws SQLException {
        return partsDAO.Update(new Parts(dto.getItemCode(),dto.getDescription(),dto.getVehicleBrand(),dto.getUnitPrice(),dto.getQtyOnStock()));

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return partsDAO.delete(id);
    }
}
