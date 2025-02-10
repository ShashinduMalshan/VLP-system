package com.assignment.service.Bo.custom.Impl;

import com.assignment.service.Bo.custom.TrainingBo;
import com.assignment.service.DAO.Custom.Impl.TrainingImpl;
import com.assignment.service.DAO.Custom.TrainingDAO;
import com.assignment.service.Model.TrainingDtoTwo;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrainingBoImpl implements TrainingBo {

    TrainingDAO trainingImpl = new TrainingImpl();

    public boolean save(TrainingDtoTwo trainingDtoTwo) throws SQLException {

        return trainingImpl.save(trainingDtoTwo);
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
