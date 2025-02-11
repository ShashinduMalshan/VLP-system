package com.assignment.service.Controller;

import com.assignment.service.Bo.BOFactory;
import com.assignment.service.Bo.custom.Impl.RevenueLicBoImpl;
import com.assignment.service.Bo.custom.Impl.VehicleBoImpl;
import com.assignment.service.Bo.custom.Impl.VehicleOwnerBoImpl;
import com.assignment.service.Bo.custom.RevenueLicBo;
import com.assignment.service.Bo.custom.VehicleBo;
import com.assignment.service.Bo.custom.VehicleOwnerBo;
import com.assignment.service.DBConnection.DBConnection;
import com.assignment.service.Model.OwnersDto;
import com.assignment.service.Model.RevenueLicDto;
import com.assignment.service.Model.VehicleDto;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VehicleOwnerController {
    public TextField searchField;
    public Label lblRevenueLicence;
    public Label lblIssueDate;
    public Label lblExpirationDate;
    public Label lblMobileNo;
    public Label lblAddress;
    public Label lblEmail;
    public Label lblOwnerName;
    public Button search;
    public Label lblModel;
    public Label lblBrandName;
    public String ownerId;
    public Button ExportBtn;



    VehicleOwnerBo vehicleOwnerBoImpl = (VehicleOwnerBo) BOFactory.getDaoFactory().getBo(BOFactory.BoTypes.OWNERS);
    VehicleBo vehicleBoImpl = (VehicleBo) BOFactory.getDaoFactory().getBo(BOFactory.BoTypes.VEHICLE);
    RevenueLicBo revenueLicBoBoImpl = (RevenueLicBo) BOFactory.getDaoFactory().getBo(BOFactory.BoTypes.REVENUE_LIC);
    public void SearchData(String vehicleId) throws SQLException {

        ArrayList<OwnersDto> ownerDetails = vehicleOwnerBoImpl.getAll(vehicleId);
        for (OwnersDto ownersDto : ownerDetails) {

                    ownerId = ownersDto.getOwnerID();
                    lblOwnerName.setText(ownersDto.getName());
                    lblEmail.setText(ownersDto.getEmail());
                    lblAddress.setText(ownersDto.getAddress());
                    lblMobileNo.setText(String.valueOf(ownersDto.getPhone()));

        }

        ArrayList<VehicleDto> vehicleDetails = vehicleBoImpl.getAll(vehicleId);
        for (VehicleDto vehicleDto : vehicleDetails) {
                    lblModel.setText(vehicleDto.getModel());
                    lblBrandName.setText(vehicleDto.getBrandName());
        }
        ArrayList<RevenueLicDto> revenueLicDtos = revenueLicBoBoImpl.getAll(ownerId);
        for (RevenueLicDto revenueLicDto : revenueLicDtos) {
                    lblRevenueLicence.setText(revenueLicDto.getRevenueLic());
                    lblIssueDate.setText(revenueLicDto.getDate_of_issue());
                    lblExpirationDate.setText(revenueLicDto.getExpires_date());

        }





        }


    public void searchOnAction(ActionEvent actionEvent) throws SQLException {
        SearchData(searchField.getText());
    }

    public void ExportBtnOnAction(ActionEvent actionEvent) {

        System.out.println("ll");
        String driverLic = searchField.getText();

        if (driverLic == null) {
            return;
        }

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(
                    getClass()
                            .getResourceAsStream("/Report/OwnerDetails.jrxml"
                            ));

            Connection connection = DBConnection.getInstance().getConnection();

            Map<String, Object> parameters = new HashMap<>();

            parameters.put("P_Lic", driverLic);

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
