package com.example.sep4_project.view;

import com.example.sep4_project.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import impl.org.controlsfx.*;
import org.controlsfx.control.CheckComboBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    /*
    @FXML
    private Tab dataoverviewTab;

    @FXML
    private Tab histogramTab;

    @FXML
    private Tab linechartTab;

*/


    @FXML
    protected TabPane tabPane;

    @FXML
    CheckBox allDatesChoiceBox;

    @FXML
    DatePicker startDatePicker;

    @FXML
    DatePicker endDatePicker;
    @FXML
    ChoiceBox typeDropbox;
    @FXML
    ChoiceBox specificPanelDropbox;
    @FXML
    ChoiceBox manufacturerDropbox;
    @FXML
    ChoiceBox activeOldDropbox;
    @FXML
    Button updateCharts;

    @FXML
    Button setCriteria;



    private ViewHandler viewHandler;
    private Model model;


    @FXML
    void updateCharts(ActionEvent event) {

        System.out.println("Update button pressed...");

    }


    private LocalDate startDate;
    private LocalDate endDate;
    private boolean specifiedPeriod;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startDatePicker.setOnAction(event -> {
            startDate = startDatePicker.getValue();
        });

        endDatePicker.setOnAction(event -> {
            endDate = endDatePicker.getValue();
        });
        allDatesChoiceBox.setOnAction(event -> {
            specifiedPeriod = allDatesChoiceBox.isSelected();
        });
        for (int i = 0; i < model.getModels().size(); i ++){
            String str = model.getModels().get(i).getModelNo();
            specificPanelDropbox.getItems().add(str);
        }

        for (int i = 0; i < model.getManufacturers().size(); i ++){
            String str = model.getManufacturers().get(i).getName();
            manufacturerDropbox.getItems().add(str);
        }
        String e = "Electrical (PV)", t = "Thermal";
        typeDropbox.getItems().add(e);
        typeDropbox.getItems().add(t);
    }


    public void setCriteria(ActionEvent event){
        String panelType = typeDropbox.getValue().toString();
        String specificPanelModel = specificPanelDropbox.getValue().toString();
        String manufacturer = manufacturerDropbox.getValue().toString();

        System.out.println(specificPanelDropbox.getValue());
        System.out.println(manufacturerDropbox.getValue());

        model.setCriteria(startDate,endDate,specifiedPeriod,panelType,specificPanelModel,manufacturer);
    }



    public MainController(Model model){
        this.model = model;
    }

    public void init(ViewHandler viewHandler, Model model) {
        this.viewHandler = viewHandler;
        this.model = model;
        System.out.println("model set in main:  " + model.toString());
    }

}