package at.ac.fhcampuswien.gamelibrary.pong;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/*****************************************************************************
 * Class used as an entryPoint for the Pong application.
 * Its sole purpose is to only Start the game without going through the menu.
 * @author Kevin D. Kerbl
 *****************************************************************************/
public class PongMain extends Application {

    /*******************************************************************************************************************
     * EntryPoint for the Pong application
     * @param stage the primary stage for this application, onto which the pong scene can be set.
     * @throws IOException if we can't read the fxml file.
     ******************************************************************************************************************/

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PongMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

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