package com.dev.jbooklib.controller;

import com.dev.jbooklib.MainApp;
import com.dev.jbooklib.service.BookService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import org.controlsfx.control.StatusBar;

import static com.dev.jbooklib.util.Contants.COUNT_RECORD_INFO;
import static com.dev.jbooklib.util.Contants.DB_NAME;
import static com.dev.jbooklib.util.Contants.DB_NAME_INFO;
import static com.dev.jbooklib.util.MyUtils.showInfo;
import static javafx.geometry.Orientation.VERTICAL;

/**
 * Класс корневого элемента интерфейса приложения
 * Created by kolesnik on 11/04/2017.
 */
public class RootLayoutController {

    private MainApp mainApp;
    private Label lblDBInfo;
    private Label lblTotalCountInfo;

    @FXML
    private StatusBar sbMain;

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleSyncLib() {
        showInfo("Синхронизация....", "");
    }

    public void initControls() {

        lblDBInfo = new Label(String.format(DB_NAME_INFO, DB_NAME));
        lblTotalCountInfo = new Label(String.format(COUNT_RECORD_INFO, BookService.getBookCount()));

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

    public void setDBInfo(String msg) {
        lblDBInfo.setText(msg);
    }

    public void setTotalCountInfo(String msg) {
        lblTotalCountInfo.setText(msg);
    }

}
