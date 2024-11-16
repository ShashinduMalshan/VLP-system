package com.assignment.service.Controller;

import com.assignment.service.Dto.DriverDto;
import com.assignment.service.Dto.DriverTM;
import com.assignment.service.Model.DriverModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DriverController implements Initializable {
    public TableColumn <DriverTM, String> colLicNum;
    public TableColumn <DriverTM, String> colName;
    public TableColumn <DriverTM, String> colEmail;
    public TableColumn <DriverTM, Integer> colTPoint;
    public TableView <DriverTM>tblDriver;
    public Label lblTotalDrivers;
    public Label lblActiveLicenses;
    public Label lblSuspendedLicenses;
    public TextField searchField;
    public TableColumn colActions;
    public Label totalFormonth;
    public Label suspendPrecent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            colLicNum.setCellValueFactory(new PropertyValueFactory<>("drivingLicNum"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colTPoint.setCellValueFactory(new PropertyValueFactory<>("totalPoint"));


        tblDriver.setRowFactory(tv -> new TableRow<DriverTM>() {
            protected void updateItem(DriverTM item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setStyle("");
                } else if (item.getTotalPoint() > 150) {
                    setStyle("-fx-background-color: #FFBABA;");
                } else {
                    setStyle("");
                }
            }
        });


        try {
            refresh();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void refresh() throws SQLException {
        statusLabel();
        loadTableData();

    }


    DriverModel driverModel = new DriverModel();
    public void loadTableData() throws SQLException {

        ArrayList<DriverDto> driverDtos = driverModel.getAllDriver();
        ObservableList<DriverTM> driverTMS = FXCollections.observableArrayList();

        for (DriverDto driverDto : driverDtos) {
            DriverTM driverTM = new DriverTM(
                    driverDto.getDrivingLicNum(),
                    driverDto.getName(),
                    driverDto.getEmail(),
                    driverDto.getTotalPoint()
            );
            driverTMS.add(driverTM);
        }
        tblDriver.setItems(driverTMS);
    }

    public void statusLabel() throws SQLException {
       lblTotalDrivers.setText(driverModel.driverCount());
       lblSuspendedLicenses.setText(driverModel.suspendCount());

        int DriverCount= Integer.parseInt(driverModel.driverCount());
        int SuspendCount= Integer.parseInt(driverModel.suspendCount());

        double percentage = ( (double) SuspendCount / DriverCount) * 100;
        suspendPrecent.setText(String.format("%.2f", percentage)+"%");

        System.out.println(percentage);
    }



    }
