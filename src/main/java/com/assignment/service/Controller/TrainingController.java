package com.assignment.service.Controller;

import com.assignment.service.Dto.*;
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

public class TrainingController implements Initializable {

    public TableView<TrainingTM> tblTraining;
    public TableColumn <TrainingTM,String> colTrainingID;
    public TableColumn <TrainingTM,String> colDriverName;
    public TableColumn <TrainingTM,String> colTimeDuration;
    public TableColumn <TrainingTM,String> colPoints;
    public TableColumn <TrainingTM,String> colDrivingLicNum;
    public TextField searchField;
    public Button CompleteTrainingBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colTrainingID.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTimeDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colPoints.setCellValueFactory(new PropertyValueFactory<>("totalPoint"));
        colDrivingLicNum.setCellValueFactory(new PropertyValueFactory<>("driverId"));

        try {
            loadTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    TrainingModel trainingModel = new TrainingModel();
    public void loadTable() throws SQLException {

        ArrayList<TrainingDto> trainingDtos = trainingModel.getAllTraining();
        ObservableList<TrainingTM> trainingTMS= FXCollections.observableArrayList();

        for (TrainingDto trainingDto : trainingDtos) {
                 TrainingTM trainingTM = new TrainingTM(
                    trainingDto.getCourseId(),
                    trainingDto.getName(),
                    trainingDto.getDuration(),
                    trainingDto.getTotalPoint(),
                    trainingDto.getDriverId()
            );

            trainingTMS.add(trainingTM);
        }
        tblTraining.setItems(trainingTMS);

    }

    String trainingID;
    String driverName;
    String timeDuration;
    int  totalPoint;
    String drivingLicNum;



    public void addCompleteTrainingBtnAcn(ActionEvent actionEvent) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to mark this ID as complete?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {
            System.out.println("addCompleteTrainingBtnAcn");

        TrainingDto trainingDto = new TrainingDto(
                trainingID,
                driverName,
                timeDuration,
                totalPoint,
                drivingLicNum
        );

            boolean isDeleteTraining = trainingModel.deleteTraining(trainingDto);

            if (isDeleteTraining) {
                System.out.println("deleteTraining");
                new Alert(Alert.AlertType.INFORMATION, "complete Training..!").show();
                loadTable();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to complete Training...!").show();
            }
        }


    }

    public void onClickTable(MouseEvent mouseEvent) {
        TrainingTM trainingTM = tblTraining.getSelectionModel().getSelectedItem();
        if (trainingTM != null) {
            trainingID = trainingTM.getCourseId();
            driverName = trainingTM.getName();
            timeDuration = trainingTM.getDuration();
            totalPoint = trainingTM.getTotalPoint();
            drivingLicNum = trainingTM.getDriverId();

        }
    }


}