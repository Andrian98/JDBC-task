package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class BulkInsert {

    public void bulkInsertInDb() throws SQLException, IOException {

        String sqlQuerry = "insert into sales.customers values(?, ?, ?, ?, ?, ?, ?,?);";
        PreparedStatement preparedStatement = getConnection.getConnection().prepareStatement(sqlQuerry);
        Statement statement = getConnection.getConnection().createStatement();

        ResultSet rsSelect = statement.executeQuery("select count(customer_id) from sales.customers;");

        while (rsSelect.next()) {
            System.out.println("Before insert in DB: " + rsSelect.getString(1) + " customers ID");
        }

        String csvFile = "DataTask55.csv";
        int batchSize = 30;

        getConnection.getConnection().setAutoCommit(false);

        BufferedReader lineReader = new BufferedReader(new FileReader(csvFile));
        String lineText = null;
        int count = 0;

        while ((lineText = lineReader.readLine()) != null) {

            String[] data = lineText.split(",");

            String first_name = data[0];
            String last_name = data[1];
            String phone = data[2];
            String email = data[3];
            String street = data[4];
            String city = data[5];
            String state = data[6];
            String zip_code = data[7];

            count++;

            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, street);
            preparedStatement.setString(6, city);
            preparedStatement.setString(7, state);
            preparedStatement.setString(8, zip_code);

            preparedStatement.addBatch();
            if (count % batchSize == 0) {
                preparedStatement.executeBatch();
            }
        }
        lineReader.close();
        preparedStatement.executeBatch();

        rsSelect = statement.executeQuery("select count(customer_id) from sales.customers;");

        while (rsSelect.next()) {
            System.out.println("After insert in DB: " + rsSelect.getString(1) + " customers ID");
        }

        getConnection.getConnection().commit();
        getConnection.getConnection().close();
    }
}
