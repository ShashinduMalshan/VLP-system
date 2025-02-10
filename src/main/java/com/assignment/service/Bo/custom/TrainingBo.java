package com.assignment.service.Bo.custom;

import com.assignment.service.Bo.SuperBo;
import com.assignment.service.Model.TrainingDtoTwo;

import java.sql.SQLException;

public interface TrainingBo extends SuperBo<TrainingDtoTwo> {



//    boolean save(TrainingDtoTwo trainingDtoTwo) throws SQLException;
//    boolean isDuplicateId(String Id) throws SQLException ;
    int getAllTrainingCount() throws SQLException;
}
