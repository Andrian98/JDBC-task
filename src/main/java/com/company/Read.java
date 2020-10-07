package com.company;


import java.sql.*;


public class Read {


    public void readFromDb() throws SQLException {

        Statement statement = getConnection.getConnection().createStatement();

        ResultSet rs = statement.executeQuery("select * from [sales].[customers] where customer_id = 2");

        while (rs.next()) {
            System.out.println("Read from DB: " + rs.getString(2) + "| " + rs.getString(3) + "| " + rs.getString(4) + "| " + rs.getString(5) + "| " + rs.getString(6) + "| " + rs.getString(7) + "| " + rs.getString(8));
        }
    }

}
