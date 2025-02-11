package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.RevenueLicBo;
import com.assignment.service.DAO.Custom.Impl.RevenueLicImpl;
import com.assignment.service.DAO.Custom.RevenueLicDAO;
import com.assignment.service.DAO.DAOFactory;
import com.assignment.service.Model.RevenueLicDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class RevenueLicBoImpl implements RevenueLicBo {

    RevenueLicDAO revenueLicModel = (RevenueLicDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.REVENUE_LIC);


    @Override
    public ArrayList<RevenueLicDto> loadTableData() throws SQLException {
        return null;
    }

    @Override
    public boolean isDuplicateId(String Id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(RevenueLicDto policeOfficerDto) throws SQLException {
        return false;
    }

    @Override
    public boolean save(RevenueLicDto policeOfficerDto) throws SQLException {
        return false;
    }

    public ArrayList<RevenueLicDto> getAll(String ownerId) throws SQLException {
        return revenueLicModel.getAllRevenueLic(ownerId);

    }
}
