package com.assignment.service.Bo.custom;

import com.assignment.service.Model.RevenueLicDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RevenueLicBo {


     ArrayList<RevenueLicDto> getAllRevenueLic(String ownerId) throws SQLException;

}
