package com.example.sep4_project.view;

import com.example.sep4_project.Main;
import com.example.sep4_project.model.Model;
import com.example.sep4_project.service.DatabaseConnector;
import com.example.sep4_project.view.contactInfoView.ContactInfoViewController;
import com.example.sep4_project.view.dataOverview.DataOverviewController;
import com.example.sep4_project.view.histogram.HistogramViewController;
import com.example.sep4_project.view.lineChart.LineChartViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ViewHandler {


    private Stage primaryStage;

    private Model model;



    private Scene mainViewScene;

    private MainController mainController;


    public ViewHandler(Stage primaryStage, Model model){
        this.primaryStage = primaryStage;
        this.model = model;

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("mainView.fxml"));


// Set the controller factory
        loader.setControllerFactory(param -> {
            // Here you create the controller manually and pass the model instance into it
            if (param == MainController.class) {
                return new MainController(model);
            } else if (param == LineChartViewController.class) {
                return new LineChartViewController(model);
            } else if (param == DataOverviewController.class) {
                return new DataOverviewController(model);
            } else if (param == HistogramViewController.class) {
                return new HistogramViewController(model);
            } else if (param == ContactInfoViewController.class) {
                return new ContactInfoViewController(model);
            } else {
                // If this gets thrown, you might have forgotten to handle a new controller class above
                throw new RuntimeException("Unknown controller class: " + param);
            }
        });

        try {
            mainViewScene = new Scene(loader.load());
            // The loader will now return an instance created by the controller factory
            mainController = loader.getController();
        } catch (IOException e){
            System.out.println("Could not find mainview.fxml");
            e.printStackTrace();
            System.exit(1);
        }
        primaryStage.setTitle("Solar panel Monitoring");
        primaryStage.setScene(mainViewScene);
        primaryStage.show();

    }


}
