package com.example.sep4_project.model;

public class PanelModel {


    public String getModelNo() {
        return modelNo;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getType() {
        return type;
    }

    private String modelNo;
    private String manufacturer;
    private String type;

    public void setModelNo(String model_no) {
        this.modelNo = model_no;

    }

    public void setType(String type) {
        this.type = type;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
