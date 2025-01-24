package com.assignment.service.DAO;

import com.assignment.service.Model.DriverDto;
import com.assignment.service.Model.ViolationPointDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DriverDAO {

    boolean  reduceDrivePoint(ViolationPointDto violationPointDto) throws SQLException;
    ArrayList<DriverDto> getAllDriver() throws SQLException;
    ArrayList<String> checkSuspendId() throws SQLException;
    String driverCount() throws SQLException;
    String suspendCount() throws SQLException;


}
