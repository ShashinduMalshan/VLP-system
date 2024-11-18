package com.assignment.service.Model;

import com.assignment.service.Dto.DriverDto;
import com.assignment.service.Dto.ViolationPointDto;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DriverModel {

    public boolean  reduceDrivePoint(ViolationPointDto violationPointDto) throws SQLException {

        ResultSet lawPointResult = CrudUtil.execute("select law_point from TrafficViolationLaw where law_id=? ", violationPointDto.getLawId());
        System.out.println(lawPointResult);

        lawPointResult.next();

        int lawPoint = lawPointResult.getInt("law_point");
        return CrudUtil.execute(
                "update Driver set total_point = total_point + ? where driving_lic_num = ?",
                lawPoint,
                violationPointDto.getDriverLicenseNumber()

                );

    }



    public ArrayList<DriverDto> getAllDriver() throws SQLException {

        ResultSet rst = CrudUtil.execute("select * from Driver");
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
        ResultSet resultSet = CrudUtil.execute("select * from Driver");
        ArrayList<String> limitPassedIDs =new ArrayList<>();

        while (resultSet.next()) {

            if (resultSet.getInt(4) >= maxPoint) {
                limitPassedIDs.add(resultSet.getString(1));
            }
        }



        return limitPassedIDs;
    }

    public String driverCount() throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT COUNT(*) AS count FROM Driver");
        resultSet.next();

        return String.valueOf(resultSet.getInt(1));
    }

    public String suspendCount() throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT COUNT(*) AS count FROM SuspendLic");
        resultSet.next();

        return String.valueOf(resultSet.getInt(1));
    }

}
