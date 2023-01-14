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

public class ExtendedAI {
    private Stage stage;
    private Scene scene;

    private static final String Rock = "rock";
    private static final String Paper = "paper";
    private static final String Scissors = "scissors";
    private static final String Spock = "spock";
    private static final String Lizard = "lizard";
    private static final String Fire = "fire";
    private static final String Air = "air";
    private static final String Water = "water";
    @FXML
    private ImageView ai;
    @FXML
    private Label aiScore;
    @FXML
    private Button airBtn;
    @FXML
    private Button fireBtn;
    @FXML
    private Button lizardBtn;
    @FXML
    private Button paperBtn;
    @FXML
    private ImageView player;
    @FXML
    private Label playerScore;
    @FXML
    private Label result;
    @FXML
    private Button rockBtn;
    @FXML
    private Button scissorsBtn;
    @FXML
    private Button spockBtn;
    @FXML
    private Button waterBtn;
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
            case "paperBtn":
                playerChoice = Paper;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case "rockBtn":
                playerChoice = Rock;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case "scissorsBtn":
                playerChoice = Scissors;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                break;
            case "spockBtn":
                playerChoice = Spock;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/spock.png");
                break;
            case "lizardBtn":
                playerChoice = Lizard;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/lizard.png");
                break;
            case "fireBtn":
                playerChoice = Fire;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/fire.png");
                break;
            case "airBtn":
                playerChoice = Air;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/air.png");
                break;
            case "waterBtn":
                playerChoice = Water;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/water.png");
                break;
        }
        player.setImage(image);
        winner(playerChoice, AITurn());
    }

    private String AITurn() {
        String computerChoice = null;
        int r = (int) (Math.random() * 8);
        switch (r) {
            case 0:
                computerChoice = Paper;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case 1:
                computerChoice = Rock;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case 2:
                computerChoice = Scissors;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                break;
            case 3:
                computerChoice = Spock;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/spock.png");
                break;
            case 4:
                computerChoice = Lizard;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/lizard.png");
                break;
            case 5:
                computerChoice = Fire;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/fire.png");
                break;
            case 6:
                computerChoice = Air;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/air.png");
                break;
            case 7:
                computerChoice = Water;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/water.png");
                break;
        }
        ai.setImage(image);
        return computerChoice;
    }

    public void playerWin() {
        result.setText("You Win");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) + 1));
    }

    public void computerWin() {
        result.setText("You Lost");
        aiScore.setText(String.valueOf(Integer.parseInt(aiScore.getText()) + 1));
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
            } else if (computerChoice.equals(Spock)) {
                playerWin();
            } else if (computerChoice.equals(Lizard)) {
                computerWin();
            } else if (computerChoice.equals(Fire)) {
                computerWin();
            } else if (computerChoice.equals(Air)) {
                playerWin();
            } else if (computerChoice.equals(Water)) {
                playerWin();
            }
        } else if (playerChoice.equals(Rock)) {
            if (computerChoice.equals(Paper)) {
                computerWin();
            } else if (computerChoice.equals(Scissors)) {
                playerWin();
            } else if (computerChoice.equals(Spock)) {
                computerWin();
            } else if (computerChoice.equals(Lizard)) {
                playerWin();
            } else if (computerChoice.equals(Fire)) {
                playerWin();
            } else if (computerChoice.equals(Air)) {
                computerWin();
            } else if (computerChoice.equals(Water)) {
                computerWin();
            }
        } else if (playerChoice.equals(Scissors)) {
            if (computerChoice.equals(Rock)) {
                computerWin();
            } else if (computerChoice.equals(Paper)) {
                playerWin();
            } else if (computerChoice.equals(Spock)) {
                computerWin();
            } else if (computerChoice.equals(Lizard)) {
                playerWin();
            } else if (computerChoice.equals(Fire)) {
                playerWin();
            } else if (computerChoice.equals(Air)) {
                playerWin();
            } else if (computerChoice.equals(Water)) {
                playerWin();
            }
        } else if (playerChoice.equals(Spock)) {
            if (computerChoice.equals(Rock)) {
                playerWin();
            } else if (computerChoice.equals(Paper)) {
                playerWin();
            } else if (computerChoice.equals(Scissors)) {
                computerWin();
            } else if (computerChoice.equals(Lizard)) {
                computerWin();
            } else if (computerChoice.equals(Fire)) {
                computerWin();
            } else if (computerChoice.equals(Air)) {
                playerWin();
            } else if (computerChoice.equals(Water)) {
                computerWin();
            }
        } else if (playerChoice.equals(Lizard)) {
            if (computerChoice.equals(Rock)) {
                playerWin();
            } else if (computerChoice.equals(Paper)) {
                playerWin();
            } else if (computerChoice.equals(Scissors)) {
                computerWin();
            } else if (computerChoice.equals(Spock)) {
                computerWin();
            } else if (computerChoice.equals(Fire)) {
                computerWin();
            } else if (computerChoice.equals(Air)) {
                playerWin();
            } else if (computerChoice.equals(Water)) {
                computerWin();
            }
        } else if (playerChoice.equals(Fire)) {
            if (computerChoice.equals(Rock)) {
                computerWin();
            } else if (computerChoice.equals(Paper)) {
                playerWin();
            } else if (computerChoice.equals(Scissors)) {
                playerWin();
            } else if (computerChoice.equals(Spock)) {
                playerWin();
            } else if (computerChoice.equals(Lizard)) {
                playerWin();
            } else if (computerChoice.equals(Air)) {
                computerWin();
            } else if (computerChoice.equals(Water)) {
                computerWin();
            }
        } else if (playerChoice.equals(Air)) {
            if (computerChoice.equals(Rock)) {
                playerWin();
            } else if (computerChoice.equals(Paper)) {
                computerWin();
            } else if (computerChoice.equals(Scissors)) {
                computerWin();
            } else if (computerChoice.equals(Spock)) {
                computerWin();
            } else if (computerChoice.equals(Lizard)) {
                playerWin();
            } else if (computerChoice.equals(Fire)) {
                playerWin();
            } else if (computerChoice.equals(Water)) {
                playerWin();
            }
        } else if (playerChoice.equals(Water)) {
            if (computerChoice.equals(Rock)) {
                playerWin();
            } else if (computerChoice.equals(Paper)) {
                computerWin();
            } else if (computerChoice.equals(Scissors)) {
                computerWin();
            } else if (computerChoice.equals(Spock)) {
                playerWin();
            } else if (computerChoice.equals(Lizard)) {
                computerWin();
            } else if (computerChoice.equals(Fire)) {
                playerWin();
            } else if (computerChoice.equals(Air)) {
                computerWin();
            }
        }
    }
}
