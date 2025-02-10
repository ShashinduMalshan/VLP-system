package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.ViolationPointBo;
import com.assignment.service.DAO.Custom.Impl.ViolationPointImpl;
import com.assignment.service.Model.ViolationPointDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ViolationPointBoImpl implements ViolationPointBo {

    ViolationPointImpl violationPointImpl =new ViolationPointImpl();



    public ArrayList<ViolationPointDto> loadTableData() throws SQLException {

        return violationPointImpl.getAllViolationPoints();
    }


    public boolean save(ViolationPointDto violationPointDto) throws SQLException {

            return violationPointImpl.saveViolationPoints(violationPointDto);
    }

    }
