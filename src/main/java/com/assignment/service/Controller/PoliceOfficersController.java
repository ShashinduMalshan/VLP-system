package com.assignment.service.Controller;

import com.assignment.service.Bo.custom.Impl.PoliceOfficerBoImpl;
import com.assignment.service.DAO.Custom.PoliceOfficerDAO;
import com.assignment.service.DAO.Custom.Impl.PoliceOfficerImpl;
import com.assignment.service.Model.PoliceOfficerDto;
import com.assignment.service.Model.PoliceOfficerTM;
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

public class PoliceOfficersController implements Initializable {

    public TextField txtOfficerId;
    public TextField txtLocation;
    public TextField txtOfficerName;
    public TextField searchField;
    public Button updateBtn;
    public Button saveBtn;
    public TableView <PoliceOfficerTM> tblOfficerDetails;
    public TableColumn <PoliceOfficerTM,String> colOfficerId;
    public TableColumn <PoliceOfficerTM,String> colOfficerName;
    public TableColumn <PoliceOfficerTM,String> colDutyLocation;
    public Button resetBtn;
    public Button deleteBtn;
    public Button searchFieldBtn;

    PoliceOfficerBoImpl policeOfficerBo = new PoliceOfficerBoImpl();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureTable();
        try {
            reset();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void configureTable() {

        colOfficerId.setCellValueFactory(new PropertyValueFactory<>("OfficerId"));
        colOfficerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colDutyLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

        tblOfficerDetails.setRowFactory(tv -> new TableRow<PoliceOfficerTM>() {
            @Override
            protected void updateItem(PoliceOfficerTM item, boolean empty) {
                super.updateItem(item, empty);

                // Clear any previous styles
                setStyle("");

                if (item != null && tblOfficerDetails.getSelectionModel().isSelected(getIndex())) {
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


    PoliceOfficerDAO policeOfficerModel = new PoliceOfficerImpl();
    public void loadTable() throws SQLException {

        ArrayList<PoliceOfficerDto> policeOfficerDtos = policeOfficerBo.loadTableData();
        ObservableList<PoliceOfficerTM> policeOfficerTMS= FXCollections.observableArrayList();

        for (PoliceOfficerDto policeOfficerDto : policeOfficerDtos) {

            PoliceOfficerTM policeOfficerTM = new PoliceOfficerTM(
                   policeOfficerDto.getOfficerId(),
                    policeOfficerDto.getName(),
                    policeOfficerDto.getLocation()
            );

            policeOfficerTMS.add(policeOfficerTM);
        }
        tblOfficerDetails.setItems(policeOfficerTMS);

    }


    public void deleteBtnOnAction(ActionEvent actionEvent) throws SQLException {

        String OfficerId = txtOfficerId.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            boolean isDeleted = policeOfficerBo.delete(OfficerId);
            if (isDeleted) {
                reset();
                new Alert(Alert.AlertType.INFORMATION, "Officer deleted...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete Officer...!").show();
            }
        }

    }

    public void updateBtnOnAction(ActionEvent actionEvent) throws SQLException {

        String officerId = txtOfficerId.getText();
        String name = txtOfficerName.getText();
        String location = txtLocation.getText();

        PoliceOfficerDto policeOfficerDto = new PoliceOfficerDto(
                officerId,
                name,
                location
        );

        boolean isUpdate = policeOfficerBo.update(policeOfficerDto);
        if (isUpdate) {
            reset();
            new Alert(Alert.AlertType.INFORMATION, "Officer update...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to Officer customer...!").show();
        }
    }

    public void saveBtnOnAction(ActionEvent actionEvent) throws SQLException {

        String officerId = txtOfficerId.getText();
        String name = txtOfficerName.getText();
        String location = txtLocation.getText();

        PoliceOfficerDto policeOfficerDto = new PoliceOfficerDto(
                officerId,
                name,
                location

        );

        boolean isSaved = policeOfficerBo.save(policeOfficerDto);
        if (isSaved) {
            reset();
            new Alert(Alert.AlertType.INFORMATION, "Officer saved...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to save Officer...!").show();
        }
    }

    public void onCliked(MouseEvent mouseEvent) {

            PoliceOfficerTM policeOfficerTM = tblOfficerDetails.getSelectionModel().getSelectedItem();
            if (policeOfficerTM != null) {
                txtOfficerId.setText(policeOfficerTM.getOfficerId());
                txtOfficerName.setText(policeOfficerTM.getName());
                txtLocation.setText(policeOfficerTM.getLocation());

                searchField.setText(policeOfficerTM.getOfficerId());
            }
        }

    public void reset() throws SQLException {
        loadTable();
        txtOfficerId.setText(policeOfficerModel.getNextId());
        txtOfficerName.setText("");
        txtLocation.setText("");
    }

    public void resetBtnOnAction(ActionEvent actionEvent) throws SQLException {
        reset();
    }


    public void searchFieldBtnAction(ActionEvent actionEvent) {

        String OfficerID = searchField.getText().trim();
        System.out.println(OfficerID);


        for (PoliceOfficerTM policeOfficerTM : tblOfficerDetails.getItems()) {
            if (policeOfficerTM.getOfficerId().equals(OfficerID)) {
                tblOfficerDetails.getSelectionModel().select(policeOfficerTM);
                tblOfficerDetails.scrollTo(policeOfficerTM);
                return;

            }

        }
    }
}
