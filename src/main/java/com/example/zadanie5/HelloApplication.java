package com.example.zadanie5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override

    //программа начинается с этого метода
    public void start(Stage primaryStage) throws Exception {
        //Назначаем главным объектом графики файл hello.fxml
        Parent root = FXMLLoader.load(this.getClass().getResource("hello.fxml"));
        //Задаём сцене оюъект графики и размеры (их кста можно поменять)
        Scene scene = new Scene(root, 700.0D, 600.0D);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}