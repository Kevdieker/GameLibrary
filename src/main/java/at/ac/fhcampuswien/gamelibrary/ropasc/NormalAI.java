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

/*****************************************************************************
 * Class for Normal-AI-Mode if chosen in Rock,Paper,Scissors-Menu
 * @author Fatima Hossain
 *****************************************************************************/
public class NormalAI {
    private Stage stage;
    private Scene scene;

    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";

    @FXML
    private ImageView ai;
    @FXML
    private Label aiScore;
    @FXML
    private ImageView player;
    @FXML
    private Label playerScore;
    @FXML
    private Label result;
    private Image image;

    /*****************************************************************************
     * switch to Rock,Paper,Scissors-Menu if Back-Button is clicked
     *****************************************************************************/
    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*****************************************************************************
     * identifies player's buttons and sets correct image
     * winner()-method is implemented
     *****************************************************************************/
    @FXML
    private void playerTurn(ActionEvent event) {
        String playerChoice = null;
        switch (((Button) event.getSource()).getId()) {
            case "PaperBtn":
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                playerChoice = PAPER;
                break;
            case "RockBtn":
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                playerChoice = ROCK;
                break;
            case "ScissorsBtn":
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                playerChoice = SCISSORS;
                break;
        }
        player.setImage(image);
        winner(playerChoice, AITurn());
    }

    /*****************************************************************************
     * Math.random chooses one of three options and sets correct image
     *****************************************************************************/
    private String AITurn() {
        String aiChoice = null;
        int r = (int) (Math.random() * 3);
        switch (r) {
            case 0:
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                aiChoice = PAPER;
                break;
            case 1:
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                aiChoice = ROCK;
                break;
            case 2:
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                aiChoice = SCISSORS;
                break;
        }
        ai.setImage(image);
        return aiChoice;
    }

    /*****************************************************************************
     * result set to "You Win" if player wins
     * playerScore is risen to +1 point
     *****************************************************************************/
    public void playerWin() {
        result.setText("You Win");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) + 1));
    }

    /*****************************************************************************
     * result set to "You Lost" if player loses against AI
     * aiScore is risen to +1 point
     *****************************************************************************/
    public void aiWin() {
        result.setText("You Lost");
        aiScore.setText(String.valueOf(Integer.parseInt(aiScore.getText()) + 1));
    }

    /*****************************************************************************
     * if player and AI chose same option, then result is set to "It's a tie"
     * playerScore and AIScore stays the same
     *****************************************************************************/
    public void draw() {
        result.setText("It's a tie");
    }

    /*****************************************************************************
     * goes through every possibitly between playerChoice and aiChoice
     * if player and AI chooses same option, then draw()-method is used
     * if player wins, then playerWin()-method is used
     * if AI wins, then aiWin()-method is used
     *****************************************************************************/
    private void winner(String playerChoice, String aiChoice) {
        if (playerChoice.equals(aiChoice)) {
            draw();
        }
        if (playerChoice.equals(PAPER)) {
            if (aiChoice.equals(ROCK)) {
                aiWin();
            } else if (aiChoice.equals(SCISSORS)) {
                playerWin();
            }
        } else if (playerChoice.equals(ROCK)) {
            if (aiChoice.equals(PAPER)) {
                aiWin();
            } else if (aiChoice.equals(SCISSORS)) {
                playerWin();
            }
        } else if (playerChoice.equals(SCISSORS)) {
            if (aiChoice.equals(ROCK)) {
                aiWin();
            } else if (aiChoice.equals(PAPER)) {
                playerWin();
            }
        }
    }

}

