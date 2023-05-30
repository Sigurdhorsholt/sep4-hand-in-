package com.example.sep4_project.service;

import com.example.sep4_project.model.ContactInfo;
import com.example.sep4_project.model.Measurement;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DBcriteriaLoader {

    DatabaseConnector connect = new DatabaseConnector();


    public List<Measurement> getmeasurements(String q) {
        List<Measurement> measurements = new ArrayList();
        try (Connection connection = connect.getConnection()) {

            String query = q;

            try(PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()){

                    Timestamp timestamp =resultSet.getTimestamp("hour_");
                    LocalDateTime time = timestamp.toLocalDateTime();
                    double value = resultSet.getDouble("sum_value");
                    Measurement measurement = new Measurement(time,value);
                    measurement.toString();

                    measurements.add(measurement);

                }
            }
        } catch (SQLException e){
            System.out.println("Error measurement query");
            e.printStackTrace();
        }

        return measurements;
    }

    private LocalDate startDate;
    private LocalDate endDate;
    private String panelType;
    private String specificPanelModel;
    private String manufacturer;
    private boolean specifiedPeriod;

    public String getCriteria(LocalDate startDate, LocalDate endDate, boolean specifiedPeriod, String panelType, String specificPanelModel, String manufacturer) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.specificPanelModel = specificPanelModel;
        this.manufacturer = manufacturer;
        this.specifiedPeriod = specifiedPeriod;
        this.panelType = panelType;

        String query =
                "SELECT DATE_TRUNC('hour', time_) as hour_, SUM(measurement_value) as sum_value " +
                        "FROM sep4db.electrical_output_view " +
                        "WHERE time_ >= '" + startDate.toString() + "' AND time_ <= '" + endDate.toString() + "'";


        if(panelType != null && !panelType.isEmpty()) {

            if (panelType.equals("Electrical (PV)")){
                query += " AND panel_type = 'electrical'";
            } else if (panelType.equals("Thermal")){
                query += " AND panel_type = 'Thermal'";
            }

        }

        if(specificPanelModel != null &&
                !specificPanelModel.isEmpty() &&
                !(specificPanelModel.equals("All")) ) {
            query += " AND model_no = '" + specificPanelModel + "'";
        }

        if(manufacturer != null &&
                !manufacturer.isEmpty() &&
                  !(manufacturer.equals("All")) ) {
            query += " AND manufacturer = '" + manufacturer + "'";
        }

        query += " GROUP BY hour_ ORDER BY hour_ ASC;";

        return query;
    }


    public double valueSummed(){
        double sum = 0;

        try (Connection connection = connect.getConnection()) {

            String query = getCriteria(startDate,endDate,specifiedPeriod,panelType,specificPanelModel,manufacturer);

            try(PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()){
                    sum += resultSet.getDouble("sum_value");
                    System.out.println(sum);
                }
            }
        } catch (SQLException e){
            System.out.println("Error measurement query");
            e.printStackTrace();
        }
        return sum;
    }

    public List<ContactInfo> getContactInfo(String manufacturer){
        List<ContactInfo> info = new ArrayList<>();
        String query = "SELECT * " +
                "FROM sep4db.contact_info " +
                "WHERE name = '"+manufacturer+"'";
        try(Connection connection = connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()){
                LocalDateTime timeAdd = resultSet.getTimestamp("time_add").toLocalDateTime();
                String name = resultSet.getString("name");
                String phoneNo = resultSet.getString("phone_no");
                String email = resultSet.getString("email");

                info.add(new ContactInfo(timeAdd,name,phoneNo,email));
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return info;
    }


}
