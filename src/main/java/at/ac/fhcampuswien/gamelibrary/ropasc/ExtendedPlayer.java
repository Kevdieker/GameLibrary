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

public class ExtendedPlayer {

    private Stage stage;
    private Scene scene;
    @FXML
    private Button air1Btn;
    @FXML
    private Button air2Btn;
    @FXML
    private Button fire1Btn;
    @FXML
    private Button fire2Btn;
    @FXML
    private Button lizard1Btn;
    @FXML
    private Button lizard2Btn;
    @FXML
    private Button paper1Btn;
    @FXML
    private Button paper2Btn;
    @FXML
    private ImageView player1;
    @FXML
    private ImageView player2;
    @FXML
    private Label result;
    @FXML
    private Button rock1Btn;
    @FXML
    private Button rock2Btn;
    @FXML
    private Button scissor1Btn;
    @FXML
    private Button scissor2Btn;
    @FXML
    private Button spock1Btn;
    @FXML
    private Button spock2Btn;
    @FXML
    private Button water1Btn;
    @FXML
    private Button water2Btn;
    @FXML
    private Label player1Score;
    @FXML
    private Label player2Score;
    private static final String Rock = "rock";
    private static final String Paper = "paper";
    private static final String Scissors = "scissors";
    private static final String Spock = "spock";
    private static final String Lizard = "lizard";
    private static final String Fire = "fire";
    private static final String Air = "air";
    private static final String Water = "water";
    private String player1Choice;
    private String player2Choice;
    private Image image;

    @FXML
    Rectangle tool;

    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void player1Turn(ActionEvent event) {
        tool.setVisible(true);
        switch (((Button) event.getSource()).getId()) {
            case "paper1Btn":
                player1Choice = Paper;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case "rock1Btn":
                player1Choice = Rock;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case "scissor1Btn":
                player1Choice = Scissors;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                break;
            case "spock1Btn":
                player1Choice = Spock;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/spock.png");
                break;
            case "lizard1Btn":
                player1Choice = Lizard;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/lizard.png");
                break;
            case "fire1Btn":
                player1Choice = Fire;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/fire.png");
                break;
            case "air1Btn":
                player1Choice = Air;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/air.png");
                break;
            case "water1Btn":
                player1Choice = Water;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/water.png");
                break;
        }
        player1.setImage(image);
        checkIfWon();
    }

    @FXML
    private void player2Turn(ActionEvent ev) {
        tool.setVisible(false);
        switch (((Button) ev.getSource()).getId()) {
            case "paper2Btn":
                player2Choice = Paper;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case "rock2Btn":
                player2Choice = Rock;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case "scissor2Btn":
                player2Choice = Scissors;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                break;
            case "spock2Btn":
                player2Choice = Spock;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/spock.png");
                break;
            case "lizard2Btn":
                player2Choice = Lizard;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/lizard.png");
                break;
            case "fire2Btn":
                player2Choice = Fire;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/fire.png");
                break;
            case "air2Btn":
                player2Choice = Air;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/air.png");
                break;
            case "water2Btn":
                player2Choice = Water;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/water.png");
                break;
        }
        player2.setImage(image);
        checkIfWon();
    }

    public void player1Win() {
        result.setText("Player 1 wins!");
        player1Score.setText(String.valueOf(Integer.parseInt(player1Score.getText()) + 1));
        player2Choice.equals("0");
    }

    public void player2Win() {
        result.setText("Player 2 wins!");
        player2Score.setText(String.valueOf(Integer.parseInt(player2Score.getText()) + 1));
        player1Choice.equals("0");
    }

