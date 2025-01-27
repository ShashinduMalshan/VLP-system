package com.assignment.service.Controller;

import com.assignment.service.DAO.Custom.DriverDAO;
import com.assignment.service.DBConnection.DBConnection;
import com.assignment.service.Model.DriverDto;
import com.assignment.service.Model.DriverTM;
import com.assignment.service.DAO.Custom.Impl.DriverImpl;
import com.assignment.service.DAO.Custom.Impl.TrainingImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

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
    public Button addTrainingBtn;
    public Button ExportBtn;
    public Button searchFieldBtn;
    public Label lblPercentageTraining;
    public Label lblTrainingLicenses;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colLicNum.setCellValueFactory(new PropertyValueFactory<>("drivingLicNum"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTPoint.setCellValueFactory(new PropertyValueFactory<>("totalPoint"));


        tblDriver.setRowFactory(tv -> new TableRow<>() {
            protected void updateItem(DriverTM item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setStyle("");
                } else if (item.getTotalPoint() > 149) {
                    setStyle("-fx-background-color: #FFBABA;");
                } else if (tblDriver.getSelectionModel().isSelected(getIndex())) {
                    setStyle("-fx-background-color: lightblue;");
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
        NotificationController notificationController = new NotificationController();

    }

    public void refresh() throws SQLException {
        statusLabel();
        loadTableData();
        getAllTrainingCount();
        getPercentageTraining();

    }


    DriverDAO driverModel = new DriverImpl();

    public void loadTableData() throws SQLException {

        ArrayList<DriverDto> driverDtos = driverModel.getAll();
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



    TrainingImpl trainingImpl = new TrainingImpl();
    public void getAllTrainingCount() throws SQLException {

        lblTrainingLicenses.setText(String.valueOf(trainingImpl.getAllTrainingCount()));
    }

    public void getPercentageTraining() throws SQLException {


        int allTrainingCount = trainingImpl.getAllTrainingCount();
        int driverCount = Integer.parseInt(driverModel.driverCount());

        double percentage = ((double) allTrainingCount / driverCount) * 100;
        percentage = Math.round(percentage * 100.0) / 100.0;
        System.out.println(percentage);

        lblPercentageTraining.setText(String.valueOf(percentage)+"%");
    }





    public void onClickTable(MouseEvent mouseEvent) {

        DriverTM driverTM = tblDriver.getSelectionModel().getSelectedItem();
        if (driverTM != null) {
            searchField.setText( driverTM.getDrivingLicNum());
            System.out.println( driverTM.getDrivingLicNum());
        }
    }

    public void ExportBtnOnAction(ActionEvent actionEvent) {

        System.out.println("ll");
        DriverTM driverTM = tblDriver.getSelectionModel().getSelectedItem();

        if (driverTM == null) {
            return;
        }

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(
                    getClass()
                            .getResourceAsStream("/Report/DriverViolationSummaryReport.jrxml"
                            ));

            Connection connection = DBConnection.getInstance().getConnection();

            Map<String, Object> parameters = new HashMap<>();

            parameters.put("p_driverID", driverTM.getDrivingLicNum());

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


    public void searchFieldBtnOnAction(ActionEvent actionEvent) {

        String DriverID = searchField.getText().trim();
        System.out.println(DriverID);


        for (DriverTM driverTM : tblDriver.getItems()) {
            if (driverTM.getDrivingLicNum().equals(DriverID)) {
                tblDriver.getSelectionModel().select(driverTM);
                tblDriver.scrollTo(driverTM);
                return;

            }

        }
    }
}