package com.company;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static String user;
    public static String password;


    public static void main(String[] args) throws SQLException, IOException {


        try {
            user = args[0];
            password = args[1];

        } catch (Exception e) {
            System.out.println("Arguments not found");
        }

        getConnection.user = user;
        getConnection.password = password;


        //new Read().readFromDb();
//        new Update().updateInDb();
        //new Insert().insertInDb();
        //new Delete().deleteInDb();
//        new BulkInsert().bulkInsertInDb();

    }

}
