package com.dev.jbooklib.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnection {

    public static Connection Connector() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:WorkLibrary.db");
            return conn;
        } catch (Exception e) {
            //TODO
            return null;
        }
    }

}
