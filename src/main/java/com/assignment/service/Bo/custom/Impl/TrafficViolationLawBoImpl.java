package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.TrafficViolationLawBo;
import com.assignment.service.DAO.Custom.Impl.TrafficViolationLawImpl;
import com.assignment.service.DAO.Custom.TrafficViolationLawDAO;
import com.assignment.service.Model.TrafficViolationLawDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrafficViolationLawBoImpl implements TrafficViolationLawBo {

    TrafficViolationLawDAO trafficViolationLawModel = new TrafficViolationLawImpl();


    public ArrayList<TrafficViolationLawDto> loadLawTableData() throws SQLException {

        return trafficViolationLawModel.getAllViolationLaws();
    }



    }
