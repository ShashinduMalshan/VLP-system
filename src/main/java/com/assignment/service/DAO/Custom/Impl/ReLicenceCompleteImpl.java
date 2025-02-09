package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.DAO.Custom.ReLicenceCompleteDAO;
import com.assignment.service.Model.ReLicenceCompleteDto;
import com.assignment.service.Model.TrainingDto;
import com.assignment.service.DAO.SQLUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReLicenceCompleteImpl implements ReLicenceCompleteDAO {

    public boolean save(ReLicenceCompleteDto reLicenceCompleteDto) throws SQLException {
        Date date = Date.valueOf(LocalDate.now());

        return SQLUtil.execute("insert into ReLicence_Complete values (?,?,?,?)",

                getNextId(),
                reLicenceCompleteDto.getLastScore(),
                date,
                reLicenceCompleteDto.getDriverId());

    }
    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select test_id from ReLicence_Complete order by test_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("C%03d", newIdIndex);
        }
        return "C001";
    }



    @Override
    public ArrayList<ReLicenceCompleteDto> getAll() throws SQLException {
        return null;
    }



    @Override
    public boolean update(ReLicenceCompleteDto Dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }


    @Override
    public ArrayList<String> checkSuspendId() throws SQLException {
        return null;
    }

    @Override
    public boolean isDuplicateId(String drivingLicNum) throws SQLException {
        return false;
    }
}
