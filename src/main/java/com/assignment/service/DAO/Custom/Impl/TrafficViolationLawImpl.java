package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.DAO.Custom.TrafficViolationLawDAO;
import com.assignment.service.Model.TrafficViolationLawDto;
import com.assignment.service.DAO.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrafficViolationLawImpl implements TrafficViolationLawDAO {

    public ArrayList<TrafficViolationLawDto> getAllViolationLaws() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("select * from TrafficViolationLaw");

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
        ResultSet resultSet = SQLUtil.execute("select count(*)from TrafficViolationLaw");

        while (resultSet.next()) {
            count = String.valueOf(resultSet.getInt(1));
        }
    return count;
    }

    public int HighViolationLaw() throws SQLException {
            ResultSet resultSet = SQLUtil.execute("SELECT count(*) FROM TrafficViolationLaw WHERE law_point >= 80");

            while (resultSet.next()) {
               return resultSet.getInt(1);
            }
        return 0;
    }



}
