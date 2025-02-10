package com.assignment.service.Controller;

import com.assignment.service.Bo.custom.Impl.TrafficViolationLawBoImpl;
import com.assignment.service.DAO.Custom.TrafficViolationLawDAO;
import com.assignment.service.Model.TrafficViolationLawDto;
import com.assignment.service.Model.TrafficViolationLawTM;
import com.assignment.service.DAO.Custom.Impl.TrafficViolationLawImpl;
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
import java.util.ResourceBundle;

public class TrafficViolationLawController implements Initializable {
    public Label lawAnc;
    public TableView <TrafficViolationLawTM>lawTable;
    public TableColumn <TrafficViolationLawTM ,String> colLawId;
    public TableColumn <TrafficViolationLawTM ,String>  colDescription;
    public TableColumn <TrafficViolationLawTM , Integer>  colLawPoint;
    public TextField searchField;
    public Button searchFieldBtn;
    public String lawId;
    public Label lblTotalLaws;
    public Label lblHighPoint;
    public Label lblAvgPoints;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colLawId.setCellValueFactory(new PropertyValueFactory<>("lawId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colLawPoint.setCellValueFactory(new PropertyValueFactory<>("lawPoints"));

        lawTable.setRowFactory(tv -> new TableRow<TrafficViolationLawTM>() {
            @Override
            protected void updateItem(TrafficViolationLawTM item, boolean empty) {
                super.updateItem(item, empty);

                // Clear any previous styles
                setStyle("");

                if (item != null && lawTable.getSelectionModel().isSelected(getIndex())) {
                    // Apply a background color for the selected row
                    setStyle("-fx-background-color: lightblue;");
                }
            }
        });


        try {
            loadLawTableData();
            getAllLawCount();
            HighViolationLaw();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    TrafficViolationLawDAO trafficViolationLawModel=new TrafficViolationLawImpl();
    TrafficViolationLawBoImpl trafficViolationLawBoImpl=new TrafficViolationLawBoImpl();

    public void loadLawTableData() throws SQLException {

        ArrayList<TrafficViolationLawDto> trafficViolationLawDtos = trafficViolationLawBoImpl.loadTableData();
        ObservableList<TrafficViolationLawTM> lawTMS = FXCollections.observableArrayList();

        for (TrafficViolationLawDto trafficViolationLawDto : trafficViolationLawDtos) {
           TrafficViolationLawTM trafficViolationLawTM = new TrafficViolationLawTM(
                   trafficViolationLawDto.getLawId(),
                   trafficViolationLawDto.getDescription(),
                   trafficViolationLawDto.getLawPoints()
           );
        lawTMS.add(trafficViolationLawTM);

        }
        lawTable.setItems(lawTMS);
    }


    public void searchFieldBtnOnAction(ActionEvent actionEvent) throws SQLException {
            String lawId = searchField.getText().trim();
            System.out.println(lawId);


            for (TrafficViolationLawTM trafficViolationLawTM : lawTable.getItems()) {
                if (trafficViolationLawTM.getLawId().equals(lawId)) {
                    lawTable.getSelectionModel().select(trafficViolationLawTM);
                    lawTable.scrollTo(trafficViolationLawTM);
                    return;

                }

        }

    }
    String allLawCount;
    public void getAllLawCount () throws SQLException {
         allLawCount = trafficViolationLawModel.getAllLawCount();
         lblTotalLaws.setText(allLawCount);
    }

    public void HighViolationLaw() throws SQLException {
        lblHighPoint.setText(String.valueOf(trafficViolationLawModel.HighViolationLaw()));
    }



    public void OnClicked(MouseEvent mouseEvent) {

        TrafficViolationLawTM trafficViolationLawTM = (TrafficViolationLawTM) lawTable.getSelectionModel().getSelectedItem();
        if (trafficViolationLawTM != null) {
            lawId = trafficViolationLawTM.getLawId();
            searchField.setText(lawId);
            System.out.println(lawId);
        }

        int selectedPoint = lawTable.getSelectionModel().getSelectedItem().getLawPoints();
        System.out.println(selectedPoint);
        double average = (double) 150 /selectedPoint;
        String formattedAverage = String.format("%.2f", average); // Formats to 2 decimal places
        System.out.println(average);

        lblAvgPoints.setText(String.valueOf(formattedAverage));
    }
}
