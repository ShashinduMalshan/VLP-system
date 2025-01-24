package com.assignment.service.DAO;

import com.assignment.service.Model.SuspendDriversDetailsDto;
import com.assignment.service.Model.SuspendLicDto;
import com.assignment.service.Model.TrainingDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SuspendDAO {

     void checkAllSuspendedIds(ArrayList<String> limitPassedIDs) throws SQLException;
     void findSuspendIDS(ArrayList<String> allSuspendedIDS) throws SQLException;
     void saveSuspendLicTBL(ArrayList<SuspendDriversDetailsDto> tblSuspendId) throws SQLException;
     String getNextSuspendId() throws SQLException;
     ArrayList<SuspendLicDto> getAllSuspendedLic() throws SQLException;
     boolean deleteSuspendLic(TrainingDto trainingDto) throws SQLException;
}
