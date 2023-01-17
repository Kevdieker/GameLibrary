package at.ac.fhcampuswien.gamelibrary;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainMenu extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("MainMenu.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setTitle("G A M E L I B R A R Y  \uD83C\uDFAE️\uD83D\uDCDA");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Redflag.jpeg"))));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

