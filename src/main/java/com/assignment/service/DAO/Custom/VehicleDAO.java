package com.assignment.service.DAO.Custom;

import com.assignment.service.Model.OwnersDto;
import com.assignment.service.Model.RevenueLicDto;
import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDAO {

     ArrayList<VehicleDto> getAllVehicle(String vehicleID) throws SQLException;


}
