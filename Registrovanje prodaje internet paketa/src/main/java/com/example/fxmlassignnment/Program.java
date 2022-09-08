package com.example.fxmlassignnment;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Program extends Application {
    private double dragOffsetX,dragOffsetY;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 782, 430);
        scene.getStylesheets().add("style.css");
        stage.setTitle("JavaFX Application");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dragOffsetX = event.getScreenX() - stage.getX();
                dragOffsetY = event.getScreenY() - stage.getY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - dragOffsetX);
                stage.setY(event.getScreenY() - dragOffsetY);
            }
        });
    }
    public static void main(String[] args) {
        launch();
    }
}