    private void checkIfWon() {
        if (player1Choice.equals(player2Choice)) {
            result.setText("It's a tie");
        }
        if (player1Choice.equals(Paper)) {
            if (player2Choice.equals(Rock)) {
                player1Win();
            } else if (player2Choice.equals(Scissors)) {
                player2Win();
            } else if (player2Choice.equals(Spock)) {
                player1Win();
            } else if (player2Choice.equals(Lizard)) {
                player2Win();
            } else if (player2Choice.equals(Fire)) {
                player2Win();
            } else if (player2Choice.equals(Air)) {
                player1Win();
            } else if (player2Choice.equals(Water)) {
                player1Win();
            }
        } else if (player1Choice.equals(Rock)) {
            if (player2Choice.equals(Paper)) {
                player2Win();
            } else if (player2Choice.equals(Scissors)) {
                player1Win();
            } else if (player2Choice.equals(Spock)) {
                player2Win();
            } else if (player2Choice.equals(Lizard)) {
                player1Win();
            } else if (player2Choice.equals(Fire)) {
                player1Win();
            } else if (player2Choice.equals(Air)) {
                player2Win();
            } else if (player2Choice.equals(Water)) {
                player2Win();
            }
        } else if (player1Choice.equals(Scissors)) {
            if (player2Choice.equals(Rock)) {
                player2Win();
            } else if (player2Choice.equals(Paper)) {
                player1Win();
            } else if (player2Choice.equals(Spock)) {
                player2Win();
            } else if (player2Choice.equals(Lizard)) {
                player1Win();
            } else if (player2Choice.equals(Fire)) {
                player2Win();
            } else if (player2Choice.equals(Air)) {
                player1Win();
            } else if (player2Choice.equals(Water)) {
                player1Win();
            }
        } else if (player1Choice.equals(Spock)) {
            if (player2Choice.equals(Rock)) {
                player1Win();
            } else if (player2Choice.equals(Paper)) {
                player2Win();
            } else if (player2Choice.equals(Scissors)) {
                player1Win();
            } else if (player2Choice.equals(Lizard)) {
                player2Win();
            } else if (player2Choice.equals(Fire)) {
                player2Win();
            } else if (player2Choice.equals(Air)) {
                player1Win();
            } else if (player2Choice.equals(Water)) {
                player2Win();
            }
        } else if (player1Choice.equals(Lizard)) {
            if (player2Choice.equals(Rock)) {
                player2Win();
            } else if (player2Choice.equals(Paper)) {
                player1Win();
            } else if (player2Choice.equals(Scissors)) {
                player2Win();
            } else if (player2Choice.equals(Spock)) {
                player1Win();
            } else if (player2Choice.equals(Fire)) {
                player2Win();
            } else if (player2Choice.equals(Air)) {
                player2Win();
            } else if (player2Choice.equals(Water)) {
                player1Win();
            }
        } else if (player1Choice.equals(Fire)) {
            if (player2Choice.equals(Rock)) {
                player2Win();
            } else if (player2Choice.equals(Paper)) {
                player1Win();
            } else if (player2Choice.equals(Scissors)) {
                player1Win();
            } else if (player2Choice.equals(Spock)) {
                player1Win();
            } else if (player2Choice.equals(Lizard)) {
                player1Win();
            } else if (player2Choice.equals(Air)) {
                player2Win();
            } else if (player2Choice.equals(Water)) {
                player2Win();
            }
        } else if (player1Choice.equals(Air)) {
            if (player2Choice.equals(Rock)) {
                player1Win();
            } else if (player2Choice.equals(Paper)) {
                player2Win();
            } else if (player2Choice.equals(Scissors)) {
                player2Win();
            } else if (player2Choice.equals(Spock)) {
                player2Win();
            } else if (player2Choice.equals(Lizard)) {
                player2Win();
            } else if (player2Choice.equals(Fire)) {
                player1Win();
            } else if (player2Choice.equals(Water)) {
                player1Win();
            }
        } else if (player1Choice.equals(Water)) {
            if (player2Choice.equals(Rock)) {
                player1Win();
            } else if (player2Choice.equals(Paper)) {
                player2Win();
            } else if (player2Choice.equals(Scissors)) {
                player2Win();
            } else if (player2Choice.equals(Spock)) {
                player1Win();
            } else if (player2Choice.equals(Lizard)) {
                player2Win();
            } else if (player2Choice.equals(Fire)) {
                player1Win();
            } else if (player2Choice.equals(Air)) {
                player2Win();
            }
        }
    }
}



