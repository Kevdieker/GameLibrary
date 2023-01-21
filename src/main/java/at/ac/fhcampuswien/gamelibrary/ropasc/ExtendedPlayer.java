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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/*****************************************************************************
 * Class for Extended-Player-Mode if chosen in Rock,Paper,Scissors-Menu
 * @author Fatima Hossain
 *****************************************************************************/
public class ExtendedPlayer {

    private Stage stage;
    private Scene scene;
    @FXML
    private ImageView player1;
    @FXML
    private ImageView player2;
    @FXML
    private Label result;
    @FXML
    private Label player1Score;
    @FXML
    private Label player2Score;
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";
    private static final String SPOCK = "spock";
    private static final String LIZARD = "lizard";
    private static final String FIRE = "fire";
    private static final String AIR = "air";
    private static final String WATER = "water";
    private String player1Choice;
    private String player2Choice;
    private Image image;
    @FXML
    Rectangle tool;

    /*****************************************************************************
     * switches to Menu-Window if Back-Button is clicked
     *****************************************************************************/
    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*****************************************************************************
     * identifies player1's buttons and sets player1's image
     * winner()-method is implemented
     *****************************************************************************/
    @FXML
    private void player1Turn(ActionEvent event) {
        tool.setVisible(true);
        switch (((Button) event.getSource()).getId()) {
            case "paper1Btn":
                player1Choice = PAPER;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case "rock1Btn":
                player1Choice = ROCK;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case "scissor1Btn":
                player1Choice = SCISSORS;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                break;
            case "spock1Btn":
                player1Choice = SPOCK;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/spock.png");
                break;
            case "lizard1Btn":
                player1Choice = LIZARD;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/lizard.png");
                break;
            case "fire1Btn":
                player1Choice = FIRE;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/fire.png");
                break;
            case "air1Btn":
                player1Choice = AIR;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/air.png");
                break;
            case "water1Btn":
                player1Choice = WATER;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/water.png");
                break;
        }
        player1.setImage(image);
        winner();
    }

    /*****************************************************************************
     * identifies player2's buttons and sets player2's image
     * winner()-method is implemented
     *****************************************************************************/
    @FXML
    private void player2Turn(ActionEvent ev) {
        tool.setVisible(false);
        switch (((Button) ev.getSource()).getId()) {
            case "paper2Btn":
                player2Choice = PAPER;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case "rock2Btn":
                player2Choice = ROCK;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case "scissor2Btn":
                player2Choice = SCISSORS;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                break;
            case "spock2Btn":
                player2Choice = SPOCK;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/spock.png");
                break;
            case "lizard2Btn":
                player2Choice = LIZARD;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/lizard.png");
                break;
            case "fire2Btn":
                player2Choice = FIRE;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/fire.png");
                break;
            case "air2Btn":
                player2Choice = AIR;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/air.png");
                break;
            case "water2Btn":
                player2Choice = WATER;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/water.png");
                break;
        }
        player2.setImage(image);
        winner();
    }

    /*****************************************************************************
     * sets result to "Player 1 wins!" if player 1 wins
     * sets player1Score to +1 if tool is not visible
     * sets player2Score to +0 if tool is visible
     *****************************************************************************/
    public void player1Win() {
        result.setText("Player 1 wins!");
        if(!tool.isVisible()){
            player1Score.setText(String.valueOf(Integer.parseInt(player1Score.getText()) + 1));
        }else{
            player2Score.setText(String.valueOf(Integer.parseInt(player2Score.getText())));
        }
    }

    /*****************************************************************************
     * sets result to "Player 2 wins!" if player 2 wins
     * sets player2Score to +1 if tool is not visible
     * sets player1Score to +0 if tool is visible
     *****************************************************************************/
    public void player2Win() {
        result.setText("Player 2 wins!");
        if(!tool.isVisible()){
            player2Score.setText(String.valueOf(Integer.parseInt(player2Score.getText()) + 1));
        }else{
            player1Score.setText(String.valueOf(Integer.parseInt(player1Score.getText())));
        }
    }

