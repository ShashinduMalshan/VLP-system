package com.assignment.service.Bo;

import com.assignment.service.Model.DriverDto;
import com.assignment.service.Model.PoliceOfficerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SuperBo <T>{

    ArrayList<T> loadTableData() throws SQLException;
    boolean isDuplicateId(String Id) throws SQLException ;
    boolean delete(String Id) throws SQLException;
    boolean update(T policeOfficerDto) throws SQLException;
    boolean save(T policeOfficerDto) throws SQLException ;



}
