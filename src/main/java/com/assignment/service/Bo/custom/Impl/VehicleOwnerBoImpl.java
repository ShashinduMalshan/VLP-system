package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.VehicleBo;
import com.assignment.service.Bo.custom.VehicleOwnerBo;
import com.assignment.service.DAO.Custom.Impl.RevenueLicImpl;
import com.assignment.service.DAO.Custom.Impl.VehicleImpl;
import com.assignment.service.DAO.Custom.Impl.VehicleOwnerImpl;
import com.assignment.service.DAO.Custom.OwnersDAO;
import com.assignment.service.DAO.Custom.RevenueLicDAO;
import com.assignment.service.DAO.Custom.VehicleDAO;
import com.assignment.service.DAO.DAOFactory;
import com.assignment.service.Model.OwnersDto;
import com.assignment.service.Model.RevenueLicDto;
import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleOwnerBoImpl implements VehicleOwnerBo {

    OwnersDAO vehicleOwnerModel = (OwnersDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.OWNERS);

    @Override
    public ArrayList<OwnersDto> loadTableData() throws SQLException {
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
    public boolean update(OwnersDto policeOfficerDto) throws SQLException {
        return false;
    }

    @Override
    public boolean save(OwnersDto policeOfficerDto) throws SQLException {
        return false;
    }

    public ArrayList<OwnersDto> getAll(String vehicleId) throws SQLException {
        return vehicleOwnerModel.getAllOwners(vehicleId);

    }








}