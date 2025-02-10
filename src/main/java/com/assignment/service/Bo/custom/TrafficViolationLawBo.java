package com.assignment.service.Bo.custom;

import com.assignment.service.Model.TrafficViolationLawDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TrafficViolationLawBo {

    ArrayList<TrafficViolationLawDto> loadLawTableData() throws SQLException;

    }
