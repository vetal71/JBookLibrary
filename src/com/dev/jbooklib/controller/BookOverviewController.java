package com.dev.jbooklib.controller;

import com.dev.jbooklib.MainApp;
import com.dev.jbooklib.model.Category;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import java.net.URL;
import java.util.ResourceBundle;

public class BookOverviewController implements Initializable {

    private MainApp mainApp;

    @FXML
    private TreeTableView<Category> tvCategory;
    @FXML
    private TreeTableColumn<Category, Integer> colId;
    @FXML
    private TreeTableColumn<Category, String> colName;
    @FXML
    private TreeTableColumn<Category, Integer> colCount;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }
}
