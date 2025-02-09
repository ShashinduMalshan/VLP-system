package com.assignment.service.Bo;

import com.assignment.service.DAO.Custom.Impl.TrainingImpl;
import com.assignment.service.DAO.Custom.TrainingDAO;
import com.assignment.service.Model.TrainingDtoTwo;

import java.sql.SQLException;

public class TrainingBoImpl {

    TrainingDAO trainingImpl = new TrainingImpl();

    public boolean save(TrainingDtoTwo trainingDtoTwo) throws SQLException {

        return trainingImpl.save(trainingDtoTwo);
    }


    public boolean isDuplicateId(String drivingLicNum) throws SQLException {

            return trainingImpl.isDuplicateId(drivingLicNum);
    }

    public int getAllTrainingCount() throws SQLException {

        return trainingImpl.getAllTrainingCount();
    }


    }
