package com.company;

import java.sql.*;

public class Delete {

    public void deleteInDb() throws SQLException {

        Statement statement = getConnection.getConnection().createStatement();

        ResultSet rsSelect = statement.executeQuery("select count(customer_id) from sales.customers;");

        while (rsSelect.next()) {
            System.out.println("Before DB deleted: " + rsSelect.getString(1)+ " customers ID");
        }

        statement.executeUpdate("delete from [sales].[customers] where phone = '(022) 112-8889';");

        rsSelect = statement.executeQuery("select count(customer_id) from sales.customers;");

        while (rsSelect.next()) {
            System.out.println("After DB deleted: " + rsSelect.getString(1)+ " customers ID");
        }
    }
}
