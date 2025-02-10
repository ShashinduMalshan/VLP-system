package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.SuspendedLicBo;
import com.assignment.service.DAO.Custom.Impl.SuspendLicImpl;
import com.assignment.service.DAO.Custom.SuspendDAO;
import com.assignment.service.Model.SuspendLicDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class SuspendedLicBoImpl implements SuspendedLicBo {

    SuspendDAO  suspendLicModel = new SuspendLicImpl();

    public ArrayList<SuspendLicDto> loadTable() throws SQLException {

        return suspendLicModel.getAll();


    }




    }
