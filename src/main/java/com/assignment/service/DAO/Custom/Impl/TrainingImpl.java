package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.DAO.Custom.SuspendDAO;
import com.assignment.service.DAO.Custom.TrainingDAO;
import com.assignment.service.DBConnection.DBConnection;
import com.assignment.service.Model.ReLicenceCompleteDto;
import com.assignment.service.Model.TrainingDto;
import com.assignment.service.Model.TrainingDtoTwo;
import com.assignment.service.DAO.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TrainingImpl implements TrainingDAO {


    public boolean save(TrainingDtoTwo trainingDto) throws SQLException {

        String Date = LocalDate.now().plusMonths(6).toString();


        return SQLUtil.execute("insert into Training values (?,?,?,?,?)",
                getNextId(),
                trainingDto.getDriverName(),
                Date,
                trainingDto.getTotalPoint(),
                trainingDto.getDrivingLicNum()

        );
    }

    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select course_id from Training order by course_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("T%03d", newIdIndex);
        }
        return "T001";
    }

    public boolean isDuplicateId(String drivingLicNum) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT driver_id FROM Training WHERE driver_id = ?", drivingLicNum);
        System.out.println(drivingLicNum);

        String DBBC=null;
        while (resultSet.next()) {
           DBBC = resultSet.getString(1);

        }
        return drivingLicNum.equals(DBBC);
    }


    public ArrayList<TrainingDto> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("select * from Training");

        ArrayList<TrainingDto> trainingDtos = new ArrayList<>();


        while (resultSet.next()) {
            TrainingDto trainingDto = new TrainingDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            );
            trainingDtos.add(trainingDto);
        }
        return trainingDtos;
    }

    SuspendDAO suspendLicModel = new SuspendLicImpl();
    public boolean delete(String ID) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);
            boolean isDelete = SQLUtil.execute("delete from Training where driver_id = ?",
                    ID);

            if (isDelete) {
                boolean isSuspendLicDelete= suspendLicModel.delete(ID);
                if (isSuspendLicDelete) {
                    restDrivePoint(ID);
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;


        } catch (SQLException e) {
            connection.rollback();
            return false;
        }
        finally {
            connection.setAutoCommit(true);
        }
    }
    public void restDrivePoint(String driverId) throws SQLException {

        SQLUtil.execute(
                "update Driver set total_point = 0 where driving_lic_num = ?", driverId);
    }

    public int getAllTrainingCount() throws SQLException {

        ResultSet resultSet = SQLUtil.execute("SELECT count(*) FROM Training");
        while (resultSet.next()) {
           return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean saveReLicenceComplete(ReLicenceCompleteDto reLicenceCompleteDto) throws SQLException {

        return false;
    }

    @Override
    public String getNextReLicenceComplete() throws SQLException {
        return "";
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
    public ArrayList<String> checkSuspendId() throws SQLException {
        return null;
    }
}


