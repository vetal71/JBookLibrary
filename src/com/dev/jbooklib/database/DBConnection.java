package com.dev.jbooklib.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.dev.jbooklib.util.Contants.DB_NAME;
import static com.dev.jbooklib.util.MyUtils.showError;

public class DBConnection {

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (Exception e) {
                showError("Ошибка загрузки драйвера SQLITE", e.getMessage());
            }
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);
            } catch (SQLException e) {
                showError(String.format("Ошибка подключения к базе данных %s", DB_NAME), e.getMessage());
                System.exit(1);
            }
            return conn;
        } else {
            return conn;
        }
    }

}
