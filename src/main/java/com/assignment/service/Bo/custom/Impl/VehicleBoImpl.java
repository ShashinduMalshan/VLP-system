package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.VehicleBo;
import com.assignment.service.DAO.Custom.Impl.VehicleImpl;
import com.assignment.service.DAO.Custom.VehicleDAO;
import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBoImpl implements VehicleBo {

    VehicleDAO vehicleModel = new VehicleImpl();



    public ArrayList<VehicleDto> getAll(String Id) throws SQLException {
        return vehicleModel.getAllVehicle(Id);
    }


    @Override
    public ArrayList<VehicleDto> loadTableData() throws SQLException {
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
    public boolean update(VehicleDto policeOfficerDto) throws SQLException {
        return false;
    }

    @Override
    public boolean save(VehicleDto policeOfficerDto) throws SQLException {
        return false;
    }
}
