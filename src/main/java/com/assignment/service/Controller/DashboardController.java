package com.assignment.service.Controller;

import com.assignment.service.Dto.DateDto;
import com.assignment.service.Dto.ProgressbarDto;
import com.assignment.service.Dto.TopViolatedLawDto;
import com.assignment.service.Dto.TopViolatedPointDto;
import com.assignment.service.Model.DashboardModel;
import com.assignment.service.Model.TrainingModel;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
    public Label ActiveDriverCountLbl;
    public PieChart trafficDonutChart;
    public PieChart revenueDonutChart;
    public PieChart trafficSourceDonutChart;
    public Label lblAllTrainingDrivers;
    public ProgressBar officer1;
    public ProgressBar officer2;
    public ProgressBar officer3;
    public ProgressBar officer4;
    public ProgressBar officer5;
    public ProgressBar officer6;
    public ProgressBar officer7;
    public ProgressBar officer8;
    public ProgressBar officer9;
    public ProgressBar officer10;
    public Label lblOfficer1;
    public Label percentage1;
    public Label lblOfficer2;
    public Label Percentage2;
    public Label lblOfficer3;
    public Label Percentage3;
    public Label lblOfficer4;
    public Label Percentage4;
    public Label lblOfficer5;
    public Label Percentage5;
    public Label lblOfficer6;
    public Label Percentage6;
    public Label lblOfficer7;
    public Label Percentage7;
    public Label lblOfficer8;
    public Label Percentage8;
    public Label lblOfficer9;
    public Label Percentage9;
    public Label lblOfficer10;
    public Label Percentage10;


    DashboardModel dashboardModel = new DashboardModel();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addDataToLineChart();
            setDriverCountLbl();
            addDataAreaChart();
            pieChart();//temp  ..................................
            addTopViolatedLawAndTopLawPoint();
            setTrainingDriversCountLbl();
            officerTask();
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


    private void officerTask() throws SQLException {

        ArrayList<ProgressbarDto> targetCompletionCount = dashboardModel.getTargetCompletionCount();

        officer1.setProgress(targetCompletionCount.get(0).getCount()/100.0);
        officer1.setProgress(targetCompletionCount.get(0).getCount() / 100.0);
        officer2.setProgress(targetCompletionCount.get(1).getCount() / 100.0);
        officer3.setProgress(targetCompletionCount.get(2).getCount() / 100.0);
        officer4.setProgress(targetCompletionCount.get(3).getCount() / 100.0);
        officer5.setProgress(targetCompletionCount.get(4).getCount() / 100.0);
        officer6.setProgress(targetCompletionCount.get(5).getCount() / 100.0);
        officer7.setProgress(targetCompletionCount.get(6).getCount() / 100.0);
        officer8.setProgress(targetCompletionCount.get(7).getCount() / 100.0);
        officer9.setProgress(targetCompletionCount.get(8).getCount() / 100.0);
        officer10.setProgress(targetCompletionCount.get(9).getCount() / 100.0);

        percentage1.setText(String.valueOf(targetCompletionCount.get(0).getCount())+"%");
        Percentage2.setText(String.valueOf(targetCompletionCount.get(1).getCount())+"%");
        Percentage3.setText(String.valueOf(targetCompletionCount.get(2).getCount())+"%");
        Percentage4.setText(String.valueOf(targetCompletionCount.get(3).getCount())+"%");
        Percentage5.setText(String.valueOf(targetCompletionCount.get(4).getCount())+"%");
        Percentage6.setText(String.valueOf(targetCompletionCount.get(5).getCount())+"%");
        Percentage7.setText(String.valueOf(targetCompletionCount.get(6).getCount())+"%");
        Percentage8.setText(String.valueOf(targetCompletionCount.get(7).getCount())+"%");
        Percentage9.setText(String.valueOf(targetCompletionCount.get(8).getCount())+"%");
        Percentage10.setText(String.valueOf(targetCompletionCount.get(9).getCount())+"%");

        lblOfficer1.setText(targetCompletionCount.get(0).getOfficerId());
        lblOfficer2.setText(targetCompletionCount.get(1).getOfficerId());
        lblOfficer3.setText(targetCompletionCount.get(2).getOfficerId());
        lblOfficer4.setText(targetCompletionCount.get(3).getOfficerId());
        lblOfficer5.setText(targetCompletionCount.get(4).getOfficerId());
        lblOfficer6.setText(targetCompletionCount.get(5).getOfficerId());
        lblOfficer7.setText(targetCompletionCount.get(6).getOfficerId());
        lblOfficer8.setText(targetCompletionCount.get(7).getOfficerId());
        lblOfficer9.setText(targetCompletionCount.get(8).getOfficerId());
        lblOfficer10.setText(targetCompletionCount.get(9).getOfficerId());


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

    TrainingModel trainingModel = new TrainingModel();
    private void setTrainingDriversCountLbl() throws SQLException {
       lblAllTrainingDrivers.setText(String.valueOf(trainingModel.getAllTrainingCount()));

    }


    private void pieChart() throws SQLException {
        trafficDonutChart.getData().add(new PieChart.Data("Category A", 30));
        trafficDonutChart.getData().add(new PieChart.Data("Category B", 20));



        revenueDonutChart.getData().add(new PieChart.Data("Category A", 25));
        revenueDonutChart.getData().add(new PieChart.Data("Category B", 20));
        revenueDonutChart.getData().add(new PieChart.Data("Category C", 30));
        revenueDonutChart.getData().add(new PieChart.Data("Category D", 15));
        revenueDonutChart.getData().add(new PieChart.Data("Category E", 10));


        trafficSourceDonutChart.getData().add(new PieChart.Data("Category A", 25));
        trafficSourceDonutChart.getData().add(new PieChart.Data("Category B", 15));
        trafficSourceDonutChart.getData().add(new PieChart.Data("Category C", 25));
        trafficSourceDonutChart.getData().add(new PieChart.Data("Category D", 10));
        trafficSourceDonutChart.getData().add(new PieChart.Data("Category E", 30));




    }




    }
