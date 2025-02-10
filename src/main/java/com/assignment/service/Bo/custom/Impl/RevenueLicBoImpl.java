package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.RevenueLicBo;
import com.assignment.service.DAO.Custom.Impl.RevenueLicImpl;
import com.assignment.service.DAO.Custom.RevenueLicDAO;
import com.assignment.service.Model.RevenueLicDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class RevenueLicBoImpl implements RevenueLicBo {

    RevenueLicDAO revenueLicModel = new RevenueLicImpl();


    public ArrayList<RevenueLicDto> getAllRevenueLic(String ownerId) throws SQLException {
        return revenueLicModel.getAllRevenueLic(ownerId);

    }
}
