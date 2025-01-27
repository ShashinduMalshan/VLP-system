package com.assignment.service.DAO.Custom;

import com.assignment.service.DAO.CrudDAO;
import com.assignment.service.Model.SuspendDriversDetailsDto;
import com.assignment.service.Model.SuspendLicDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SuspendDAO extends CrudDAO<SuspendLicDto> {

     void checkAllSuspendedIds(ArrayList<String> limitPassedIDs) throws SQLException;
     void findSuspendIDS(ArrayList<String> allSuspendedIDS) throws SQLException;
     void saveSuspendLicTBL(ArrayList<SuspendDriversDetailsDto> tblSuspendId) throws SQLException;

}
