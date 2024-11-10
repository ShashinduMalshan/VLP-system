package com.assignment.service.Controller;

import com.assignment.service.Dto.TrafficViolationLawDto;
import com.assignment.service.Dto.TrafficViolationLawTM;
import com.assignment.service.Model.TrafficViolationLawModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TrafficViolationLawController implements Initializable {
    public Label lawAnc;
    public TableView lawTable;


    public TableColumn <TrafficViolationLawTM ,String> colLawId;
    public TableColumn <TrafficViolationLawTM ,String>  colDescription;
    public TableColumn <TrafficViolationLawTM , Integer>  colLawPoint;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colLawId.setCellValueFactory(new PropertyValueFactory<>("lawId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colLawPoint.setCellValueFactory(new PropertyValueFactory<>("lawPoints"));

        try {
            System.out.println("initialize");
            loadLawTableData();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    TrafficViolationLawModel trafficViolationLawModel=new TrafficViolationLawModel();
    public void loadLawTableData() throws SQLException {

        ArrayList<TrafficViolationLawDto> trafficViolationLawDtos = trafficViolationLawModel.getAllViolationLaws();
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



}
