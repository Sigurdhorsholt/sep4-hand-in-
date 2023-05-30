package com.example.sep4_project;

import com.example.sep4_project.model.Model;
import com.example.sep4_project.service.DatabaseConnector;
import com.example.sep4_project.view.ViewHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Model model = new Model();
        //model.setTestValue();
        ViewHandler viewHandler = new ViewHandler(primaryStage, model);

    }

    public static void main(String[] args) {
        launch();
    }
}