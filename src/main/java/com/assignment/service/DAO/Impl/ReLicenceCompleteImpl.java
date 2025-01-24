package com.assignment.service.DAO.Impl;

import com.assignment.service.DAO.TrainingDAO;
import com.assignment.service.Model.ReLicenceCompleteDto;
import com.assignment.service.Model.TrainingDto;
import com.assignment.service.Model.TrainingDtoTwo;
import com.assignment.service.util.CrudUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReLicenceCompleteImpl implements TrainingDAO {

    public void saveReLicenceComplete(ReLicenceCompleteDto reLicenceCompleteDto) throws SQLException {
        Date date = Date.valueOf(LocalDate.now());

        CrudUtil.execute("insert into ReLicence_Complete values (?,?,?,?)",

                getNextReLicenceComplete(),
                reLicenceCompleteDto.getLastScore(),
                date,
                reLicenceCompleteDto.getDriverId());

    }
    public String getNextReLicenceComplete() throws SQLException {
        ResultSet rst = CrudUtil.execute("select test_id from ReLicence_Complete order by test_id desc limit 1");

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
    public boolean saveTrainingModel(TrainingDtoTwo trainingDto) throws SQLException {
        return false;
    }

    @Override
    public String getNextSuspendId() throws SQLException {
        return "";
    }

    @Override
    public boolean isDuplicateCourseId(String drivingLicNum) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<String> getAllTrainingIDS() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<TrainingDto> getAllTraining() throws SQLException {
        return null;
    }

    @Override
    public boolean deleteTraining(TrainingDto trainingDto) throws SQLException {
        return false;
    }

    @Override
    public void restDrivePoint(String driverId) throws SQLException {

    }

    @Override
    public int getAllTrainingCount() throws SQLException {
        return 0;
    }
}