    /*****************************************************************************
     * goes through every possibility between player1Choice and player2Choice
     * if player1 and player2 have chosen the same option then result set to "It's a tie"
     * if player1 wins, then player1Win()-method is used
     * if player2 wins, then player2Win()-method is used
     *****************************************************************************/
    private void winner() {
        if (player1Choice.equals(player2Choice)) {
            result.setText("It's a tie");
        }
        if (player1Choice.equals(PAPER)) {
            if (player2Choice.equals(ROCK)) {
                player1Win();
            } else if (player2Choice.equals(SCISSORS)) {
                player2Win();
            } else if (player2Choice.equals(SPOCK)) {
                player1Win();
            } else if (player2Choice.equals(LIZARD)) {
                player2Win();
            } else if (player2Choice.equals(FIRE)) {
                player2Win();
            } else if (player2Choice.equals(AIR)) {
                player1Win();
            } else if (player2Choice.equals(WATER)) {
                player1Win();
            }
        } else if (player1Choice.equals(ROCK)) {
            if (player2Choice.equals(PAPER)) {
                player2Win();
            } else if (player2Choice.equals(SCISSORS)) {
                player1Win();
            } else if (player2Choice.equals(SPOCK)) {
                player2Win();
            } else if (player2Choice.equals(LIZARD)) {
                player1Win();
            } else if (player2Choice.equals(FIRE)) {
                player1Win();
            } else if (player2Choice.equals(AIR)) {
                player2Win();
            } else if (player2Choice.equals(WATER)) {
                player2Win();
            }
        } else if (player1Choice.equals(SCISSORS)) {
            if (player2Choice.equals(ROCK)) {
                player2Win();
            } else if (player2Choice.equals(PAPER)) {
                player1Win();
            } else if (player2Choice.equals(SPOCK)) {
                player2Win();
            } else if (player2Choice.equals(LIZARD)) {
                player1Win();
            } else if (player2Choice.equals(FIRE)) {
                player2Win();
            } else if (player2Choice.equals(AIR)) {
                player1Win();
            } else if (player2Choice.equals(WATER)) {
                player1Win();
            }
        } else if (player1Choice.equals(SPOCK)) {
            if (player2Choice.equals(ROCK)) {
                player1Win();
            } else if (player2Choice.equals(PAPER)) {
                player2Win();
            } else if (player2Choice.equals(SCISSORS)) {
                player1Win();
            } else if (player2Choice.equals(LIZARD)) {
                player2Win();
            } else if (player2Choice.equals(FIRE)) {
                player2Win();
            } else if (player2Choice.equals(AIR)) {
                player1Win();
            } else if (player2Choice.equals(WATER)) {
                player2Win();
            }
        } else if (player1Choice.equals(LIZARD)) {
            if (player2Choice.equals(ROCK)) {
                player2Win();
            } else if (player2Choice.equals(PAPER)) {
                player1Win();
            } else if (player2Choice.equals(SCISSORS)) {
                player2Win();
            } else if (player2Choice.equals(SPOCK)) {
                player1Win();
            } else if (player2Choice.equals(FIRE)) {
                player2Win();
            } else if (player2Choice.equals(AIR)) {
                player2Win();
            } else if (player2Choice.equals(WATER)) {
                player1Win();
            }
        } else if (player1Choice.equals(FIRE)) {
            if (player2Choice.equals(ROCK)) {
                player2Win();
            } else if (player2Choice.equals(PAPER)) {
                player1Win();
            } else if (player2Choice.equals(SCISSORS)) {
                player1Win();
            } else if (player2Choice.equals(SPOCK)) {
                player1Win();
            } else if (player2Choice.equals(LIZARD)) {
                player1Win();
            } else if (player2Choice.equals(AIR)) {
                player2Win();
            } else if (player2Choice.equals(WATER)) {
                player2Win();
            }
        } else if (player1Choice.equals(AIR)) {
            if (player2Choice.equals(ROCK)) {
                player1Win();
            } else if (player2Choice.equals(PAPER)) {
                player2Win();
            } else if (player2Choice.equals(SCISSORS)) {
                player2Win();
            } else if (player2Choice.equals(SPOCK)) {
                player2Win();
            } else if (player2Choice.equals(LIZARD)) {
                player2Win();
            } else if (player2Choice.equals(FIRE)) {
                player1Win();
            } else if (player2Choice.equals(WATER)) {
                player1Win();
            }
        } else if (player1Choice.equals(WATER)) {
            if (player2Choice.equals(ROCK)) {
                player1Win();
            } else if (player2Choice.equals(PAPER)) {
                player2Win();
            } else if (player2Choice.equals(SCISSORS)) {
                player2Win();
            } else if (player2Choice.equals(SPOCK)) {
                player1Win();
            } else if (player2Choice.equals(LIZARD)) {
                player2Win();
            } else if (player2Choice.equals(FIRE)) {
                player1Win();
            } else if (player2Choice.equals(AIR)) {
                player2Win();
            }
        }
    }
}



