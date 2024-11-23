package com.assignment.service.Model;

import com.assignment.service.Dto.UserDto;
import com.assignment.service.Dto.ViolationPointDto;
import com.assignment.service.util.CrudUtil;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterModel {

    public boolean saveNew(UserDto userDto) throws SQLException {


        return CrudUtil.execute(
                "insert into User values (?,?,?,?)",
                getNextId(),
                userDto.getName(),
                userDto.getPassword(),
                userDto.getPoliceId()
        );

    }

    public String getNextId() throws SQLException {
        ResultSet rst = CrudUtil.execute("select user_id from User order by user_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("U%03d", newIdIndex);
        }
        return "U001";
    }

}
