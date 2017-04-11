package com.dev.jbooklib.controller;

import com.dev.jbooklib.model.LoginModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public LoginModel loginModel = new LoginModel();

    @FXML
    private Label isConnected;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (loginModel.isDbConnected()) {
            isConnected.setText("Соединение успешно...");
        } else {
            isConnected.setText("Нет соединения с базой данных...");
        }
    }
}
