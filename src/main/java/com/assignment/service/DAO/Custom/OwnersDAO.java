package com.assignment.service.DAO.Custom;

import com.assignment.service.Model.OwnersDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OwnersDAO {

    ArrayList<OwnersDto> getAllOwners(String vehicleId) throws SQLException;
}
