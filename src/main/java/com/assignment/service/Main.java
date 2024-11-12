package com.assignment.service;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/HomePage.fxml"))));




        stage.setTitle("Vehicle Point Management System");


        stage.show();
    }
    public static void main(String[] args) {launch(args);}
}
