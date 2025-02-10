package com.assignment.service.Bo.custom;

import com.assignment.service.Model.ViolationPointDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ViolationPointBo {

    ArrayList<ViolationPointDto> loadTableData() throws SQLException;
    boolean save(ViolationPointDto violationPointDto) throws SQLException;
}
