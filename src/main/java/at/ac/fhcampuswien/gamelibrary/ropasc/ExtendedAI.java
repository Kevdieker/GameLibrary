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
 * Class for Extended-AI-Mode if chosen in Rock,Paper,Scissors-Menu
 * @author Fatima Hossain
 *****************************************************************************/
public class ExtendedAI {
    private Stage stage;
    private Scene scene;
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";
    private static final String SPOCK = "spock";
    private static final String LIZARD = "lizard";
    private static final String FIRE = "fire";
    private static final String AIR = "air";
    private static final String WATER = "water";
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
     * switches to Rock,Paper,Scissors-Menu when clicked
     *****************************************************************************/
    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*****************************************************************************
     * identifies player's buttons and shows image
     * winner-method is implemented
     *****************************************************************************/
    @FXML
    private void playerTurn(ActionEvent event) {
        String playerChoice = null;
        switch (((Button) event.getSource()).getId()) {
            case "paperBtn":
                playerChoice = PAPER;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case "rockBtn":
                playerChoice = ROCK;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case "scissorsBtn":
                playerChoice = SCISSORS;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                break;
            case "spockBtn":
                playerChoice = SPOCK;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/spock.png");
                break;
            case "lizardBtn":
                playerChoice = LIZARD;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/lizard.png");
                break;
            case "fireBtn":
                playerChoice = FIRE;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/fire.png");
                break;
            case "airBtn":
                playerChoice = AIR;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/air.png");
                break;
            case "waterBtn":
                playerChoice = WATER;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/water.png");
                break;
        }
        player.setImage(image);
        winner(playerChoice, AITurn());
    }

    /*****************************************************************************
     * chooses random choices, identifies it and shows image
     *****************************************************************************/
    private String AITurn() {
        String aiChoice = null;
        int r = (int) (Math.random() * 8);
        switch (r) {
            case 0:
                aiChoice = PAPER;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case 1:
                aiChoice = ROCK;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case 2:
                aiChoice = SCISSORS;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                break;
            case 3:
                aiChoice = SPOCK;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/spock.png");
                break;
            case 4:
                aiChoice = LIZARD;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/lizard.png");
                break;
            case 5:
                aiChoice = FIRE;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/fire.png");
                break;
            case 6:
                aiChoice = AIR;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/air.png");
                break;
            case 7:
                aiChoice = WATER;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/water.png");
                break;
        }
        ai.setImage(image);
        return aiChoice;
    }

