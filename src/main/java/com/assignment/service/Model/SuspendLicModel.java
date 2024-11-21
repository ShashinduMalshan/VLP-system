package com.assignment.service.Model;

import com.assignment.service.Controller.SuspendedLicController;
import com.assignment.service.Dto.SuspendDriversDetailsDto;
import com.assignment.service.Dto.SuspendLicDto;
import com.assignment.service.Dto.TrainingDto;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class SuspendLicModel extends Thread {

    public String timeDuration = LocalDate.now().plusYears(1).toString();// mekata mokak hari karanna one;


    NotificationModel notificationModel = new NotificationModel();
    public void checkAllSuspendedIds(ArrayList<String> limitPassedIDs) throws SQLException {


        ResultSet rst = CrudUtil.execute("select * from SuspendLic");
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
                        notificationModel.findEmail(limitPassedID);
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
        System.out.println(getNextSuspendId());




        System.out.println("set btn eken wenas una date eka  "+timeDuration);


        for (String addingSuspendedID : allSuspendedIDS) {



            ResultSet rst = CrudUtil.execute("select * from Driver where driving_lic_num = ?", addingSuspendedID);

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
            boolean isSave= CrudUtil.execute("insert into SuspendLic values (?,?,?,?,?)",
                    getNextSuspendId(),
                    suspendDriversDetailsDto.getName(),
                    suspendDriversDetailsDto.getTimeDuration(),
                    suspendDriversDetailsDto.getTotalPoint(),
                    suspendDriversDetailsDto.getDrivingLicNum());
            System.out.println("SuspendLic values saved "+isSave);
        }

    }



    public String getNextSuspendId() throws SQLException {
        ResultSet rst = CrudUtil.execute("select suspend_id from SuspendLic order by suspend_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("S%03d", newIdIndex);
        }
        return "C001";
    }



    public ArrayList<SuspendLicDto> getAllSuspendedLic() throws SQLException {

        ResultSet resultSet = CrudUtil.execute("select * from SuspendLic");

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

    public boolean deleteSuspendLic(TrainingDto trainingDto) throws SQLException {

        return CrudUtil.execute("delete from SuspendLic where driver_id = ?", trainingDto.getDriverId());
    }

}