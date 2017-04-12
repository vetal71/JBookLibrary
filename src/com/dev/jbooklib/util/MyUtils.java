package com.dev.jbooklib.util;

import javafx.scene.control.Alert;
import static com.dev.jbooklib.util.Contants.*;

/**
 * Created by kolesnik on 11/04/2017.
 */
public class MyUtils {

    public static void showError(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(APP_NAME);
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void showInfo(String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(APP_NAME);
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
