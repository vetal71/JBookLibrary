package com.dev.jbooklib.controller;

import com.dev.jbooklib.model.LoginModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.dev.jbooklib.util.Contants.DB_NAME;

public class LoginController implements Initializable {

    public LoginModel loginModel = new LoginModel();
    public Boolean isConnected;
    private Stage loginStage;

    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
    }

    @FXML
    private Label lblStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        isConnected = loginModel.isDbConnected();
        if (isConnected) {
            lblStatus.setText(String.format("Соединение с базой данных %s успешно.", DB_NAME));
        } else {
            lblStatus.setText(String.format("Нет соединения с базой данных %s.", DB_NAME));
        }
    }

    @FXML
    private void handleOK() {
        loginStage.close();
    }

    @FXML
    private void handleCancel() {
        System.exit(0);
    }

}
