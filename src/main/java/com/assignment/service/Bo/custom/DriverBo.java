package com.assignment.service.Bo.custom;

import com.assignment.service.Model.DriverDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DriverBo {

    ArrayList<DriverDto> loadTableData() throws SQLException;


    }
