package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.DAO.Custom.VehicleDAO;
import com.assignment.service.Model.OwnersDto;
import com.assignment.service.Model.RevenueLicDto;
import com.assignment.service.Model.VehicleDto;
import com.assignment.service.DAO.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleImpl implements VehicleDAO {

    public ArrayList<VehicleDto> getAllVehicle(String vehicleID) throws SQLException {

        ResultSet resultSet = SQLUtil.execute("select model,brand_name from Vehicle where vehicle_id = ?", vehicleID);

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
    public ArrayList<VehicleDto> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(VehicleDto Dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(VehicleDto Dto) throws SQLException {
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