    /*****************************************************************************
     * result is set to "You Win" if player wins
     * playerScore is risen to +1 point
     *****************************************************************************/
    public void playerWin() {
        result.setText("You Win");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) + 1));
    }

    /*****************************************************************************
     * result is set to "You Lost" if AI wins
     * aiScore is risen to +1 point
     *****************************************************************************/
    public void aiWin() {
        result.setText("You Lost");
        aiScore.setText(String.valueOf(Integer.parseInt(aiScore.getText()) + 1));
    }

    /*****************************************************************************
     * if player and AI have same choice then result is set to "It's a tie"
     * score of AI and player stays the same
     *****************************************************************************/
    public void draw() {
        result.setText("It's a tie");
    }

    /*****************************************************************************
     * goes through every possibility between playerChoice and aiChoice
     * if player wins, then playerWin()-method is used
     * if AI wins, then aiWin()-method is used
     * if neither of them wins, then draw()-method is used
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
            } else if (aiChoice.equals(SPOCK)) {
                playerWin();
            } else if (aiChoice.equals(LIZARD)) {
                aiWin();
            } else if (aiChoice.equals(FIRE)) {
                aiWin();
            } else if (aiChoice.equals(AIR)) {
                playerWin();
            } else if (aiChoice.equals(WATER)) {
                playerWin();
            }
        } else if (playerChoice.equals(ROCK)) {
            if (aiChoice.equals(PAPER)) {
                aiWin();
            } else if (aiChoice.equals(SCISSORS)) {
                playerWin();
            } else if (aiChoice.equals(SPOCK)) {
                aiWin();
            } else if (aiChoice.equals(LIZARD)) {
                playerWin();
            } else if (aiChoice.equals(FIRE)) {
                playerWin();
            } else if (aiChoice.equals(AIR)) {
                aiWin();
            } else if (aiChoice.equals(WATER)) {
                aiWin();
            }
        } else if (playerChoice.equals(SCISSORS)) {
            if (aiChoice.equals(ROCK)) {
                aiWin();
            } else if (aiChoice.equals(PAPER)) {
                playerWin();
            } else if (aiChoice.equals(SPOCK)) {
                aiWin();
            } else if (aiChoice.equals(LIZARD)) {
                playerWin();
            } else if (aiChoice.equals(FIRE)) {
                playerWin();
            } else if (aiChoice.equals(AIR)) {
                playerWin();
            } else if (aiChoice.equals(WATER)) {
                playerWin();
            }
        } else if (playerChoice.equals(SPOCK)) {
            if (aiChoice.equals(ROCK)) {
                playerWin();
            } else if (aiChoice.equals(PAPER)) {
                playerWin();
            } else if (aiChoice.equals(SCISSORS)) {
                aiWin();
            } else if (aiChoice.equals(LIZARD)) {
                aiWin();
            } else if (aiChoice.equals(FIRE)) {
                aiWin();
            } else if (aiChoice.equals(AIR)) {
                playerWin();
            } else if (aiChoice.equals(WATER)) {
                aiWin();
            }
        } else if (playerChoice.equals(LIZARD)) {
            if (aiChoice.equals(ROCK)) {
                playerWin();
            } else if (aiChoice.equals(PAPER)) {
                playerWin();
            } else if (aiChoice.equals(SCISSORS)) {
                aiWin();
            } else if (aiChoice.equals(SPOCK)) {
                aiWin();
            } else if (aiChoice.equals(FIRE)) {
                aiWin();
            } else if (aiChoice.equals(AIR)) {
                playerWin();
            } else if (aiChoice.equals(WATER)) {
                aiWin();
            }
        } else if (playerChoice.equals(FIRE)) {
            if (aiChoice.equals(ROCK)) {
                aiWin();
            } else if (aiChoice.equals(PAPER)) {
                playerWin();
            } else if (aiChoice.equals(SCISSORS)) {
                playerWin();
            } else if (aiChoice.equals(SPOCK)) {
                playerWin();
            } else if (aiChoice.equals(LIZARD)) {
                playerWin();
            } else if (aiChoice.equals(AIR)) {
                aiWin();
            } else if (aiChoice.equals(WATER)) {
                aiWin();
            }
        } else if (playerChoice.equals(AIR)) {
            if (aiChoice.equals(ROCK)) {
                playerWin();
            } else if (aiChoice.equals(PAPER)) {
                aiWin();
            } else if (aiChoice.equals(SCISSORS)) {
                aiWin();
            } else if (aiChoice.equals(SPOCK)) {
                aiWin();
            } else if (aiChoice.equals(LIZARD)) {
                playerWin();
            } else if (aiChoice.equals(FIRE)) {
                playerWin();
            } else if (aiChoice.equals(WATER)) {
                playerWin();
            }
        } else if (playerChoice.equals(WATER)) {
            if (aiChoice.equals(ROCK)) {
                playerWin();
            } else if (aiChoice.equals(PAPER)) {
                aiWin();
            } else if (aiChoice.equals(SCISSORS)) {
                aiWin();
            } else if (aiChoice.equals(SPOCK)) {
                playerWin();
            } else if (aiChoice.equals(LIZARD)) {
                aiWin();
            } else if (aiChoice.equals(FIRE)) {
                playerWin();
            } else if (aiChoice.equals(AIR)) {
                aiWin();
            }
        }
    }
}
