package com.assignment.service.Model;

import com.assignment.service.Dto.DateDto;
import com.assignment.service.Dto.TopViolatedLawDto;
import com.assignment.service.Dto.TopViolatedPointDto;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DashboardModel {

    public ArrayList<DateDto> getAllViolationMonth() throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT DATE_FORMAT(violation_date, '%b') AS violation_month, COUNT(*) AS violation_count FROM ViolationPoint GROUP BY violation_month ORDER BY violation_month ASC;");
        ArrayList<DateDto> dateDtos = new ArrayList<>();
        while (resultSet.next()) {
            DateDto dateDto = new DateDto(
                    resultSet.getString(1),
                    resultSet.getInt(2)
            );
            dateDtos.add(dateDto);
        }

        return dateDtos;


    }


    public ArrayList<DateDto> getAllSuspendLicByMonth() throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT DATE_FORMAT(time_duration, '%b') AS Suspended_month, COUNT(*) AS violation_count FROM SuspendLic GROUP BY Suspended_month ORDER BY Suspended_month ASC;");
        ArrayList<DateDto> SuspendLicDateDtos = new ArrayList<>();
        while (resultSet.next()) {
            DateDto dateDto = new DateDto(
                    resultSet.getString(1),
                    resultSet.getInt(2)
            );
            SuspendLicDateDtos.add(dateDto);
        }

        return SuspendLicDateDtos;


    }


    public ArrayList<TopViolatedLawDto> findTopViolatedLaw() throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT law_id AS violation_id, COUNT(*) AS id_count FROM ViolationPoint GROUP BY violation_id ORDER BY violation_id ASC LIMIT 12;\n");
        ArrayList<TopViolatedLawDto> topViolatedLaws= new ArrayList<>();

        while (resultSet.next()) {
            TopViolatedLawDto topViolatedLawDto = new TopViolatedLawDto(
                    resultSet.getString(1),
                    resultSet.getInt(2)
            );
            topViolatedLaws.add(topViolatedLawDto);

        }


        return topViolatedLaws;
    }


    public ArrayList<TopViolatedPointDto> findTopViolatedPoint() throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT law_id, law_point FROM TrafficViolationLaw ORDER BY law_point DESC LIMIT 06;");

        ArrayList<TopViolatedPointDto> topViolatedPoints= new ArrayList<>();

        while (resultSet.next()) {
            TopViolatedPointDto topViolatedPoint = new TopViolatedPointDto(
                    resultSet.getString(1),
                    resultSet.getInt(2)
            );
            topViolatedPoints.add(topViolatedPoint);

        }


        return topViolatedPoints;
    }





    public String driverCount() throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT COUNT(*) AS count FROM Driver");
        resultSet.next();

        return String.valueOf(resultSet.getInt(1));
    }


}