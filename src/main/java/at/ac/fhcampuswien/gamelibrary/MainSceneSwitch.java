package at.ac.fhcampuswien.gamelibrary;

import at.ac.fhcampuswien.gamelibrary.pong.PongGame;
import at.ac.fhcampuswien.gamelibrary.tetris.TetrisGame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class MainSceneSwitch {
    Scene scene;
    FXMLLoader loader;
    Parent root;
    Parent root1;
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

    public void switchToMainMenu(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPong(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("pong/PongView.fxml"));
        root = loader.load();
        scene = new Scene(root);
        PongGame controller = loader.getController();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        controller.createGrid();

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRoPaSc(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("ropasc/menu.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMemory(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("memory/MemoryView.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTetris(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("tetris/TetrisView.fxml"));
        root = loader.load();
        scene = new Scene(root);
        TetrisGame controller = loader.getController();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        controller.createGrid();

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public void exit(){Platform.exit();}
}
