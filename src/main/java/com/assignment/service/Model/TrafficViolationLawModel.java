package com.assignment.service.Model;

import com.assignment.service.Dto.TrafficViolationLawDto;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrafficViolationLawModel {

    public ArrayList<TrafficViolationLawDto> getAllViolationLaws() throws SQLException {
        ResultSet resultSet = CrudUtil.execute("select * from TrafficViolationLaw");

        ArrayList<TrafficViolationLawDto> trafficViolationLawDtos = new ArrayList<>();


        while (resultSet.next()) {
            TrafficViolationLawDto trafficViolationLawDto = new TrafficViolationLawDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3)
            );
            trafficViolationLawDtos.add(trafficViolationLawDto);

        }
        return trafficViolationLawDtos;
    }

    public String getAllLawCount() throws SQLException {

        String count ="";
        ResultSet resultSet = CrudUtil.execute("select count(*)from TrafficViolationLaw");

        while (resultSet.next()) {
            count = String.valueOf(resultSet.getInt(1));
        }
    return count;
    }

    public int HighViolationLaw() throws SQLException {
            ResultSet resultSet = CrudUtil.execute("SELECT count(*) FROM TrafficViolationLaw WHERE law_point >= 80");

            while (resultSet.next()) {
               return resultSet.getInt(1);
            }
        return 0;
    }



}
