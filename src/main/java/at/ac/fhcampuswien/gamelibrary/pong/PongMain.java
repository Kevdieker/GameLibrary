package at.ac.fhcampuswien.gamelibrary.pong;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PongMain extends Application {
    Scene scene;
    FXMLLoader loader;
    Parent root;
    PongGame controller;

    @Override
    public void start(Stage stage) throws IOException {

        loader = new FXMLLoader(getClass().getResource("PongView.fxml"));
        root = loader.load();
        scene = new Scene(root);
        controller = loader.getController();
        controller.createGrid();

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}