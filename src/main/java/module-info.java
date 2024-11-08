module com.assignment.vehiclelicensepointsys.service.vehiclelicensepointsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;

    opens com.assignment.service.Controller to javafx.fxml;
    opens com.assignment.service.Dto to javafx.base;
    exports com.assignment.service;
}
