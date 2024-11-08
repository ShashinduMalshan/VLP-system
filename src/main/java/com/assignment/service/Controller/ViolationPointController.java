package com.assignment.service.Controller;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class homePageController implements Initializable {
    public AnchorPane homPageAnc;
    public TableColumn colPoint_id;
    public TableColumn colDescription;
    public TableColumn colLocation;
    public TableColumn colViolation_time;
    public TableColumn colViolation_date;
    public TableColumn colOfficer_id;
    public TableColumn colDriver_license_number;
    public TableColumn colRevenue_license_number;
    public TableColumn colLaw_id;
    public TableColumn colNumber_plate;
    public TableView tblViolationPoint;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
