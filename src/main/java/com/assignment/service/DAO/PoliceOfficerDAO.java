package com.assignment.service.DAO;

import com.assignment.service.Model.PoliceOfficerDto;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PoliceOfficerDAO {

     ArrayList<PoliceOfficerDto> getAllOfficers() throws SQLException;
     String getNextOfficerId() throws SQLException;
     boolean saveOfficerTBL(PoliceOfficerDto policeOfficerDto) throws SQLException;
     boolean updateOfficers(PoliceOfficerDto policeOfficerDto) throws SQLException;
     boolean deleteOfficers(String policeOfficerId) throws SQLException;
}
