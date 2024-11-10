package com.assignment.service.Model;

import com.assignment.service.Dto.ViolationPointDto;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}
