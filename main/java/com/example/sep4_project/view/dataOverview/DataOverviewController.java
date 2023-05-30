package com.example.sep4_project.view.dataOverview;

import com.example.sep4_project.model.Model;
import com.example.sep4_project.view.ViewHandler;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataOverviewController {
    @FXML
    private Button getData;

    @FXML
    private Label manufacturerLabel;

    @FXML
    private Label modelLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label valueSumLabel;
    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> manufacturerC, modelC,timeC,typeC,valueC;


    private ViewHandler viewHandler;
    private Model model;

    public DataOverviewController(Model model) {
        this.model = model;
    }

    public void init(ViewHandler viewHandler, Model model) {
        this.viewHandler = viewHandler;
        this.model = model;
    }



    public void setData(){
        typeLabel.setText(model.getPanelType());
        timeLabel.setText("From: "+model.getStartDate()+", To: "+model.getEndDate());
        modelLabel.setText(model.getSpecificPanelModel());
        manufacturerLabel.setText(model.getManufacturer());
        valueSumLabel.setText(String.valueOf(model.getdBcriteriaLoader().valueSummed()));

        fillTable();
    }

    public void fillTable() {
//
//     manufacturerC.setCellValueFactory(new PropertyValueFactory<Object,String>());
//
//
//     modelC,timeC,typeC,valueC;
//
//        ObservableList<>
//


    }

}
