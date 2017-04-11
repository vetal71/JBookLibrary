package com.dev.jbooklib;

import com.dev.jbooklib.controller.BookOverviewController;
import com.dev.jbooklib.controller.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    // основной объект
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Библиотека книг");
        // установим иконку приложения
        this.primaryStage.getIcons().add(new Image("file:resources/BookManager.png"));

        //инициализация корневого элемента интерфейса
        initRootLayout();

        //отображение данных
        showBookOverview();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * инициализация корневого элмента интерфейса
     */
    private void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Даём контроллеру доступ к главному прилодению.
            RootLayoutController controller = loader.getController();
            controller.initControls();
            controller.setMainApp(this);
            controller.setStatusInfo("Приложение загружено успешно!!!");

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showBookOverview() {
        try {
            // загружаем сведения об адресатах
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BookOverview.fxml"));
            AnchorPane bookOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(bookOverview);

            // Даём контроллеру доступ к главному приложению.
            BookOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
