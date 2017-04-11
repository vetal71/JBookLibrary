package com.dev.jbooklib.controller;

import com.dev.jbooklib.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import org.controlsfx.control.StatusBar;

import static com.dev.jbooklib.util.MyUtils.showInfo;
import static javafx.geometry.Orientation.VERTICAL;

/**
 * Класс корневого элемента интерфейса приложения
 * Created by kolesnik on 11/04/2017.
 */
public class RootLayoutController {

    private MainApp mainApp;

    @FXML
    private StatusBar sbMain;

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleSyncLib() {
        showInfo("Синхронизация....");
    }

    public void initControls() {

        Label lblDBInfo = new Label("База данных:");
        Label lblTotalCountInfo = new Label("Всего книг в библиотеке:");

        sbMain.getRightItems().add(new Separator(VERTICAL));
        sbMain.getRightItems().add(lblTotalCountInfo);
        sbMain.getRightItems().add(new Separator(VERTICAL));
        sbMain.getRightItems().add(lblDBInfo);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setStatusInfo(String msg) {
        sbMain.setText(msg);
    }

}
