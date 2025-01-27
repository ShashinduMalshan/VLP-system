module com.assignment.vehiclelicensepointsys.service.vehiclelicensepointsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires com.google.protobuf;
    requires mysql.connector.j;
    requires java.mail;
    requires net.sf.jasperreports.core;

    opens com.assignment.service.Controller to javafx.fxml;
    opens com.assignment.service.Model to javafx.base;
    exports com.assignment.service;
    opens com.assignment.service.DAO to javafx.base;
    opens com.assignment.service.DAO.Custom to javafx.base;
}
