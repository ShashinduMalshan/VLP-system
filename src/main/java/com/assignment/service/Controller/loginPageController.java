package com.assignment.service.Controller;

import com.assignment.service.util.CrudUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginPageControoler {
    public AnchorPane loginPageAnc;
    public Label userNameLbl;
    public Label passwordLbl;
    public Button loginButton;
    public Label PoliceIdLbl;
    public PasswordField policeIdTxt;
    public PasswordField passwordTxt;
    public TextField usernameTxt;

    public void handleLogin(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {


        String username = usernameTxt.getText();
        String password = passwordTxt.getText();

        if (authenticate(username,password)){
            loginPageAnc.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource("/View/ViolationPoint.fxml"));
            loginPageAnc.getChildren().add(load);
        }
        else{
            System.out.println("Login Failed");
        }
    }



    public boolean authenticate(String username, String password) throws SQLException, ClassNotFoundException {
        try{
            ResultSet result = CrudUtil.execute("SELECT * FROM User WHERE name = ? AND password = ?", username, password);


            if (result.next()) {
                return true;  // Authentication successful
            }
            else {
                new Alert(Alert.AlertType.ERROR, "Login Failed").show();

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }



}
