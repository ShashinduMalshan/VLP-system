package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.DriverBo;
import com.assignment.service.DAO.Custom.DriverDAO;
import com.assignment.service.DAO.Custom.Impl.DriverImpl;
import com.assignment.service.Model.DriverDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class DriverBoImpl implements DriverBo {

    DriverDAO driverDAO = new DriverImpl();

    public ArrayList<DriverDto> loadTableData() throws SQLException {
        return driverDAO.getAll();
    }

    }
