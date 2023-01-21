package at.ac.fhcampuswien.gamelibrary.ropasc;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/*****************************************************************************
 * Class for Extended-Explanation if chosen in Rock,Paper,Scissors-Menu
 * @author Fatima Hossain
 *****************************************************************************/
public class ExtendedExplainer {

    private Stage stage;
    private Scene scene;

    /*****************************************************************************
     * switches to Rock,Paper,Scissors-Menu if Back-Button is clicked
     *****************************************************************************/
    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
