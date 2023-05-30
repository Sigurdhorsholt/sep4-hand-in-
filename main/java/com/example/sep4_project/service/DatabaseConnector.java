package com.example.sep4_project.service;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DatabaseConnector {

    private Connection connection;



    public void connect(String host, int portNo, String userName, String password) {




        // Establishing a PostgreSQL database connection
        String url = "jdbc:postgresql://localhost:5432/sep4";



        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established to: " + url);

            Statement statement = connection.createStatement();
            String query = "SELECT count(*) " +
                    "from sep4.sep4db.solar_panel;";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                System.out.println("Count: " + count);
            }

        }
        catch (Exception exception) {
            System.out.println("Connection failed in connect test method...");
            exception.printStackTrace();
        }
    }

    public Connection getConnection(){
        String username = "postgres";
        String password = "1234";
        String url = "jdbc:postgresql://localhost:5432/sep4";


        try {

            connection = DriverManager.getConnection(url,username,password);

        } catch(Exception e) {
            System.out.println("Connection failed in getConnection");
            e.printStackTrace();
        }
        return  connection;

    }


}
