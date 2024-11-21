package com.assignment.service.Controller;

import com.assignment.service.Dto.*;
import com.assignment.service.Model.RevenueLicModel;
import com.assignment.service.Model.VehicleModel;
import com.assignment.service.Model.VehicleOwnerModel;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleOwnerController {
    public TextField searchField;
    public Label lblRevenueLicence;
    public Label lblIssueDate;
    public Label lblExpirationDate;
    public Label lblMobileNo;
    public Label lblAddress;
    public Label lblEmail;
    public Label lblOwnerName;
    public Button search;
    public Label lblModel;
    public Label lblBrandName;
    public String ownerId;


    VehicleOwnerModel vehicleOwnerModel = new VehicleOwnerModel();
    RevenueLicModel revenueLicModel = new RevenueLicModel();
    VehicleModel vehicleModel = new VehicleModel();
    public void SearchData(String vehicleId) throws SQLException {

        ArrayList<OwnersDto> ownerDetails = vehicleOwnerModel.getAllOwners(vehicleId);
        for (OwnersDto ownersDto : ownerDetails) {

                    ownerId = ownersDto.getOwnerID();
                    lblOwnerName.setText(ownersDto.getName());
                    lblEmail.setText(ownersDto.getEmail());
                    lblAddress.setText(ownersDto.getAddress());
                    lblMobileNo.setText(String.valueOf(ownersDto.getPhone()));

        }

        ArrayList<VehicleDto> vehicleDetails = vehicleModel.getAllVehicle(vehicleId);
        for (VehicleDto vehicleDto : vehicleDetails) {
                    lblModel.setText(vehicleDto.getModel());
                    lblBrandName.setText(vehicleDto.getBrandName());
        }
        ArrayList<RevenueLicDto> revenueLicDtos = revenueLicModel.getAllRevenueLic(ownerId);
        for (RevenueLicDto revenueLicDto : revenueLicDtos) {
                    lblRevenueLicence.setText(revenueLicDto.getRevenueLic());
                    lblIssueDate.setText(revenueLicDto.getDate_of_issue());
                    lblExpirationDate.setText(revenueLicDto.getExpires_date());

        }





        }


    public void searchOnAction(ActionEvent actionEvent) throws SQLException {
        SearchData(searchField.getText());
    }
}