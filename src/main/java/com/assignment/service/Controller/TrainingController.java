package com.assignment.service.Controller;

import com.assignment.service.DAO.Custom.TrainingDAO;
import com.assignment.service.DBConnection.DBConnection;
import com.assignment.service.DAO.Custom.Impl.ReLicenceCompleteImpl;
import com.assignment.service.DAO.Custom.Impl.TrainingImpl;
import com.assignment.service.Model.ReLicenceCompleteDto;
import com.assignment.service.Model.TrainingDto;
import com.assignment.service.Model.TrainingTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class TrainingController implements Initializable {

    public TableView<TrainingTM> tblTraining;
    public TableColumn <TrainingTM,String> colTrainingID;
    public TableColumn <TrainingTM,String> colDriverName;
    public TableColumn <TrainingTM,String> colTimeDuration;
    public TableColumn <TrainingTM,String> colPoints;
    public TableColumn <TrainingTM,String> colDrivingLicNum;
    public TextField searchField;
    public Button CompleteTrainingBtn;
    public Button searchFieldBtn;
    public Button ExportBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colTrainingID.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTimeDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colPoints.setCellValueFactory(new PropertyValueFactory<>("totalPoint"));
        colDrivingLicNum.setCellValueFactory(new PropertyValueFactory<>("driverId"));

        tblTraining.setRowFactory(tv -> new TableRow<TrainingTM>() {
            @Override
            protected void updateItem(TrainingTM item, boolean empty) {
                super.updateItem(item, empty);

                // Clear any previous styles
                setStyle("");

                if (item != null && tblTraining.getSelectionModel().isSelected(getIndex())) {
                    // Apply a background color for the selected row
                    setStyle("-fx-background-color: lightblue;");
                }
            }
        });

        try {
            loadTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    TrainingDAO trainingModel = new TrainingImpl();
    TrainingDAO reLicenceCompleteModel = new ReLicenceCompleteImpl();
    public void loadTable() throws SQLException {

        ArrayList<TrainingDto> trainingDtos = trainingModel.getAll();
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

        ReLicenceCompleteDto reLicenceCompleteDto = new ReLicenceCompleteDto(
                totalPoint,
                drivingLicNum
        );

            reLicenceCompleteModel.saveReLicenceComplete(reLicenceCompleteDto);
            boolean isDeleteTraining = trainingModel.delete(trainingDto.getDriverId());

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

            searchField.setText(drivingLicNum);

        }
    }


    public void searchFieldBtnOnAction(ActionEvent actionEvent) {

        String DriverID = searchField.getText().trim();
        System.out.println(DriverID);


        for (TrainingTM trainingTM : tblTraining.getItems()) {
            if (trainingTM.getDriverId().equals(DriverID)) {
                tblTraining.getSelectionModel().select(trainingTM);
                tblTraining.scrollTo(trainingTM);
                return;

            }

        }
    }

    public void ExportBtnOnAction(ActionEvent actionEvent) {

        System.out.println("ll");

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(
                    getClass()
                            .getResourceAsStream("/Report/TrainingDriver.jrxml"
                            ));

            Connection connection = DBConnection.getInstance().getConnection();

            Map<String, Object> parameters = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport,
                    parameters,
                    connection
            );
            System.out.println(jasperPrint);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to generate report...!").show();
//           e.printStackTrace();
        }

    }
}
