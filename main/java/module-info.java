module com.example.sep4_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires controlsfx;

    opens com.example.sep4_project to javafx.fxml;
    exports com.example.sep4_project;

    exports com.example.sep4_project.view;
    opens com.example.sep4_project.view to javafx.fxml;


    exports com.example.sep4_project.view.lineChart to javafx.fxml;
    opens com.example.sep4_project.view.lineChart to javafx.fxml;

    exports com.example.sep4_project.view.histogram to javafx.fxml;
    opens com.example.sep4_project.view.histogram to javafx.fxml;


    exports com.example.sep4_project.view.dataOverview to javafx.fxml;
    opens com.example.sep4_project.view.dataOverview to javafx.fxml;

    exports com.example.sep4_project.view.contactInfoView to javafx.fxml;
    opens com.example.sep4_project.view.contactInfoView to javafx.fxml;


    opens com.example.sep4_project.model to javafx.base;



    exports com.example.sep4_project.service;



}