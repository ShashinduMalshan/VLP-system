package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.VehicleBo;
import com.assignment.service.DAO.Custom.Impl.VehicleImpl;
import com.assignment.service.DAO.Custom.VehicleDAO;
import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBoImpl implements VehicleBo {

    VehicleDAO vehicleModel = new VehicleImpl();



    public ArrayList<VehicleDto> getAllVehicle(String vehicleId) throws SQLException {
        return vehicleModel.getAllVehicle(vehicleId);
    }
}
