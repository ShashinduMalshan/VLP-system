package com.assignment.service.Controller;

import com.assignment.service.Dto.SuspendLicDto;
import com.assignment.service.Dto.SuspendLicTM;
import com.assignment.service.Model.SuspendLicModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SuspendedLicController implements Initializable {


    public TableColumn  <SuspendLicTM,String> colSuspendID;
    public TableColumn <SuspendLicTM,String> colDriverName;
    public TableColumn <SuspendLicTM,String> colTimeDuration;
    public TableColumn <SuspendLicTM,String> colDrivingLicNum;
    public TableColumn <SuspendLicTM,Integer>colPoints;
    public TableView <SuspendLicTM>tblSuspendedLic;
    public TextField txtTimeDuration;
    public Button setBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colSuspendID.setCellValueFactory(new PropertyValueFactory<>("suspendId"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colTimeDuration.setCellValueFactory(new PropertyValueFactory<>("timeDuration"));
        colPoints.setCellValueFactory(new PropertyValueFactory<>("points"));
        colDrivingLicNum.setCellValueFactory(new PropertyValueFactory<>("driverId"));
        try {
            loadTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    SuspendLicModel suspendLicModel = new SuspendLicModel();
    public void loadTable() throws SQLException {

        ArrayList<SuspendLicDto> suspendLicDtos = suspendLicModel.getAllSuspendedLic();
        ObservableList<SuspendLicTM> suspendLicTMS= FXCollections.observableArrayList();

        for (SuspendLicDto suspendLicDto : suspendLicDtos) {
            SuspendLicTM suspendLicTM = new SuspendLicTM(
                           suspendLicDto.getSuspendId(),
                           suspendLicDto.getDriverName(),
                           suspendLicDto.getTimeDuration(),
                           suspendLicDto.getPoints(),
                           suspendLicDto.getDriverId()
                   );

            suspendLicTMS.add(suspendLicTM);
        }
    tblSuspendedLic.setItems(suspendLicTMS);

    }


    public void setBtnOnAction(ActionEvent actionEvent) {


    }
}
