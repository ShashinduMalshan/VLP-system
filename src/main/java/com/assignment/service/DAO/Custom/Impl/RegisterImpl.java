package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.DAO.Custom.RegistrationDAO;
import com.assignment.service.Model.UserDto;
import com.assignment.service.DAO.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterImpl implements RegistrationDAO {


    public boolean save(UserDto userDto) throws SQLException {


        return SQLUtil.execute(
                "insert into User values (?,?,?,?)",
                getNextId(),
                userDto.getName(),
                userDto.getPassword(),
                userDto.getPoliceId()
        );

    }



    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select user_id from User order by user_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("U%03d", newIdIndex);
        }
        return "U001";
    }

    @Override
    public ArrayList<String> checkSuspendId() throws SQLException {
        return null;
    }

    @Override
    public boolean isDuplicateId(String drivingLicNum) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<UserDto> getAll() throws SQLException {
        return null;
    }
    @Override
    public boolean update(UserDto Dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }


}
