package com.assignment.service.Model;

import com.assignment.service.Dto.ViolationPointDto;
import com.assignment.service.util.CrudUtil;

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
}
