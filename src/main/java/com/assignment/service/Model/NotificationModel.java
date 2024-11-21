package com.assignment.service.Model;

import com.assignment.service.Controller.NotificationController;
import com.assignment.service.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificationModel {
    public void findEmail(String id) throws SQLException {

        String email = "";


          ResultSet resultSet = CrudUtil.execute("select email from Driver where driving_lic_num = ?",id);

            while (resultSet.next()){
                 email = resultSet.getString("email");

            System.out.println(email);
            NotificationController notificationController = new NotificationController();
            notificationController.findEmail(email);
        }

    }
}
