package at.ac.fhcampuswien.gamelibrary;

import at.ac.fhcampuswien.gamelibrary.pong.PongGame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneSwitch {
    Scene scene;
    FXMLLoader loader;
    Parent root;
    Parent root1;
    PongGame controller;
    Stage stage;

    public void windowMenu(ActionEvent event) throws IOException {

        try {
            if (!stage.isShowing()) {

                loader = new FXMLLoader(getClass().getResource("MenuMenu.fxml"));
                root1 = loader.load();
                stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.isAlwaysOnTop();
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchToPong(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("pong/PongView.fxml"));
        root = loader.load();
        scene = new Scene(root);
        controller = loader.getController();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        controller.createGrid();

        stage.setResizable(false);
        stage.setX(0);
        stage.setY(0);
        stage.setScene(scene);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setFullScreen(true);
        stage.show();
    }

    public void switchToRoPaSc(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("RoPaScView.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        stage.setResizable(false);
        stage.setX(0);
        stage.setY(0);
        stage.setScene(scene);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setFullScreen(true);
        stage.show();
    }

    public void switchMemory(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("MemoryView.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        stage.setResizable(false);
        stage.setX(0);
        stage.setY(0);
        stage.setScene(scene);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setFullScreen(true);
        stage.show();
    }

    public void exit(){Platform.exit();}
}
