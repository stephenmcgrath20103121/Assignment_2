package com.example.assignment_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class ServiceApplication extends Application {
    public static Scene scene,scene2,scene3;
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ServiceApplication.class.getResource("gamesMachine.fxml"));
        scene = new Scene(fxmlLoader.load(), 1000, 800);

        fxmlLoader=new FXMLLoader(ServiceApplication.class.getResource("game.fxml"));
        scene2=new Scene(fxmlLoader.load(),1000,800);

        fxmlLoader=new FXMLLoader(ServiceApplication.class.getResource("gamePort.fxml"));
        scene3=new Scene(fxmlLoader.load(),1000,800);

        stage.setTitle("Retro Games Information System");
        stage.setScene(scene);
        stage.show();
        primaryStage=stage;
    }

    public static void main(String[] args) {
        launch();
    }

    public static void switchScene1(){
        primaryStage.setScene(scene);
    }

    public static void switchScene2(){
        primaryStage.setScene(scene2);
    }

    public static void switchScene3(){
        primaryStage.setScene(scene3);
    }
}