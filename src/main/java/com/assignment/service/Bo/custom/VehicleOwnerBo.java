package com.assignment.service.Bo.custom;

import com.assignment.service.Model.OwnersDto;
import com.assignment.service.Model.RevenueLicDto;
import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleOwnerBo {


    public ArrayList<OwnersDto> getAllOwners(String vehicleId) throws SQLException;

}
