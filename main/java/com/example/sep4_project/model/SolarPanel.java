package com.example.sep4_project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SolarPanel {




    private LocalDate installationDate;
    private String modelNo;
    private int panelId;
    private String status;
    private int row;
    private int column;
    private ArrayList<Measurement> measurements;

    public void setPanelId(int panelId) {
        this.panelId = panelId;
    }

    public void setInstallationDate(LocalDate installationDate) {
        this.installationDate = installationDate;
    }

    public void setModelNo(String panelModel) {
        this.modelNo = panelModel;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column =column;
    }


//    public SolarPanel(LocalDate installationDate, PanelModel modelNo, int panelId, int row, int column) {
//        this.installationDate = installationDate;
//        this.modelNo = modelNo;
//        this.panelId = panelId;
//        this.row = row;
//        this.column = column;
//    }



}
