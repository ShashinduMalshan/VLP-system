package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.SuspendedLicBo;
import com.assignment.service.DAO.Custom.Impl.SuspendLicImpl;
import com.assignment.service.DAO.Custom.SuspendDAO;
import com.assignment.service.DAO.DAOFactory;
import com.assignment.service.Model.SuspendLicDto;
import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class SuspendedLicBoImpl implements SuspendedLicBo {

    SuspendDAO  suspendLicModel = (SuspendDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUSPEND_LIC);

    public ArrayList<SuspendLicDto> loadTableData() throws SQLException {

        return suspendLicModel.getAll();


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
    public boolean update(SuspendLicDto policeOfficerDto) throws SQLException {
        return false;
    }

    @Override
    public boolean save(SuspendLicDto policeOfficerDto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<SuspendLicDto> getAll(String vehicleId) throws SQLException {
        return null;
    }


}
