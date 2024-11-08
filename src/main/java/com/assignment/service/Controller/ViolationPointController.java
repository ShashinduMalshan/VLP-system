package com.assignment.service.Controller;

import com.assignment.service.Dto.ViolationPointDto;
import com.assignment.service.Dto.ViolationPointTM;
import com.assignment.service.Model.ViolationPointModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViolationPointController implements Initializable {
    public AnchorPane homPageAnc;
    public TableColumn <ViolationPointTM , String> colPoint_id;
    public TableColumn <ViolationPointTM , String> colDescription;
    public TableColumn <ViolationPointTM , String> colLocation;
    public TableColumn <ViolationPointTM , String> colViolation_time;
    public TableColumn <ViolationPointTM , String> colViolation_date;
    public TableColumn <ViolationPointTM , String> colOfficer_id;
    public TableColumn <ViolationPointTM , String> colDriver_license_number;
    public TableColumn <ViolationPointTM , String> colRevenue_license_number;
    public TableColumn <ViolationPointTM , String> colLaw_id;
    public TableColumn <ViolationPointTM , String> colNumber_plate;
    public TableView <ViolationPointTM>tblViolationPoint;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
            colPoint_id.setCellValueFactory(new PropertyValueFactory<>("point_id"));
            colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
            colViolation_time.setCellValueFactory(new PropertyValueFactory<>("violationTime"));
            colViolation_date.setCellValueFactory(new PropertyValueFactory<>("violationDate"));
            colOfficer_id.setCellValueFactory(new PropertyValueFactory<>("officerId"));
            colDriver_license_number.setCellValueFactory(new PropertyValueFactory<>("driverLicenseNumber"));
            colRevenue_license_number.setCellValueFactory(new PropertyValueFactory<>("revenueLicenseNumber"));
            colLaw_id.setCellValueFactory(new PropertyValueFactory<>("lawId"));
           // colNumber_plate.setCellValueFactory(new PropertyValueFactory<>("numberPlate"));

        try {
            loadTableData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ViolationPointModel violationPointModel=new ViolationPointModel();

    public void loadTableData() throws SQLException {

        ArrayList<ViolationPointDto> ViolationPointDTOS = violationPointModel.getAllViolationPoints();
        ObservableList<ViolationPointTM> customerTMS = FXCollections.observableArrayList();

        for (ViolationPointDto violationPointDto : ViolationPointDTOS) {
                 ViolationPointTM violationPointTM =new ViolationPointTM(
                         violationPointDto.getPoint_id(),
                         violationPointDto.getDescription(),
                         violationPointDto.getLocation(),
                         violationPointDto.getViolationTime(),
                         violationPointDto.getViolationDate(),
                         violationPointDto.getOfficerId(),
                         violationPointDto.getDriverLicenseNumber(),
                         violationPointDto.getRevenueLicenseNumber(),
                         violationPointDto.getLawId()
                 );

                 customerTMS.add(violationPointTM);


        }
            tblViolationPoint.setItems(customerTMS);
    }


}
