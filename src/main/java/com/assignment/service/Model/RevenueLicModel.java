package com.assignment.service.Model;

import com.assignment.service.Dto.RevenueLicDto;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RevenueLicModel {

    public ArrayList<RevenueLicDto> getAllRevenueLic(String ownerId) throws SQLException {

        ResultSet resultSet = CrudUtil.execute("select * from Revenue_Lic where owner_id = ?", ownerId);

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

}
