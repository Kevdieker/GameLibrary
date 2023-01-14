package at.ac.fhcampuswien.gamelibrary.ropasc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NormalAI {
    private Stage stage;
    private Scene scene;

    private static final String Rock = "rock";
    private static final String Paper = "paper";
    private static final String Scissors = "scissors";

    @FXML
    private ImageView AI;
    @FXML
    private Label AIScore;
    @FXML
    private Button PaperBtn;
    @FXML
    private ImageView player;
    @FXML
    private Label PlayerScore;
    @FXML
    private Button RockBtn;
    @FXML
    private Button ScissorsBtn;
    @FXML
    private Label result;
    private Image image;

    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void playerTurn(ActionEvent event) {
        String playerChoice = null;
        switch (((Button) event.getSource()).getId()) {
            case "PaperBtn":
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                playerChoice = Paper;
                break;
            case "RockBtn":
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                playerChoice = Rock;
                break;
            case "ScissorsBtn":
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                playerChoice = Scissors;
                break;
        }
        player.setImage(image);
        winner(playerChoice, AITurn());
    }

    private String AITurn() {
        String computerChoice = null;
        int r = (int) (Math.random() * 3);
        switch (r) {
            case 0:
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                computerChoice = Paper;
                break;
            case 1:
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                computerChoice = Rock;
                break;
            case 2:
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                computerChoice = Scissors;
                break;
        }
        AI.setImage(image);
        return computerChoice;
    }

    public void playerWin() {
        result.setText("You Win");
        PlayerScore.setText(String.valueOf(Integer.parseInt(PlayerScore.getText()) + 1));
    }

    public void computerWin() {
        result.setText("You Lost");
        AIScore.setText(String.valueOf(Integer.parseInt(AIScore.getText()) + 1));
    }

    public void draw() {
        result.setText("It's a tie");
    }

    private void winner(String playerChoice, String computerChoice) {

        if (playerChoice.equals(computerChoice)) {
            draw();
        }
        if (playerChoice.equals(Paper)) {
            if (computerChoice.equals(Rock)) {
                computerWin();
            } else if (computerChoice.equals(Scissors)) {
                playerWin();
            }
        } else if (playerChoice.equals(Rock)) {
            if (computerChoice.equals(Paper)) {
                computerWin();
            } else if (computerChoice.equals(Scissors)) {
                playerWin();
            }
        } else if (playerChoice.equals(Scissors)) {
            if (computerChoice.equals(Rock)) {
                computerWin();
            } else if (computerChoice.equals(Paper)) {
                playerWin();
            }
        }
    }

}

