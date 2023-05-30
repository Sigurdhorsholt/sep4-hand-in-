package com.example.sep4_project.model;

import javafx.scene.shape.StrokeLineCap;

import java.time.LocalDateTime;

public class Measurement {

    private LocalDateTime timeOfMeasurement;
    private String type;
    private double value;




    public Measurement(LocalDateTime time, String type){
        this.timeOfMeasurement = time;
    }
    public Measurement(LocalDateTime time, double value){
        this.timeOfMeasurement = time;
        this.value = value;
    }



    public String toString(){
        return "Measurement: time: "+ timeOfMeasurement + ", value: "+ value+"\n";
    }
    public LocalDateTime getTimeOfMeasurement() {
        return timeOfMeasurement;
    }

    public String getType() {
        return type;
    }

    public double getValue() {
        return value;
    }
}
