module com.assignment.vehiclelicensepointsys.service.vehiclelicensepointsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.assignment.service.Controller to javafx.fxml;
    exports com.assignment.service;
}