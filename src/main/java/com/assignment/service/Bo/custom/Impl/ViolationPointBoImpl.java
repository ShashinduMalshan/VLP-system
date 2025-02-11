package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.ViolationPointBo;
import com.assignment.service.DAO.Custom.Impl.ViolationPointImpl;
import com.assignment.service.DAO.DAOFactory;
import com.assignment.service.Model.ViolationPointDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class ViolationPointBoImpl implements ViolationPointBo {

    ViolationPointImpl violationPointImpl = (ViolationPointImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VIOLATION_POINT);



    public ArrayList<ViolationPointDto> loadTableData() throws SQLException {

        return violationPointImpl.getAll();
    }


    public boolean save(ViolationPointDto violationPointDto) throws SQLException {

            return violationPointImpl.save(violationPointDto);
    }

    }
