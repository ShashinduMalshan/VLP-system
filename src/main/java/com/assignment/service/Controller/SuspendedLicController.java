package com.assignment.service.Controller;

import com.assignment.service.Dto.*;
import com.assignment.service.Model.SuspendLicModel;
import com.assignment.service.Model.TrainingModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class SuspendedLicController implements Initializable {


    public TableColumn  <SuspendLicTM,String> colSuspendID;
    public TableColumn <SuspendLicTM,String> colDriverName;
    public TableColumn <SuspendLicTM,String> colTimeDuration;
    public TableColumn <SuspendLicTM,String> colDrivingLicNum;
    public TableColumn <SuspendLicTM,Integer>colPoints;
    public TableView <SuspendLicTM>tblSuspendedLic;
    public Button addTrainingBtn;
    public TextField searchField;
    TrainingModel trainingModel = new TrainingModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureTable();
    }


    private void configureTable() {

        colSuspendID.setCellValueFactory(new PropertyValueFactory<>("suspendId"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colTimeDuration.setCellValueFactory(new PropertyValueFactory<>("timeDuration"));
        colPoints.setCellValueFactory(new PropertyValueFactory<>("points"));
        colDrivingLicNum.setCellValueFactory(new PropertyValueFactory<>("driverId"));

        try {
            ArrayList<String> allTrainingDID = trainingModel.getAllTrainingIDS();

            tblSuspendedLic.setRowFactory(tv -> new TableRow<>() {
                protected void updateItem(SuspendLicTM item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setStyle("");
                    } else if (allTrainingDID.contains(item.getDriverId())) {
                        setStyle("-fx-background-color: #A9DFBF;");
                    } else {
                        setStyle("");
                    }
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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


     String drivingLicNum;
     String driverName;
     int  totalPoint;



    public void addTrainingBtnAcn(ActionEvent actionEvent) throws SQLException {

        boolean isInvalid = trainingModel.isDuplicateCourseId(drivingLicNum);
        System.out.println("trainig table eke innawanm true enne ::::"+isInvalid);

        if (!isInvalid){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do You Want To Add Training ", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> optionalButtonType = alert.showAndWait();


            if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

                TrainingDtoTwo trainingDto = new TrainingDtoTwo(drivingLicNum, driverName, totalPoint);
                boolean isSave = trainingModel.saveTrainingModel(trainingDto);

                if (isSave) {
                    drivingLicNum = null;
                    driverName = null;
                    totalPoint = 0;
                    new Alert(Alert.AlertType.INFORMATION, "Training Data saved...!").show();
                    configureTable();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Fail to save data...!").show();
                }
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "This ID already exists. Please use a unique ID......").show();
        }
    }

    public void onClickTable(MouseEvent mouseEvent) {
        SuspendLicTM suspendLicTM = tblSuspendedLic.getSelectionModel().getSelectedItem();
        if (suspendLicTM != null) {
            drivingLicNum = suspendLicTM.getDriverId();
            driverName = suspendLicTM.getDriverName();
            totalPoint = suspendLicTM.getPoints();
        }
    }


}
