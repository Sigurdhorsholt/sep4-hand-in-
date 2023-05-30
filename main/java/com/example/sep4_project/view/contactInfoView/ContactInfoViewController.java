package com.example.sep4_project.view.contactInfoView;

import com.example.sep4_project.model.ContactInfo;
import com.example.sep4_project.model.Model;
import com.example.sep4_project.view.ViewHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class ContactInfoViewController implements Initializable {


    @FXML
    private TableColumn<ContactInfo, String> emailC;

    @FXML
    private ChoiceBox manufacturerDrop;

    @FXML
    private TableColumn<ContactInfo, String> phoneC;

    @FXML
    private TableColumn<ContactInfo, LocalDateTime> timeC;

    @FXML
    private TableView tableView;



    private ViewHandler viewHandler;
    private Model model;

    public ContactInfoViewController(Model model) {
        this.model = model;
    }

    public void init(ViewHandler viewHandler, Model model) {
        this.viewHandler = viewHandler;
        this.model = model;
    }




    public void fillTable() {

        timeC.setCellValueFactory(new PropertyValueFactory<ContactInfo, LocalDateTime>("timeAdd"));
        phoneC.setCellValueFactory(new PropertyValueFactory<ContactInfo, String>("phoneNo"));
        emailC.setCellValueFactory(new PropertyValueFactory<ContactInfo, String>("email"));


        String manufacturer = manufacturerDrop.getValue().toString();
        ObservableList<ContactInfo> info = FXCollections.observableArrayList(model.getdBcriteriaLoader().getContactInfo(manufacturer));

        tableView.setItems(info);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < model.getManufacturers().size(); i ++){
            String str = model.getManufacturers().get(i).getName();
            manufacturerDrop.getItems().add(str);
        }

    }
}
