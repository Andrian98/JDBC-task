package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnection {
    static String user;
    static String password;

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:sqlserver://localhost;" + "database=BikeStores;" + "user=" + user + ";" + "password=" + password + ";";

        return DriverManager.getConnection(url);
    }
}
