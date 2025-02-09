package com.assignment.service.Bo;

import com.assignment.service.DAO.Custom.Impl.ViolationPointImpl;
import com.assignment.service.Model.ViolationPointDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ViolationPointBoImpl {

    ViolationPointImpl violationPointImpl =new ViolationPointImpl();



    public ArrayList<ViolationPointDto> loadTableData() throws SQLException {

        return violationPointImpl.getAllViolationPoints();
    }

    }
