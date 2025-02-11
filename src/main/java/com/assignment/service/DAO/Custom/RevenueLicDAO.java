package com.assignment.service.DAO.Custom;

import com.assignment.service.DAO.CrudDAO;
import com.assignment.service.Model.RevenueLicDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RevenueLicDAO extends CrudDAO<RevenueLicDto> {
    ArrayList<RevenueLicDto> getAllRevenueLic(String ownerId) throws SQLException;

}
