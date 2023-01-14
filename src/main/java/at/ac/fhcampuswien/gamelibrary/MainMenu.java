package at.ac.fhcampuswien.gamelibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenu extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("MainMenu.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

