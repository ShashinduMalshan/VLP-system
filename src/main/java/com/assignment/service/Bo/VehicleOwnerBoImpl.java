package com.assignment.service.Bo;

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

public class VehicleOwnerBoImpl {

    OwnersDAO vehicleOwnerModel = new VehicleOwnerImpl();
    RevenueLicDAO revenueLicModel = new RevenueLicImpl();
    VehicleDAO vehicleModel = new VehicleImpl();

    public ArrayList<OwnersDto> getAllOwners(String vehicleId) throws SQLException {
        return vehicleOwnerModel.getAllOwners(vehicleId);

    }

     public ArrayList<VehicleDto> getAllVehicle(String vehicleId) throws SQLException {
        return vehicleModel.getAllVehicle(vehicleId);

    }

     public ArrayList<RevenueLicDto> getAllRevenueLic(String ownerId) throws SQLException {
        return revenueLicModel.getAllRevenueLic(ownerId);

    }




}