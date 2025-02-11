package com.assignment.service.DAO.Custom;

import com.assignment.service.DAO.CrudDAO;
import com.assignment.service.Model.TrafficViolationLawDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TrafficViolationLawDAO extends CrudDAO<TrafficViolationLawDto> {



     //ArrayList<TrafficViolationLawDto> getAll() throws SQLException;
     String getAllLawCount() throws SQLException;
     int HighViolationLaw() throws SQLException ;
}
