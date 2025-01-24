package com.assignment.service.DAO.Impl;

import com.assignment.service.DAO.VehicleDAO;
import com.assignment.service.Model.OwnersDto;
import com.assignment.service.Model.RevenueLicDto;
import com.assignment.service.Model.VehicleDto;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleImpl implements VehicleDAO {

    public ArrayList<VehicleDto> getAllVehicle(String vehicleID) throws SQLException {

        ResultSet resultSet = CrudUtil.execute("select model,brand_name from Vehicle where vehicle_id = ?", vehicleID);

        ArrayList<VehicleDto> vehicleDtos = new ArrayList<>();

        while (resultSet.next()) {
            VehicleDto vehicleDto = new VehicleDto(
                    resultSet.getString(1),
                    resultSet.getString(2)
            );
            vehicleDtos.add(vehicleDto);
        }
        return vehicleDtos;
    }

    @Override
    public ArrayList<OwnersDto> getAllOwners(String vehicleId) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<RevenueLicDto> getAllRevenueLic(String ownerId) throws SQLException {
        return null;
    }

}
