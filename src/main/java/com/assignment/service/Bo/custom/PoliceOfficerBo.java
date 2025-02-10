package com.assignment.service.Bo.custom;

import com.assignment.service.Model.PoliceOfficerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PoliceOfficerBo {

    ArrayList<PoliceOfficerDto> loadTable() throws SQLException ;
    boolean delete(String OfficerId) throws SQLException;
    boolean update(PoliceOfficerDto policeOfficerDto) throws SQLException;
    boolean save(PoliceOfficerDto policeOfficerDto) throws SQLException ;


}
