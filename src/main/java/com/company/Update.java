package com.company;

import java.sql.*;

public class Update {

    public void updateInDb() throws SQLException {

        Statement statement = getConnection.getConnection().createStatement();

        ResultSet rsSelect = statement.executeQuery("select phone from [sales].[customers] where customer_id = 2");

        while (rsSelect.next()) {
            System.out.println("Before DB update: " + rsSelect.getString(1));
        }

        statement.executeUpdate("update [sales].[customers] set phone = '(022) 112-8880' where customer_id = 2");


        rsSelect = statement.executeQuery("select phone from [sales].[customers] where customer_id = 2");

        while (rsSelect.next()) {
            System.out.println("After DB update: " + rsSelect.getString(1));
        }
    }
}
