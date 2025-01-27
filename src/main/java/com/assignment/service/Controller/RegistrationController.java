package com.assignment.service.Controller;

import com.assignment.service.DAO.Custom.RegistrationDAO;
import com.assignment.service.Model.UserDto;
import com.assignment.service.DAO.Custom.Impl.RegisterImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrationController {
    public TextField nameField;
    public TextField policeIdField;
    public PasswordField passwordField;
    public Button registerButton;
    public Button loginPageButton;
    public AnchorPane registrationPageAnc;

    RegistrationDAO registerModel = new RegisterImpl();
    public void handleRegistration(ActionEvent actionEvent) throws SQLException {


        String name = nameField.getText();
        String policeId = policeIdField.getText();
        String password = passwordField.getText();


        UserDto userDto = new UserDto(
                name,
                password,
                policeId
        );

        boolean isSaved = registerModel.save(userDto);
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "saved New User...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to save saved New User...!").show();
        }

    }

    public void navigateToLoginPage(ActionEvent actionEvent) throws IOException {



        registrationPageAnc.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/View/loginPage.fxml"));
        registrationPageAnc.getChildren().add(load);

        load.prefWidthProperty().bind(registrationPageAnc.widthProperty());
        load.prefHeightProperty().bind(registrationPageAnc.heightProperty());

        AnchorPane.setTopAnchor(load, 0.0);
        AnchorPane.setRightAnchor(load, 0.0);
        AnchorPane.setBottomAnchor(load, 0.0);
        AnchorPane.setLeftAnchor(load, 0.0);

    }
}
