package com.example.sep4_project.model;

import com.example.sep4_project.service.DBcriteriaLoader;
import com.example.sep4_project.service.InitialDBLoader;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Model {


    private ObservableList<SolarPanel> solarPanels;
    private ObservableList<PanelModel> models;
    private ObservableList<Manufacturer> manufacturers;


    InitialDBLoader initialDBLoader = new InitialDBLoader();
    DBcriteriaLoader dBcriteriaLoader = new DBcriteriaLoader();

    //Sorting Criteria Variables:
    private boolean specifiedPeriod;

    private LocalDate startDate;

    public String getPanelType() {
        return panelType;
    }

    public String getSpecificPanelModel() {
        return specificPanelModel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    private LocalDate endDate;
    private String panelType;
    private String specificPanelModel;
    private String manufacturer;

    public String getCriteriaQuery(){
        return dBcriteriaLoader.getCriteria(startDate,endDate,specifiedPeriod,panelType,specificPanelModel,manufacturer);
    }
    public void setCriteria(LocalDate startDate, LocalDate endDate, boolean specifiedPeriod, String panelType,String specificPanelModel,String manufacturer){
        this.startDate = startDate;
        if (this.startDate.isBefore(endDate)){
            this.endDate = endDate;
        } else {
            return;
        }
        this.specifiedPeriod = specifiedPeriod;
        this.panelType = panelType;
        this.specificPanelModel = specificPanelModel;
        this.manufacturer = manufacturer;

//        System.out.println("start date: " + startDate+
//                        "\nend date: " + endDate +
//                            "\nSpecifiec period: "+ specifiedPeriod);
//        List<Measurement> list = dBcriteriaLoader.getmeasurements(startDate,endDate);
//        System.out.println(list);

        String str = dBcriteriaLoader.getCriteria(startDate,endDate,specifiedPeriod,panelType,specificPanelModel,manufacturer);
        System.out.println(str);

    }

    public DBcriteriaLoader getdBcriteriaLoader() {
        return dBcriteriaLoader;
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }



    private int testValue = 0;





    public Model(){
        setManufacturers(getInitialDBLoader().loadManufacturer());
        System.out.println("manufacturers loaded");
        setModels(getInitialDBLoader().loadPanelModels());
        System.out.println("panel models loaded");
        setSolarPanels(getInitialDBLoader().loadSolarpanels());
        System.out.println("solar panels loaded");
    }




    public void setTestValue() {
        testValue = testValue + 1;
        System.out.println("Test value incrementet to +" + testValue);
    }
    public InitialDBLoader getInitialDBLoader() {
        return initialDBLoader;
    }

    public ObservableList<SolarPanel> getSolarPanels() {
        return solarPanels;
    }

    public void setSolarPanels(ObservableList<SolarPanel> solarPanels) {
        this.solarPanels = solarPanels;
    }
    public ObservableList<PanelModel> getModels() {
        return models;
    }

    public void setModels(ObservableList<PanelModel> models) {
        this.models = models;
    }

    public ObservableList<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(ObservableList<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

}
