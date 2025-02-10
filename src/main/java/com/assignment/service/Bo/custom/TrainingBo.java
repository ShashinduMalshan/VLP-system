package com.assignment.service.Bo.custom;

import com.assignment.service.Model.TrainingDtoTwo;

import java.sql.SQLException;

public interface TrainingBo {



    boolean save(TrainingDtoTwo trainingDtoTwo) throws SQLException;
    boolean isDuplicateId(String drivingLicNum) throws SQLException ;
    int getAllTrainingCount() throws SQLException;
}
