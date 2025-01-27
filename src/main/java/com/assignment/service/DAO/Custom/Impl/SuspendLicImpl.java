package com.assignment.service.DAO.Custom.Impl;

import com.assignment.service.Controller.SuspendedLicController;
import com.assignment.service.DAO.Custom.SuspendDAO;
import com.assignment.service.Model.SuspendDriversDetailsDto;
import com.assignment.service.Model.SuspendLicDto;
import com.assignment.service.DAO.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;


public class SuspendLicImpl extends Thread implements SuspendDAO {

    public String timeDuration = LocalDate.now().plusYears(1).toString();// mekata mokak hari karanna one;


    NotificationImpl notificationModel = new NotificationImpl();
    public void checkAllSuspendedIds(ArrayList<String> limitPassedIDs) throws SQLException {


        ResultSet rst = SQLUtil.execute("select * from SuspendLic");
        ArrayList<String> SuspendLicence = new ArrayList<>();
        ArrayList<String> allSuspendedIDS = new ArrayList<>();


        while (rst.next()){
            SuspendLicence.add(rst.getString(5));
        }

        for (String limitPassedID : limitPassedIDs) {
            if (!SuspendLicence.contains(limitPassedID)) {
                allSuspendedIDS.add(limitPassedID);
                System.out.println("match Ids"+limitPassedID);

                new Thread(() -> {
                    try {
                        notificationModel.findEmail(limitPassedID,timeDuration);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        }
        findSuspendIDS(allSuspendedIDS);
    }
    public void findSuspendIDS(ArrayList<String> allSuspendedIDS) throws SQLException {

        SuspendedLicController suspendedLicController = new SuspendedLicController();

        System.out.println("me thinne table ekata add karanna one suspended data " + allSuspendedIDS);
        ArrayList<SuspendDriversDetailsDto> tblSuspendId = new ArrayList<>();
        System.out.println(getNextId());




        System.out.println("set btn eken wenas una date eka  "+timeDuration);


        for (String addingSuspendedID : allSuspendedIDS) {



            ResultSet rst = SQLUtil.execute("select * from Driver where driving_lic_num = ?", addingSuspendedID);

            while (rst.next()) {

                SuspendDriversDetailsDto suspendDriversDetailsDto = new SuspendDriversDetailsDto(
                        rst.getString(2),
                        timeDuration,
                        rst.getInt(4),
                        addingSuspendedID
                );

                tblSuspendId.add(suspendDriversDetailsDto);
            }

        }
        System.out.println("tblSuspend details  " + tblSuspendId);
        if (!(tblSuspendId.isEmpty())) {
            saveSuspendLicTBL(tblSuspendId);
        }
    }




    public void saveSuspendLicTBL(ArrayList<SuspendDriversDetailsDto> tblSuspendId) throws SQLException {
        for (SuspendDriversDetailsDto suspendDriversDetailsDto : tblSuspendId) {
            boolean isSave= SQLUtil.execute("insert into SuspendLic values (?,?,?,?,?)",
                    getNext(),
                    suspendDriversDetailsDto.getName(),
                    suspendDriversDetailsDto.getTimeDuration(),
                    suspendDriversDetailsDto.getTotalPoint(),
                    suspendDriversDetailsDto.getDrivingLicNum());
            System.out.println("SuspendLic values saved "+isSave);
        }

    }


    public String getNext() throws SQLException {
        ResultSet rst = SQLUtil.execute("select suspend_id from SuspendLic order by suspend_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("S%03d", newIdIndex);
        }
        return "C001";
    }



    public ArrayList<SuspendLicDto> getAll() throws SQLException {

        ResultSet resultSet = SQLUtil.execute("select * from SuspendLic");

        ArrayList<SuspendLicDto> suspendLicDtos = new ArrayList<>();

        while (resultSet.next()) {
            SuspendLicDto suspendLicDto = new SuspendLicDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            );
            suspendLicDtos.add(suspendLicDto);
        }
        return suspendLicDtos;
    }

    public boolean delete(String Id) throws SQLException {

        System.out.println(Id);
        return SQLUtil.execute("delete from SuspendLic where driver_id = ?", Id);
    }


    @Override
    public boolean save(SuspendLicDto Dto) throws SQLException {
        return false;
    }


    @Override
    public boolean update(SuspendLicDto Dto) throws SQLException {
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