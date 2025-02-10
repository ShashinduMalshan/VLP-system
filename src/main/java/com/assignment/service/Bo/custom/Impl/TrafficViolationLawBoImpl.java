package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.TrafficViolationLawBo;
import com.assignment.service.DAO.Custom.Impl.TrafficViolationLawImpl;
import com.assignment.service.DAO.Custom.TrafficViolationLawDAO;
import com.assignment.service.Model.TrafficViolationLawDto;
import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrafficViolationLawBoImpl implements TrafficViolationLawBo {

    TrafficViolationLawDAO trafficViolationLawModel = new TrafficViolationLawImpl();


    public ArrayList<TrafficViolationLawDto> loadTableData() throws SQLException {

        return trafficViolationLawModel.getAllViolationLaws();
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
    public boolean update(TrafficViolationLawDto policeOfficerDto) throws SQLException {
        return false;
    }

    @Override
    public boolean save(TrafficViolationLawDto policeOfficerDto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<TrafficViolationLawDto> getAll(String vehicleId) throws SQLException {
        return null;
    }
}
