package com.assignment.service.Model;

import com.assignment.service.Controller.NotificationController;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificationModel {
    public void findEmail(String id, String timeDuration) throws SQLException {

        String email = "";
        int totalPoint = 0;
        String name = "";


          ResultSet resultSet = CrudUtil.execute("select name,email,total_point from Driver where driving_lic_num = ?",id);

            while (resultSet.next()){
                 email = resultSet.getString("email");
                 totalPoint = resultSet.getInt("total_point");
                 name = resultSet.getString("name");

            System.out.println(email);
            NotificationController notificationController = new NotificationController();
            notificationController.findEmail(email,timeDuration,id,totalPoint,name);
        }

    }
}
