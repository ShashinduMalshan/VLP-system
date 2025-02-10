package com.assignment.service.Bo.custom;

import com.assignment.service.Model.SuspendLicDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SuspendedLicBo {

    ArrayList<SuspendLicDto> loadTable() throws SQLException;

    }
