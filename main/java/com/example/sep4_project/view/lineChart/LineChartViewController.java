package com.example.sep4_project.view.lineChart;


import com.example.sep4_project.model.Measurement;
import com.example.sep4_project.model.Model;
import com.example.sep4_project.view.ViewHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.util.StringConverter;

import java.util.Date;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;


public class LineChartViewController {

    @FXML
    private Button testBtn;
    @FXML
    private Button clearTableBtn;


    private ViewHandler viewHandler;
    private Model model;

    public LineChartViewController(Model model) {
        this.model = model;
    }

//    public void init(ViewHandler viewHandler, Model model) {
//        this.viewHandler = viewHandler;
//        this.model = model;
//        System.out.println("model set in line " + model.toString());
//        model.setTestValue();
//
//    }
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxiz = new NumberAxis();
    @FXML
    private LineChart linechart = new LineChart<>(xAxis,yAxiz);

    public void handleBtn(ActionEvent e){
        setLinechart();
    }

    public void setLinechart(){
        xAxis.setLabel("Date");
        yAxiz.setLabel("Value");
        XYChart.Series series = new XYChart.Series();

        String q = model.getCriteriaQuery();
        List<Measurement> list = model.getdBcriteriaLoader().getmeasurements(q);



        for (int i = 0; i < list.size(); i++){
            double value = list.get(i).getValue();
            String time = list.get(i).getTimeOfMeasurement().toString();
            series.getData().add(new XYChart.Data(time, value));
        }

        linechart.getData().add(series);


    }


    public void clearTable(){

        linechart.getData().clear();

    }

}
