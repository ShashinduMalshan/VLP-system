package com.assignment.service.Controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomePageController implements Initializable {


    public AnchorPane sideBarAnc;
    public AnchorPane loadAnc;
    public Label violationLawBtn;
    public Label SuspendLicBtn;
    public Label Dashboard;
    public Label DriversBtn;
    public Label TrainingDriversBtn;
    public Label VehicleOwnersBtn;
    public Label policeOfficersBtn;

    public void navigateTo(String fxmlPath) {

        try {
            loadAnc.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));


            load.prefWidthProperty().bind(loadAnc.widthProperty());
            load.prefHeightProperty().bind(loadAnc.heightProperty());

            AnchorPane.setTopAnchor(load, 0.0);
            AnchorPane.setRightAnchor(load, 0.0);
            AnchorPane.setBottomAnchor(load, 0.0);
            AnchorPane.setLeftAnchor(load, 0.0);

            loadAnc.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load page!").show();
        }
    }


    public void vehiclePointAction(MouseEvent mouseEvent) throws IOException {
        navigateTo("/View/ViolationPoint.fxml");
    }

    public void violationLawAction(MouseEvent mouseEvent) {
        navigateTo("/View/TrafficViolationLaw.fxml");
    }

    public void SuspendLicBtnAction(MouseEvent mouseEvent) {
        navigateTo("/View/SuspendLicence.fxml");
    }

    public void dashboardOnAction(MouseEvent mouseEvent) {
        navigateTo("/View/Dashboard.fxml");
    }

    public void DriversBtnAction(MouseEvent mouseEvent) {navigateTo("/View/DriverPage.fxml");}

    public void TrainingDriversBtnAction(MouseEvent mouseEvent) { navigateTo("/View/Training.fxml");}

    public void policeOfficersBtnAction(MouseEvent mouseEvent) {navigateTo("/View/PoliceOfficers.fxml");}

    public void VehicleOwnersBtnAction(MouseEvent mouseEvent) {navigateTo("/View/VehicleOwner.fxml");}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        navigateTo("/View/Dashboard.fxml");
    }



}