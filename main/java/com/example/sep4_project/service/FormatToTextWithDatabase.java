package com.example.sep4_project.service;

import java.io.*;
import java.sql.*;

public class FormatToTextWithDatabase {

    static DatabaseConnector connect = new DatabaseConnector();

    public static void main(String[] args) {
        String templateFileName = "template.txt";
        String outputFileName = "output.txt";

        try (Connection connection = connect.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM sep4db.electrical_output_view ");
             BufferedReader reader = new BufferedReader(new FileReader(templateFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            // Read the entire template into a String
            StringBuilder templateBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                templateBuilder.append(line).append('\n');
            }
            String template = templateBuilder.toString();

            // Replace placeholders in the template for each row in the ResultSet
            while (resultSet.next()) {
                String replacedTemplate = replacePlaceholders(template, resultSet);
                writer.write(replacedTemplate);
                writer.newLine();
            }

            System.out.println("Text file with template and database data created successfully!");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String replacePlaceholders(String template, ResultSet resultSet) throws SQLException {
        String time_ = resultSet.getString("time_");
        String panel_type = resultSet.getString("panel_type");
        String model_no = resultSet.getString("model_no");
        String manufacturer = resultSet.getString("manufacturer");
        String measurement_value = resultSet.getString("measurement_value");

        template = template.replace("${type}", panel_type);
        template = template.replace("${model_no}", model_no);
        template = template.replace("${time}", time_);
        template = template.replace("${manufacturer}", manufacturer);
        template = template.replace("${value}", measurement_value);

        return template;
    }
}
