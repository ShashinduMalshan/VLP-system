package com.assignment.service.Model;

import com.assignment.service.Dto.VehicleDto;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleModel {

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

}
