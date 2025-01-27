package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.DAO.Custom.PoliceOfficerDAO;
import com.assignment.service.Model.PoliceOfficerDto;
import com.assignment.service.DAO.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PoliceOfficerImpl implements PoliceOfficerDAO {

    public ArrayList<PoliceOfficerDto> getAll() throws SQLException {

        ResultSet resultSet = SQLUtil.execute("select * from PoliceOfficer");

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



    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT officer_id FROM PoliceOfficer ORDER BY officer_id DESC LIMIT 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            int idNumber = Integer.parseInt(lastId.substring(2));
            int newIdIndex = idNumber + 1;
            return String.format("PO%03d", newIdIndex);
        }
        return "PO001"; // Default ID if no records exist
    }


    public boolean save(PoliceOfficerDto policeOfficerDto) throws SQLException {
            return SQLUtil.execute("insert into PoliceOfficer values (?,?,?)",

                    policeOfficerDto.getOfficerId(),
                    policeOfficerDto.getName(),
                    policeOfficerDto.getLocation());
    }


    public boolean update(PoliceOfficerDto policeOfficerDto) throws SQLException {
        return SQLUtil.execute(
                "update PoliceOfficer set name=?, duty_location=? where officer_id=?",
                policeOfficerDto.getName(),
                policeOfficerDto.getLocation(),
                policeOfficerDto.getOfficerId()
        );
    }

    public boolean delete(String policeOfficerId) throws SQLException {

        return SQLUtil.execute("delete from PoliceOfficer where officer_id = ?", policeOfficerId);

    }


    @Override
    public ArrayList<String> checkSuspendId() throws SQLException {
        return null;
    }

    @Override
    public boolean isDuplicateId(String drivingLicNum) throws SQLException {
        return false;
    }



}
