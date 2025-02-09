package com.assignment.service.DAO.Custom;

import com.assignment.service.Model.RevenueLicDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RevenueLicDAO {
    ArrayList<RevenueLicDto> getAllRevenueLic(String ownerId) throws SQLException;

}
