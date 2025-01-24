package com.assignment.service.Controller;

import com.assignment.service.Model.ViolationPointDto;
import com.assignment.service.Model.ViolationPointTM;
import com.assignment.service.DAO.Impl.DriverImpl;
import com.assignment.service.DAO.Impl.SuspendLicImpl;
import com.assignment.service.DAO.Impl.ViolationPointImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
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
    public Button Confirm;
    public TextField txtLawId;
    public TextField txtDescription;
    public TextField txtLocation;
    public TextField txtPointId;
    public TextField txtRevenueLicenseId;
    public TextField txtDrivingLicenseId;
    public TextField txtOfficerID;

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
            refreshPage();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void refreshPage() throws SQLException {
        loadTableData();
        checkIsSuspend();//llllllllll

         txtPointId.setText(violationPointImpl.getNextOfficerId());
         txtDescription.setText("");
         txtLocation.setText("");
         txtOfficerID.setText("");
         txtDrivingLicenseId.setText("");
         txtRevenueLicenseId.setText("");
         txtLawId.setText("");

    }

    ViolationPointImpl violationPointImpl =new ViolationPointImpl();

    public void loadTableData() throws SQLException {

        ArrayList<ViolationPointDto> ViolationPointDTOS = violationPointImpl.getAllViolationPoints();
        ObservableList<ViolationPointTM> violationPointTMS = FXCollections.observableArrayList();

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

                 violationPointTMS.add(violationPointTM);


        }
            tblViolationPoint.setItems(violationPointTMS);
    }


    public void conformBtnOnAction(ActionEvent actionEvent) throws SQLException {


         String point_id=txtPointId.getText();
         String description=txtDescription.getText();
         String location=txtLocation.getText();
         String violationTime = LocalTime.now().toString();
         String violationDate = LocalDate.now().toString();
         String officerId=txtOfficerID.getText();
         String driverLicenseNumber=txtDrivingLicenseId.getText();
         String revenueLicenseNumber= txtRevenueLicenseId.getText();
         String lawId=txtLawId.getText();


        ViolationPointDto violationPointDto = new ViolationPointDto(
                point_id,
                description,
                location,
                violationTime,
                violationDate,
                officerId,
                driverLicenseNumber,
                revenueLicenseNumber,
                lawId
        );

    boolean isSaved = violationPointImpl.saveViolationPoints(violationPointDto);
        if (isSaved) {
            checkIsSuspend();// id eka suspend ekakda balanawa
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "violation Point saved...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to save violation Point...!").show();
        }



    }
    SuspendLicImpl suspendLicImpl = new SuspendLicImpl();
    DriverImpl driverModel = new DriverImpl();

    public void checkIsSuspend() throws SQLException {


        ArrayList<String> limitPassedIDs = driverModel.checkSuspendId();

            System.out.println("limitPassedIDs " + limitPassedIDs);
            suspendLicImpl.checkAllSuspendedIds(limitPassedIDs);

    }

}
