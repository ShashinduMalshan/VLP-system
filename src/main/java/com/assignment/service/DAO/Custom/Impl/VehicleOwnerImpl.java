package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.DAO.Custom.OwnersDAO;
import com.assignment.service.DAO.Custom.VehicleDAO;
import com.assignment.service.Model.OwnersDto;
import com.assignment.service.Model.RevenueLicDto;
import com.assignment.service.Model.VehicleDto;
import com.assignment.service.DAO.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleOwnerImpl implements OwnersDAO {



    public ArrayList<OwnersDto> getAllOwners(String vehicleId) throws SQLException {

        ResultSet resultSet = SQLUtil.execute("select owner_id,name,email,address,mobile_no from VehicleOwner where vehicle_id = ?",vehicleId);

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


    @Override
    public ArrayList<OwnersDto> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(OwnersDto Dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(OwnersDto Dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    @Override
    public String getNextId() throws SQLException {
        return "";
    }

    @Override
    public ArrayList<String> checkSuspendId() throws SQLException {
        return null;
    }

    @Override
    public boolean isDuplicateId(String drivingLicNum) throws SQLException {
        return false;
    }
}
