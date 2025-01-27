package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.DAO.Custom.VehicleDAO;
import com.assignment.service.Model.OwnersDto;
import com.assignment.service.Model.RevenueLicDto;
import com.assignment.service.Model.VehicleDto;
import com.assignment.service.DAO.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RevenueLicImpl implements VehicleDAO {


    public ArrayList<RevenueLicDto> getAllRevenueLic(String ownerId) throws SQLException {

        ResultSet resultSet = SQLUtil.execute("select * from Revenue_Lic where owner_id = ?", ownerId);

        ArrayList<RevenueLicDto> revenueLicDtos = new ArrayList<>();

        while (resultSet.next()) {
            RevenueLicDto revenueLicDto = new RevenueLicDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
            revenueLicDtos.add(revenueLicDto);
        }
        return revenueLicDtos;
    }

    @Override
    public ArrayList<VehicleDto> getAllVehicle(String vehicleID) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<OwnersDto> getAllOwners(String vehicleId) throws SQLException {
        return null;
    }


}
