package com.assignment.service.Controller;

import com.assignment.service.Dto.DateDto;
import com.assignment.service.Dto.TopViolatedLawDto;
import com.assignment.service.Dto.TopViolatedPointDto;
import com.assignment.service.Model.DashboardModel;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public AnchorPane dashboardAnc;
    public LineChart lineChart;
    public Label DriverCountlbl;
    public javafx.scene.chart.AreaChart AreaChart;
    public BarChart <String,Integer>barchart;

    DashboardModel dashboardModel = new DashboardModel();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addDataToLineChart();
            setDriverCountLbl();
            addDataAreaChart();
            addTopViolatedLawAndTopLawPoint();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void addDataToLineChart() throws SQLException {

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("License");

        ArrayList<DateDto> allMonth = dashboardModel.getAllViolationMonth();

        for (DateDto dateDto : allMonth) {
            String month = dateDto.getMonth();
            int count = dateDto.getCount();

            series.getData().add(new XYChart.Data<>(month, count));

        }


        lineChart.getData().add(series);//meka wenas karanna one



    }
    private void addDataAreaChart() throws SQLException {

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("License Suspensions");

        ArrayList<DateDto> allSuspendLicByMonth = dashboardModel.getAllSuspendLicByMonth();

        for (DateDto dateDto : allSuspendLicByMonth) {
            String month = dateDto.getMonth();
            int count = dateDto.getCount();

            series.getData().add(new XYChart.Data<>(month, count));
        }    AreaChart.getData().add(series);//meka wenas karanna one


    }


    private void addTopViolatedLawAndTopLawPoint() throws SQLException {


        XYChart.Series <String,Integer> seriesTwo = new XYChart.Series<>();
        seriesTwo.setName("HighestPointLaws");

        ArrayList<TopViolatedPointDto> topViolatedPoints = dashboardModel.findTopViolatedPoint();


        for (TopViolatedPointDto topViolatedPointDto : topViolatedPoints) {

            String lawId = topViolatedPointDto.getLawId();
            int topViolatedLawDtoPoint= topViolatedPointDto.getPoint();

            seriesTwo.getData().add(new XYChart.Data<>(lawId,topViolatedLawDtoPoint));
        }
        barchart.getData().add(seriesTwo);
        System.out.println("Series data: " + seriesTwo.getData());





        XYChart.Series <String,Integer> series = new XYChart.Series<>();
        series.setName("Most Frequent Law");

        ArrayList<TopViolatedLawDto> topViolatedLaws = dashboardModel.findTopViolatedLaw();
        System.out.println(dashboardModel.findTopViolatedLaw());


        for (TopViolatedLawDto topViolatedLawDto : topViolatedLaws) {

            String lawId = topViolatedLawDto.getLawId();
            int topViolatedLawDtoCount = topViolatedLawDto.getCount();

            series.getData().add(new XYChart.Data<>(lawId,topViolatedLawDtoCount));
        }
        barchart.getData().add(series);
        System.out.println("Series data: " + series.getData());




    }



    private void setDriverCountLbl() throws SQLException {
       DriverCountlbl.setText(dashboardModel.driverCount());

    }




    }