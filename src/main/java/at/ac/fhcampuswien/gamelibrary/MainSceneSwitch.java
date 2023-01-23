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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Objects;
/*****************************************************************************
 * Class used for switching between scenes and to open new windows.
 * @author Kevin D. Kerbl
 *****************************************************************************/
public class MainSceneSwitch {
    private Scene scene;
    private FXMLLoader loader;
    private Parent mainRoot;
    private Stage stage;

/**********************************************************
 * Opens the credits window.
 * @throws IOException if we can't read the fxml file.
 **********************************************************/
    public void creditsWindow() throws IOException {

            loader = new FXMLLoader(getClass().getResource("Credits.fxml"));
            Parent creditsRoot = loader.load();
            stage = new Stage();

            stage.setTitle("G A M E L I B R A R Y   Credits");
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Redflag.jpeg"))));
            stage.setScene(new Scene(creditsRoot));
            stage.isAlwaysOnTop();
            stage.show();

    }
    /**********************************************************
     * Switches scene to the main menu
     * @param e for ActionEvent to switch between scenes.
     * @throws IOException if we can't read the fxml file.
     **********************************************************/
    public void switchToMainMenu(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        mainRoot = loader.load();
        scene = new Scene(mainRoot);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    /**********************************************************
     * Switches scene to pong-menu
     * @param e for ActionEvent to switch between scenes.
     * @throws IOException if we can't read the fxml file.
     **********************************************************/
    public void switchToPongMenu(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("pong/PongMenu.fxml"));
        mainRoot = loader.load();
        scene = new Scene(mainRoot);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        stage.setResizable(false);
        stage.isAlwaysOnTop();
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    /**********************************************************
     * Switches scene to pong game
     * @param e for ActionEvent to switch between scenes.
     * @param twoPlayerMode for modifying Player mode.
     * @param winCon for modifying winning condition.
     * @throws IOException if we can't read the fxml file.
     **********************************************************/
    public void switchToPongGame(ActionEvent e,Boolean twoPlayerMode,int winCon) throws IOException {
        loader = new FXMLLoader(getClass().getResource("pong/PongView.fxml"));
        mainRoot = loader.load();
        scene = new Scene(mainRoot);
        PongGame controller = loader.getController();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        controller.createGrid();
        controller.setTwoPlayerMode(twoPlayerMode);
        controller.setWinCon(winCon);

        stage.setScene(scene);
        stage.show();
    }

    /**********************************************************
     * Switches scene to rock,paper,scissors
     * @param e for ActionEvent to switch between scenes.
     * @throws IOException if we can't read the fxml file.
     **********************************************************/
    public void switchToRoPaSc(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("ropasc/menu.fxml"));
        mainRoot = loader.load();
        scene = new Scene(mainRoot);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    /**********************************************************
     * Switches scene to memory
     * @param e for ActionEvent to switch between scenes.
     * @throws IOException if we can't read the fxml file.
     **********************************************************/
    public void switchToMemory(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("memory/MemoryView.fxml"));
        mainRoot = loader.load();
        scene = new Scene(mainRoot);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    /**********************************************************
     * Switches scene to tetris
     * @param e for ActionEvent to switch between scenes.
     * @throws IOException if we can't read the fxml file.
     **********************************************************/
    public void switchToTetris(ActionEvent e) throws IOException {
        loader = new FXMLLoader(getClass().getResource("tetris/TetrisView.fxml"));
        mainRoot = loader.load();
        scene = new Scene(mainRoot);
        TetrisGame controller = loader.getController();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        controller.createGrid();

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();

        //To stop the tetris from running after pressing the Exit button.
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }
    /**********************************************************
     * Opens window for special person.
     * @throws IOException if we can't read the fxml file.
     **********************************************************/
    public void heartWindow() throws IOException {

        loader = new FXMLLoader(getClass().getResource("pong/Heart.fxml"));
        Parent heartRoot = loader.load();
        Stage stage2 = new Stage();

        stage2.setTitle(" ../.. 12/12 20/01");
        stage2.setResizable(false);
        stage2.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("pong/Heart.PNG"))));
        stage2.setScene(new Scene(heartRoot));
        stage2.show();

    }
    /**********************************************************
     * Opens window for special person.
     * @throws IOException if we can't read the fxml file.
     **********************************************************/
    public void biggerHeartWindow() throws IOException {

        loader = new FXMLLoader(getClass().getResource("pong/OpenHeart.fxml"));
        Parent opHeartRoot = loader.load();
        stage = new Stage();

        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("pong/Heart.PNG"))));
        stage.setScene(new Scene(opHeartRoot));
        stage.isFocused();
        stage.setResizable(false);
        stage.show();
    }
}
