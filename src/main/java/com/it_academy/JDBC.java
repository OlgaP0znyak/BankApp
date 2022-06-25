package com.it_academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private static final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private static final String DATABASE_URL =
            "jdbc:sqlite:c:\\Users\\olapo\\IdeaProjects\\Bank\\Bank_DB.db";

    private static boolean isDriverExists() {
        try {
            Class.forName(JDBC_DRIVER_PATH);
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC Driver not found");
            return false;
        }
    }

    public static Connection openConnection() throws SQLException {
        if (isDriverExists()) {
            return DriverManager.getConnection(DATABASE_URL);
        } else
            System.out.println("Connection error.");
        return null;
    }
}
