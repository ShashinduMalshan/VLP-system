package com.assignment.service.Model;

import com.assignment.service.DBConnection.DBConnection;
import com.assignment.service.Dto.ViolationPointDto;
import com.assignment.service.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViolationPointModel     {

    public ArrayList<ViolationPointDto> getAllViolationPoints() throws SQLException {

        ResultSet rst = CrudUtil.execute("select * from ViolationPoint");

        ArrayList<ViolationPointDto> violationPointDTOS = new ArrayList<>();

        while (rst.next()) {
            ViolationPointDto violationPointDTO = new ViolationPointDto(

                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)
            );

            violationPointDTOS.add(violationPointDTO);

        }
        return violationPointDTOS;

    }
    DriverModel driverModel = new DriverModel();
    public boolean saveViolationPoints(ViolationPointDto violationPointDto) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        System.out.println(violationPointDto);
        try {
            connection.setAutoCommit(false);
            System.out.println("check first");
            boolean isSaveViolationPoints =  CrudUtil.execute(
                    "insert into ViolationPoint values (?,?,?,?,?,?,?,?,?)",
                    violationPointDto.getPoint_id(),
                    violationPointDto.getDescription(),
                    violationPointDto.getLocation(),
                    violationPointDto.getViolationTime(),
                    violationPointDto.getViolationDate(),
                    violationPointDto.getOfficerId(),
                    violationPointDto.getDriverLicenseNumber(),
                    violationPointDto.getRevenueLicenseNumber(),
                    violationPointDto.getLawId()
            );
            System.out.println("check 1");
            if(isSaveViolationPoints) {
                System.out.println("check 2");
                boolean updateDriverPoints = driverModel.reduceDrivePoint(violationPointDto);
                System.out.println(updateDriverPoints);
                if(updateDriverPoints) {
                    System.out.println("check 3");
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;

        }catch (SQLException e) {
            connection.rollback();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }


}
