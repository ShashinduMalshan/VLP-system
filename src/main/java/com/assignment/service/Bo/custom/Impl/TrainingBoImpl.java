package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.TrainingBo;
import com.assignment.service.DAO.Custom.Impl.TrainingImpl;
import com.assignment.service.DAO.Custom.TrainingDAO;
import com.assignment.service.DAO.DAOFactory;
import com.assignment.service.Model.TrainingDtoTwo;
import com.assignment.service.Model.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrainingBoImpl implements TrainingBo {

    TrainingDAO trainingImpl = (TrainingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRAINING);

    public boolean save(TrainingDtoTwo trainingDtoTwo) throws SQLException {

        return trainingImpl.save(trainingDtoTwo);
    }

    @Override
    public ArrayList<TrainingDtoTwo> getAll(String vehicleId) throws SQLException {
        return null;
    }


    public int getAllTrainingCount() throws SQLException {

        return trainingImpl.getAllTrainingCount();
    }

    public boolean isDuplicateId(String Id) throws SQLException {

        return trainingImpl.isDuplicateId(Id);
    }



    @Override
    public ArrayList<TrainingDtoTwo> loadTableData() throws SQLException {
        return null;
    }


    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(TrainingDtoTwo policeOfficerDto) throws SQLException {
        return false;
    }


    }
