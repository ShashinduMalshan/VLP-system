package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.VehicleBo;
import com.assignment.service.Bo.custom.VehicleOwnerBo;
import com.assignment.service.DAO.Custom.Impl.RevenueLicImpl;
import com.assignment.service.DAO.Custom.Impl.VehicleImpl;
import com.assignment.service.DAO.Custom.Impl.VehicleOwnerImpl;
import com.assignment.service.DAO.Custom.OwnersDAO;
import com.assignment.service.DAO.Custom.RevenueLicDAO;
import com.assignment.service.DAO.Custom.VehicleDAO;
import com.assignment.service.Model.OwnersDto;
import com.assignment.service.Model.RevenueLicDto;
import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleOwnerBoImpl implements VehicleOwnerBo {

    OwnersDAO vehicleOwnerModel = new VehicleOwnerImpl();

    public ArrayList<OwnersDto> getAllOwners(String vehicleId) throws SQLException {
        return vehicleOwnerModel.getAllOwners(vehicleId);

    }








}