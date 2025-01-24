package com.assignment.service.DAO;

import com.assignment.service.Model.TrafficViolationLawDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TrafficViolationLawDAO {



     ArrayList<TrafficViolationLawDto> getAllViolationLaws() throws SQLException;
     String getAllLawCount() throws SQLException;
     int HighViolationLaw() throws SQLException ;
}
