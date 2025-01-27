package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.DAO.Custom.TrainingDAO;
import com.assignment.service.Model.ReLicenceCompleteDto;
import com.assignment.service.Model.TrainingDto;
import com.assignment.service.DAO.SQLUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReLicenceCompleteImpl implements TrainingDAO {

    public boolean saveReLicenceComplete(ReLicenceCompleteDto reLicenceCompleteDto) throws SQLException {
        Date date = Date.valueOf(LocalDate.now());

        return SQLUtil.execute("insert into ReLicence_Complete values (?,?,?,?)",

                getNextReLicenceComplete(),
                reLicenceCompleteDto.getLastScore(),
                date,
                reLicenceCompleteDto.getDriverId());

    }
    public String getNextReLicenceComplete() throws SQLException {
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
    public void restDrivePoint(String driverId) throws SQLException {

    }

    @Override
    public int getAllTrainingCount() throws SQLException {
        return 0;
    }

    @Override
    public ArrayList<TrainingDto> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(TrainingDto Dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(TrainingDto Dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    @Override
    public String getNextId() throws SQLException {
        return "";
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
