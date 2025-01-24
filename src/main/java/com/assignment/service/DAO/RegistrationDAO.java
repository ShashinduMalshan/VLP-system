package com.assignment.service.DAO;

import com.assignment.service.Model.UserDto;

import java.sql.SQLException;

public interface RegistrationDAO {

     boolean saveNew(UserDto userDto) throws SQLException;
     String getNextId() throws SQLException;



}
