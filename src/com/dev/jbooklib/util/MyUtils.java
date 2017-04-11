package com.dev.jbooklib.util;

import javafx.scene.control.Alert;
import static com.dev.jbooklib.util.Contants.*;

/**
 * Created by kolesnik on 11/04/2017.
 */
public class MyUtils {

    public static void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(APP_NAME);
        alert.setHeaderText(DIALOG_ERROR_CAPTION);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void showInfo(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(APP_NAME);
        alert.setHeaderText(DIALOG_INFO_CAPTION);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
