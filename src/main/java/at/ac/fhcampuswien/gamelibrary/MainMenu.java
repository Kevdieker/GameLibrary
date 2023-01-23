package at.ac.fhcampuswien.gamelibrary;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/*****************************************************************
 * Class used as an EntryPoint for the Game Library Application.
 * @author Kevin D. Kerbl
 ****************************************************************/

public class MainMenu extends Application {
    /*************************************************************
     * EntryPoint for the Game Library Application
     * @param stage the primary stage for this application.
     * @throws IOException when we can't read the fxml file.
     ************************************************************/
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

    /*********************************************
     * Our main method. Launches the application.
     * @param args The command line arguments.
     *********************************************/
    public static void main(String[] args) {
        launch();
    }
}

