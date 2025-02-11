package com.assignment.service.DAO.Custom;

import com.assignment.service.DAO.CrudDAO;
import com.assignment.service.Model.OwnersDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OwnersDAO extends CrudDAO<OwnersDto> {

    ArrayList<OwnersDto> getAllOwners(String vehicleId) throws SQLException;
}
