package com.assignment.service.DAO.Custom;

import com.assignment.service.DAO.CrudDAO;
import com.assignment.service.Model.ViolationPointDto;

import java.sql.SQLException;

public interface DriverDAO  extends CrudDAO{

    boolean  reduceDrivePoint(ViolationPointDto violationPointDto) throws SQLException;
  //  ArrayList<Driver> getAllDriver() throws SQLException;
   // ArrayList<String> checkSuspendId() throws SQLException;
    String driverCount() throws SQLException;
    String suspendCount() throws SQLException;


}
