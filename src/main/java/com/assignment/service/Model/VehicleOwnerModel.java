package com.assignment.service.Model;

import com.assignment.service.Dto.OwnersDto;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleOwnerModel {

    public ArrayList<OwnersDto> getAllOwners(String vehicleId) throws SQLException {

        ResultSet resultSet = CrudUtil.execute("select owner_id,name,email,address,mobile_no from VehicleOwner where vehicle_id = ?",vehicleId);

        ArrayList<OwnersDto> ownersDtos = new ArrayList<>();

        while (resultSet.next()) {
            OwnersDto ownersDto = new OwnersDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)
            );
            ownersDtos.add(ownersDto);
        }
        return ownersDtos;
    }

}
