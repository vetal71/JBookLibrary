package com.dev.jbooklib.model;

import com.dev.jbooklib.database.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

import static com.dev.jbooklib.util.MyUtils.showError;

public class LoginModel {

    Connection connection;

    public LoginModel() {
        connection = DBConnection.getConnection();
        if (connection == null) {
            showError("Ошибка подключения к базе данных.", "");
            System.exit(1);
        }
    }

    public boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
