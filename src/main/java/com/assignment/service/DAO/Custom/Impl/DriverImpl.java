package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.DAO.Custom.DriverDAO;
import com.assignment.service.Model.DriverDto;
import com.assignment.service.Model.PoliceOfficerDto;
import com.assignment.service.Model.ViolationPointDto;
import com.assignment.service.DAO.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DriverImpl implements DriverDAO {

    public boolean  reduceDrivePoint(ViolationPointDto violationPointDto) throws SQLException {

        ResultSet lawPointResult = SQLUtil.execute("select law_point from TrafficViolationLaw where law_id=? ", violationPointDto.getLawId());
        System.out.println(lawPointResult);

        lawPointResult.next();

        int lawPoint = lawPointResult.getInt("law_point");
        return SQLUtil.execute(
                "update Driver set total_point = total_point + ? where driving_lic_num = ?",
                lawPoint,
                violationPointDto.getDriverLicenseNumber()

                );

    }



    public ArrayList<DriverDto> getAll() throws SQLException {

        ResultSet rst = SQLUtil.execute("select * from Driver");
        ArrayList<DriverDto> driverDtos = new ArrayList<>();

        while (rst.next()) {
            DriverDto driverDto = new DriverDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4)
            );
            driverDtos.add(driverDto);

        }
        System.out.println(driverDtos);
        return driverDtos;
    }


    public ArrayList<String> checkSuspendId() throws SQLException {

        int maxPoint = 150;
        ResultSet resultSet = SQLUtil.execute("select * from Driver");
        ArrayList<String> limitPassedIDs =new ArrayList<>();

        while (resultSet.next()) {

            if (resultSet.getInt(4) >= maxPoint) {
                limitPassedIDs.add(resultSet.getString(1));
            }
        }



        return limitPassedIDs;
    }

    @Override
    public boolean isDuplicateId(String drivingLicNum) throws SQLException {
        return false;
    }


    public String driverCount() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) AS count FROM Driver");
        resultSet.next();

        return String.valueOf(resultSet.getInt(1));
    }

    public String suspendCount() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) AS count FROM SuspendLic");
        resultSet.next();

        return String.valueOf(resultSet.getInt(1));
    }


    @Override
    public String getNextId() throws SQLException {
        return "";
    }


    @Override
    public boolean save(Object Dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Object Dto) throws SQLException {
        return false;
    }


    @Override
    public boolean delete(String policeOfficerId) throws SQLException {
        return false;
    }

}
