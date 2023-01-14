package at.ac.fhcampuswien.gamelibrary.tetris;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class TetrisMain extends Application {
    Scene scene;
    FXMLLoader loader;
    Parent root;
    TetrisGame controller;

    @Override
    public void start(Stage stage) throws IOException {

        loader = new FXMLLoader(getClass().getResource("TetrisView.fxml"));
        root = loader.load();
        scene = new Scene(root);
        controller = loader.getController();
        controller.createGrid();


        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.setTitle("T E T R I S");
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

    }
    public static void main(String[] args) {
        launch();
    }
}