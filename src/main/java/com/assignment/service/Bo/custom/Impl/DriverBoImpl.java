package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.DriverBo;
import com.assignment.service.DAO.Custom.DriverDAO;
import com.assignment.service.DAO.Custom.Impl.DriverImpl;
import com.assignment.service.Model.DriverDto;
import com.assignment.service.Model.PoliceOfficerDto;
import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class DriverBoImpl implements DriverBo {

    DriverDAO driverDAO = new DriverImpl();

    public ArrayList<DriverDto> loadTableData() throws SQLException {
        return driverDAO.getAll();
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
    public boolean update(DriverDto policeOfficerDto) throws SQLException {
        return false;
    }

    @Override
    public boolean save(DriverDto policeOfficerDto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<DriverDto> getAll(String vehicleId) throws SQLException {
        return null;
    }


}
