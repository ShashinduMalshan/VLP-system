package com.assignment.service.DAO.Impl;

import com.assignment.service.DAO.PoliceOfficerDAO;
import com.assignment.service.Model.PoliceOfficerDto;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PoliceOfficerImpl implements PoliceOfficerDAO {

    public ArrayList<PoliceOfficerDto> getAllOfficers() throws SQLException {

        ResultSet resultSet = CrudUtil.execute("select * from PoliceOfficer");

        ArrayList<PoliceOfficerDto> policeOfficerDtos = new ArrayList<>();

        while (resultSet.next()) {
            PoliceOfficerDto policeOfficerDto = new PoliceOfficerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
            policeOfficerDtos.add(policeOfficerDto);
        }
        return policeOfficerDtos;
    }


    public String getNextOfficerId() throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT officer_id FROM PoliceOfficer ORDER BY officer_id DESC LIMIT 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            int idNumber = Integer.parseInt(lastId.substring(2));
            int newIdIndex = idNumber + 1;
            return String.format("PO%03d", newIdIndex);
        }
        return "PO001"; // Default ID if no records exist
    }


    public boolean saveOfficerTBL(PoliceOfficerDto policeOfficerDto) throws SQLException {
            return CrudUtil.execute("insert into PoliceOfficer values (?,?,?)",

                    policeOfficerDto.getOfficerId(),
                    policeOfficerDto.getName(),
                    policeOfficerDto.getLocation());
    }


    public boolean updateOfficers(PoliceOfficerDto policeOfficerDto) throws SQLException {
        return CrudUtil.execute(
                "update PoliceOfficer set name=?, duty_location=? where officer_id=?",
                policeOfficerDto.getName(),
                policeOfficerDto.getLocation(),
                policeOfficerDto.getOfficerId()
        );
    }

    public boolean deleteOfficers(String policeOfficerId) throws SQLException {

        return CrudUtil.execute("delete from PoliceOfficer where officer_id = ?", policeOfficerId);

    }
}
