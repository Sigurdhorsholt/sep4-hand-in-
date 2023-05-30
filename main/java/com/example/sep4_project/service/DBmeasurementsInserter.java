package com.example.sep4_project.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;


public class DBmeasurementsInserter {

    //Change these variabels to match what you want to insert. check that the range between ID's match the same type

    private static final int ID_START = 1;
    private static final int ID_END = 1;
    private static final int NUM_DAYS_TO_BE_INSERTED = 90;

    DatabaseConnector connect = new DatabaseConnector();

    //Algo to calculate sun intensity
    public static double calculateSunIntensity(LocalDateTime timeOfDay, int timeOfYear, double latitude) {
        // Convert timeOfDay to decimal hours (e.g., 12:30 PM = 12.5)
        double decimalTime = timeOfDay.getHour() + timeOfDay.getMinute() / 60.0;

        // Convert timeOfYear to the number of days since January 1st
        int dayOfYear = timeOfYear;

        // Calculate the solar elevation angle (in radians)
        double solarDeclination = -23.45 * Math.cos(Math.toRadians(360 * (dayOfYear + 10) / 365));
        double solarAltitude = Math.toDegrees(Math.asin(
                Math.sin(Math.toRadians(solarDeclination)) * Math.sin(Math.toRadians(latitude)) +
                        Math.cos(Math.toRadians(solarDeclination)) * Math.cos(Math.toRadians(latitude)) *
                                Math.cos(Math.toRadians(15 * (decimalTime - 12)))
        ));

        if (solarAltitude > 0) {
            return 1 - Math.cos(Math.toRadians(solarAltitude)); // Invert the intensity
        } else {
            return 0.0; // Set to maximum intensity (inverted)
        }
    }

    //Inserts sun intensity to DB
    public void insertMeasurements(int panelId, LocalDateTime startTime, int numDays) {
        //LocalDateTime start = LocalDateTime.of(2023,5,22,0,0);
        LocalDateTime start = startTime;
        int timeOfYear = start.getDayOfYear();
        double latitude = 37.7749; // Latitude of the location
        int hoursPerDay = 24; // Number of hours per day


        String baseQuery = "INSERT INTO sep4.sep4db.electrical_measurement (time_, panel_id, value_, power_input) VALUES (?,?,?,NULL)";
        Connection connection = connect.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(baseQuery);

            for (int day = 0; day < numDays; day++) {
                for (int hour = 0; hour < hoursPerDay; hour++) {

                    LocalDateTime currentTimeOfDay = startTime.plusDays(day).plusHours(hour);
                    double intensity = calculateSunIntensity(currentTimeOfDay, timeOfYear, latitude);
                    Timestamp measurementTime = Timestamp.valueOf(currentTimeOfDay);

                    statement.setTimestamp(1, measurementTime);
                    statement.setInt(2, panelId);
                    statement.setDouble(3, intensity);

                    statement.executeUpdate();



//                   not important. Used for testing:
//                String tmpQuery = "VALUES('"+measurementTime+"',"+panelId+","+intensity+",NULL)";
// String insertQuery = baseQuery + tmpQuery;
//                   System.out.println(baseQuery + tmpQuery);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        DBmeasurementsInserter measurement = new DBmeasurementsInserter();

        LocalDateTime START_OF_INSERT = LocalDateTime.of(2023, 5, 22, 8, 0);

        for (int id = ID_START; id <= ID_END; id ++){
            measurement.insertMeasurements(id,START_OF_INSERT,NUM_DAYS_TO_BE_INSERTED);
        }

    }


    }

