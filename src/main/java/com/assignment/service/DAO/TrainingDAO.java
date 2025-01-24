package com.assignment.service.DAO;

import com.assignment.service.Model.ReLicenceCompleteDto;
import com.assignment.service.Model.TrainingDto;
import com.assignment.service.Model.TrainingDtoTwo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TrainingDAO {

     boolean saveTrainingModel(TrainingDtoTwo trainingDto) throws SQLException;
     String getNextSuspendId() throws SQLException;
     boolean isDuplicateCourseId(String drivingLicNum) throws SQLException ;
     ArrayList<String> getAllTrainingIDS() throws SQLException;
     ArrayList<TrainingDto> getAllTraining() throws SQLException;
     boolean deleteTraining(TrainingDto trainingDto) throws SQLException;
     void restDrivePoint(String driverId) throws SQLException;
     int getAllTrainingCount() throws SQLException;
     void saveReLicenceComplete(ReLicenceCompleteDto reLicenceCompleteDto) throws SQLException;
     String getNextReLicenceComplete() throws SQLException;

}
