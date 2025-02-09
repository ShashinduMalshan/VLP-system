package com.assignment.service.DAO.Custom;

import com.assignment.service.DAO.CrudDAO;
import com.assignment.service.Model.ReLicenceCompleteDto;
import com.assignment.service.Model.TrainingDto;

import java.sql.SQLException;

public interface TrainingDAO extends CrudDAO<TrainingDto> {

     void restDrivePoint(String driverId) throws SQLException;
     int getAllTrainingCount() throws SQLException;



}
