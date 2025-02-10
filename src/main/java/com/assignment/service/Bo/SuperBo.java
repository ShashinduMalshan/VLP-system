package com.assignment.service.Bo;

import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SuperBo <T>{

    ArrayList<T> loadTableData() throws SQLException;
    boolean isDuplicateId(String Id) throws SQLException ;
    boolean delete(String Id) throws SQLException;
    boolean update(T policeOfficerDto) throws SQLException;
    boolean save(T policeOfficerDto) throws SQLException ;
    ArrayList<T> getAll(String vehicleId) throws SQLException;



}

