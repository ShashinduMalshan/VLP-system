package com.assignment.service.Controller;

import com.assignment.service.Bo.BOFactory;
import com.assignment.service.Bo.custom.Impl.SuspendedLicBoImpl;
import com.assignment.service.Bo.custom.Impl.TrainingBoImpl;
import com.assignment.service.Bo.custom.SuspendedLicBo;
import com.assignment.service.DAO.Custom.SuspendDAO;
import com.assignment.service.DAO.Custom.TrainingDAO;
import com.assignment.service.DBConnection.DBConnection;
import com.assignment.service.DAO.Custom.Impl.SuspendLicImpl;
import com.assignment.service.DAO.Custom.Impl.TrainingImpl;
import com.assignment.service.Model.SuspendLicDto;
import com.assignment.service.Model.SuspendLicTM;
import com.assignment.service.Model.TrainingDto;
import com.assignment.service.Model.TrainingDtoTwo;
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

public class SuspendedLicController implements Initializable {


    public TableColumn  <SuspendLicTM,String> colSuspendID;
    public TableColumn <SuspendLicTM,String> colDriverName;
    public TableColumn <SuspendLicTM,String> colTimeDuration;
    public TableColumn <SuspendLicTM,String> colDrivingLicNum;
    public TableColumn <SuspendLicTM,Integer>colPoints;
    public TableView <SuspendLicTM>tblSuspendedLic;
    public Button addTrainingBtn;
    public TextField searchField;
    public Button searchFieldBtn;
    public Button ExportBtn;
    TrainingDAO trainingImpl = new TrainingImpl();
    TrainingBoImpl trainingBo = new TrainingBoImpl();

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
            ArrayList<TrainingDto> allTraining = trainingImpl.getAll();
            ArrayList<String> allTrainingDID = new ArrayList<>();

            for (TrainingDto trainingDto : allTraining) {
                allTrainingDID.add(trainingDto.getDriverId());
            }

            tblSuspendedLic.setRowFactory(tv -> new TableRow<>() {
                protected void updateItem(SuspendLicTM item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setStyle("");
                    } else if (allTrainingDID.contains(item.getDriverId())) {
                        setStyle("-fx-background-color: #A9DFBF;");
                    } else if (tblSuspendedLic.getSelectionModel().isSelected(getIndex())) {
                        setStyle("-fx-background-color: lightblue;");
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


    SuspendedLicBo suspendedLicBoImpl = (SuspendedLicBo) BOFactory.getDaoFactory().getBo(BOFactory.BoTypes.SUSPEND_LIC);
    public void loadTable() throws SQLException {

        ArrayList<SuspendLicDto> suspendLicDtos = suspendedLicBoImpl.loadTableData();
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

        boolean isInvalid = trainingBo.isDuplicateId(drivingLicNum);
        System.out.println("trainig table eke innawanm true enne ::::"+isInvalid);

        if (!isInvalid){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do You Want To Add Training ", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> optionalButtonType = alert.showAndWait();


            if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

                boolean isSave = trainingBo.save(new TrainingDtoTwo(drivingLicNum, driverName, totalPoint));

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
        searchField.setText(drivingLicNum);
    }


    public void searchFieldOnAction(ActionEvent actionEvent) {

        String DriverId = searchField.getText().trim();
        System.out.println(DriverId);


        for (SuspendLicTM suspendLicTM : tblSuspendedLic.getItems()) {
            if (suspendLicTM.getDriverId().equals(DriverId)) {
                tblSuspendedLic.getSelectionModel().select(suspendLicTM);
                tblSuspendedLic.scrollTo(suspendLicTM);
                return;

            }

        }
    }

    public void ExportBtnOnAction(ActionEvent actionEvent) {


        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(
                    getClass()
                            .getResourceAsStream("/Report/SuspendLic.jrxml"
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
