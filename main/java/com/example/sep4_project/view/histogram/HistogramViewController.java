package com.example.sep4_project.view.histogram;

import com.example.sep4_project.model.Model;
import com.example.sep4_project.view.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HistogramViewController {

    @FXML
    Button testBtn;

    private ViewHandler viewHandler;
    private Model model;

    public HistogramViewController(Model model) {
        this.model = model;
    }

    public void init(ViewHandler viewHandler, Model model) {
        this.viewHandler = viewHandler;
        this.model = model;
        System.out.println("model set in hist" + model.toString());
    }

    public void testBtn(ActionEvent event){
        System.out.println("btn works hist view");
        model.setTestValue();
    }

}
