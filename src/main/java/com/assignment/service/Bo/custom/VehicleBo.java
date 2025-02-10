package com.assignment.service.Bo.custom;

import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBo {

    public ArrayList<VehicleDto> getAllVehicle(String vehicleId) throws SQLException;

}
