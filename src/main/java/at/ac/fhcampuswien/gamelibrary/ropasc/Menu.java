package at.ac.fhcampuswien.gamelibrary.ropasc;

import at.ac.fhcampuswien.gamelibrary.MainSceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/*****************************************************************************
 * Class for Menu to choose Rock,Paper,Scissors-Mode and to see Explanation
 * @author Fatima Hossain
 *****************************************************************************/
public class Menu {
    private Stage stage;
    private Scene scene;

    /*****************************************************************************
     * switches to Normal-AI-Window if Normal-AI-Button is clicked
     *****************************************************************************/
    public void switchToNormalAI(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NormalAI.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    /*****************************************************************************
     * switches to Normal-Player-Window if Normal-Player-Button is clicked
     *****************************************************************************/
    public void switchToNormalPlayer(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NormalPlayers.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    /*****************************************************************************
     * switches to Extended-AI-Window if Extended-AI-Button is clicked
     *****************************************************************************/
    public void switchToExtededAI(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ExtendedAI.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    /*****************************************************************************
     * switches to Extended-Player-Window if Extended-Player-Button is clicked
     *****************************************************************************/
    public void switchToExtededPlayer(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ExtendedPlayer.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    /*****************************************************************************
     * switches to Normal-Explainer-Window if red circle-Button is clicked
     *****************************************************************************/
    public void openNormalExplainer (ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NormalExplainer.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    /*****************************************************************************
     * switches to Extended-Explainer-Window if red circle-Button is clicked
     *****************************************************************************/
    public void openExtendedExplainer (ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ExtendedExplainer.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMainMenu(ActionEvent e) throws IOException {
        new MainSceneSwitch().switchToMainMenu(e);
    }
}
