package com.assignment.service.DAO.Custom;

import com.assignment.service.DAO.CrudDAO;
import com.assignment.service.Model.ReLicenceCompleteDto;
import com.assignment.service.Model.TrainingDto;

import java.sql.SQLException;

public interface TrainingDAO extends CrudDAO<TrainingDto> {

   //  boolean saveTrainingModel(TrainingDtoTwo trainingDto) throws SQLException;
     //String getNextId() throws SQLException;
    // boolean isDuplicateCourseId(String drivingLicNum) throws SQLException ;
     //ArrayList<String> getAllTrainingIDS() throws SQLException;
    // ArrayList<TrainingDto> getAllTraining() throws SQLException;
  //   boolean deleteTraining(TrainingDto trainingDto) throws SQLException;
     void restDrivePoint(String driverId) throws SQLException;
     int getAllTrainingCount() throws SQLException;
     boolean saveReLicenceComplete(ReLicenceCompleteDto reLicenceCompleteDto) throws SQLException;
     String getNextReLicenceComplete() throws SQLException;



}
