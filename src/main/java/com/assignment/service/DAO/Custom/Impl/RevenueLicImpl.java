package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.DAO.Custom.RevenueLicDAO;
import com.assignment.service.DAO.Custom.VehicleDAO;
import com.assignment.service.Model.OwnersDto;
import com.assignment.service.Model.RevenueLicDto;
import com.assignment.service.Model.VehicleDto;
import com.assignment.service.DAO.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RevenueLicImpl implements RevenueLicDAO {


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
    public ArrayList<RevenueLicDto> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(RevenueLicDto Dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(RevenueLicDto Dto) throws SQLException {
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
