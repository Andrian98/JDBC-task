package com.company;

import java.sql.*;

public class Insert {


    public void insertInDb() throws SQLException {

        Statement statement = getConnection.getConnection().createStatement();

        ResultSet rsSelect = statement.executeQuery("select count(customer_id) from sales.customers;");

        while (rsSelect.next()) {
            System.out.println("Before insert in DB: " + rsSelect.getString(1) + " customers ID");
        }

        statement.executeUpdate("insert into sales.customers values('Kasha', 'Todd', '(022) 112-8889', 'kasha.todd@yahoo.com', '910 Vine Street', 'Campbell', 'CA', '5555');");

        rsSelect = statement.executeQuery("select count(customer_id) from sales.customers;");

        while (rsSelect.next()) {
            System.out.println("After insert in DB: " + rsSelect.getString(1)+ " customers ID");
        }
    }
}
