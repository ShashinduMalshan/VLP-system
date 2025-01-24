package com.assignment.service.DAO;

import com.assignment.service.Model.DateDto;
import com.assignment.service.Model.ProgressbarDto;
import com.assignment.service.Model.TopViolatedLawDto;
import com.assignment.service.Model.TopViolatedPointDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DashboardDAO {

     ArrayList<DateDto> getAllViolationMonth() throws SQLException;
     ArrayList<DateDto> getAllSuspendLicByMonth() throws SQLException;
     ArrayList<TopViolatedLawDto> findTopViolatedLaw() throws SQLException;
     ArrayList<TopViolatedPointDto> findTopViolatedPoint() throws SQLException;
     String driverCount() throws SQLException;
     ArrayList<ProgressbarDto> getTargetCompletionCount () throws SQLException;


}
