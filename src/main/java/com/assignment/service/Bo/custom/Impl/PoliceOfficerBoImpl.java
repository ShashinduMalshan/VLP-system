package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.PoliceOfficerBo;
import com.assignment.service.DAO.Custom.Impl.PoliceOfficerImpl;
import com.assignment.service.DAO.Custom.PoliceOfficerDAO;
import com.assignment.service.DAO.DAOFactory;
import com.assignment.service.Model.PoliceOfficerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class PoliceOfficerBoImpl implements PoliceOfficerBo {

    PoliceOfficerDAO policeOfficerImpl  = (PoliceOfficerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.POLICE_OFFICER);


    public ArrayList<PoliceOfficerDto> loadTableData() throws SQLException {

        return policeOfficerImpl.getAll();
    }

    @Override
    public boolean isDuplicateId(String Id) throws SQLException {
        return false;
    }


    public boolean delete(String Id) throws SQLException {

        return policeOfficerImpl.delete(Id);
    }


    public boolean update(PoliceOfficerDto policeOfficerDto) throws SQLException {

        return policeOfficerImpl.update(policeOfficerDto);
    }


    public boolean save(PoliceOfficerDto policeOfficerDto) throws SQLException {

            return policeOfficerImpl.save(policeOfficerDto);
        }

    @Override
    public ArrayList<PoliceOfficerDto> getAll(String vehicleId) throws SQLException {
        return null;
    }


}
