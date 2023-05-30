package com.example.sep4_project.service;

import com.example.sep4_project.model.Manufacturer;
import com.example.sep4_project.model.PanelModel;
import com.example.sep4_project.model.SolarPanel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InitialDBLoader {


    DatabaseConnector connect = new DatabaseConnector();

    public ObservableList<SolarPanel> loadSolarpanels(){

        ObservableList<SolarPanel> solarPanels = FXCollections.observableArrayList();
        // Passing connection as parameter to try statement.
        //Connection is AutoClosable so this way it will automatically close at the end of the try statement
        try (Connection connection = connect.getConnection()){

            String query = "SELECT sp.panel_id, sp.installation_date, sp.model_no, ap.row_, ap.column_ " +
                    "FROM sep4db.solar_panel sp " +
                    "JOIN sep4db.active_panel ap ON sp.panel_id = ap.panel_id";

            // PreparedStatement and ResultSet are AutoClosable
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()){

                while (resultSet.next()){
                    int panelId = resultSet.getInt("panel_id");
                    LocalDate installationDate = resultSet.getDate("installation_date").toLocalDate();
                    String modelNo = resultSet.getString("model_no");
                    int row = resultSet.getInt("row_");
                    int column = resultSet.getInt("column_");

                    SolarPanel solarPanel = new SolarPanel();

                    solarPanel.setPanelId(panelId);
                    solarPanel.setInstallationDate(installationDate);
                    solarPanel.setModelNo(modelNo);
                    solarPanel.setRow(row);
                    solarPanel.setColumn(column);

                    solarPanels.add(solarPanel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return solarPanels;
    }


    public ObservableList<Manufacturer> loadManufacturer(){

        ObservableList<Manufacturer> manufacturers = FXCollections.observableArrayList();

        try (Connection connection = connect.getConnection()){
            String query = "SELECT m.name, c.phone_no, c.email, c.time_add " +
                    "FROM sep4db.manufacturer m " +
                    "JOIN sep4db.contact_info c " +
                    "ON m.name = c.name " +
                    "WHERE c.time_add = (" +
                    "SELECT MAX(time_add) " +
                    "FROM sep4db.contact_info " +
                    "WHERE name = m.name);";

            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()){

                while (resultSet.next()){{
                        Manufacturer manufacturer = new Manufacturer();
                        manufacturer.setName(resultSet.getString("name"));
                        manufacturer.setPhoneNo(resultSet.getString("phone_no"));
                        manufacturer.setEmail(resultSet.getString("email"));

                        manufacturers.add(manufacturer);
                    }

                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return manufacturers;
    }
    public ObservableList<PanelModel> loadPanelModels(){
        ObservableList<PanelModel> panelModels = FXCollections.observableArrayList();
        try(Connection connection = connect.getConnection()){
            String query = "SELECT * FROM sep4db.model";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()){

                while (resultSet.next()){{
                        PanelModel panelModel = new PanelModel();
                        panelModel.setModelNo(resultSet.getString("model_no"));
                        panelModel.setType(resultSet.getString("type_"));
                        panelModel.setManufacturer(resultSet.getString("manufacturer"));
                        panelModel.setType(resultSet.getString("type_"));

                        panelModels.add(panelModel);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return panelModels;
    }





}
