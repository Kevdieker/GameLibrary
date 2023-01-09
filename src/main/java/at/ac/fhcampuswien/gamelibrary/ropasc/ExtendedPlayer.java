package at.ac.fhcampuswien.gamelibrary.ropasc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ExtendedPlayer {

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
    private Label player1;
    @FXML
    private Label player1Score;
    @FXML
    private Label player2;
    @FXML
    private Label player2Score;
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
    private String player1Choice;
    private String player2Choice;

    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*@FXML
    public void initialize() {
        result.setText("It's Player 1's turn");
        scissorBtn2.setDisable(true);
        rockBtn2.setDisable(true);
        paperBtn2.setDisable(true);
    }
    */
    @FXML
    private void player1Turn(ActionEvent event) {
        switch(((Button)event.getSource()).getId()){
            case "paperBtn":
                player1Choice = Paper;
                player1.setText("Paper");
                break;
            case "rockBtn":
                player1Choice = Rock;
                player1.setText("Rock");
                break;
            case "scissorsBtn":
                player1Choice = Scissors;
                player1.setText("Scissors");
                break;
            case "spockBtn":
                player1Choice = Spock;
                player1.setText("Spock");
                break;
            case "lizardBtn":
                player1Choice = Lizard;
                player1.setText("Lizard");
                break;
            case "fireBtn":
                player1Choice = Fire;
                player1.setText("Fire");
                break;
            case "airBtn":
                player1Choice = Air;
                player1.setText("Air");
                break;
            case "waterBtn":
                player1Choice = Water;
                player1.setText("Water");
                break;
        }
        scoreplayer1();
    }

    @FXML
    private void player2Turn(ActionEvent event) {
        switch(((Button)event.getSource()).getId()){
            case "paperBtn":
                player2Choice = Paper;
                player2.setText("Paper");
                break;
            case "rockBtn":
                player2Choice = Rock;
                player2.setText("Rock");
                break;
            case "scissorsBtn":
                player2Choice = Scissors;
                player2.setText("Scissors");
                break;
            case "spockBtn":
                player2Choice = Spock;
                player2.setText("Spock");
                break;
            case "lizardBtn":
                player2Choice = Lizard;
                player2.setText("Lizard");
                break;
            case "fireBtn":
                player2Choice = Fire;
                player2.setText("Fire");
                break;
            case "airBtn":
                player2Choice = Air;
                player2.setText("Air");
                break;
            case "waterBtn":
                player2Choice = Water;
                player2.setText("Water");
                break;
        }
        scoreplayer2();
    }
    private void scoreplayer1 () {
        if (player1Choice.equals(player2Choice)) {
            result.setText("It's a tie");
        }
        if (player1Choice.equals(Paper)) {
            if (player2Choice.equals(Rock)) {
                result.setText("Player 1 wins");
                player1Score.setText(String.valueOf(Integer.parseInt(player1Score.getText()) +1));
            } else if (player2Choice.equals(Scissors)) {
                result.setText("Player 2 wins");
                player2Score.setText(String.valueOf(Integer.parseInt(player2Score.getText()) +1));
            }
        } else if (player1Choice.equals(Rock)) {
            if (player2Choice.equals(Paper)) {
                result.setText("Player 2 wins");
                player2Score.setText(String.valueOf(Integer.parseInt(player2Score.getText()) +1));
            } else if (player2Choice.equals(Scissors)) {
                result.setText("Player 1 wins");
                player1Score.setText(String.valueOf(Integer.parseInt(player1Score.getText()) +1));
            }
        } else if (player1Choice.equals(Scissors)) {
            if (player2Choice.equals(Rock)) {
                result.setText("Player 2 wins");
                player2Score.setText(String.valueOf(Integer.parseInt(player2Score.getText()) +1));
            } else if (player2Choice.equals(Paper)) {
                result.setText("Player 1 wins");
                player1Score.setText(String.valueOf(Integer.parseInt(player1Score.getText()) +1));
            }
        }
    }

    private void scoreplayer2() {
        if (player2Choice.equals(player1Choice)) {
            result.setText("It's a tie");
        }
        if (player2Choice.equals(Paper)) {
            if (player1Choice.equals(Rock)) {
                result.setText("Player 2 wins");
                player2Score.setText(String.valueOf(Integer.parseInt(player2Score.getText()) +1));
            } else if (player1Choice.equals(Scissors)) {
                result.setText("Player 1 wins");
                player1Score.setText(String.valueOf(Integer.parseInt(player1Score.getText()) +1));
            }
        } else if (player2Choice.equals(Rock)) {
            if (player1Choice.equals(Paper)) {
                result.setText("Player 1 wins");
                player1Score.setText(String.valueOf(Integer.parseInt(player1Score.getText()) +1));
            } else if (player1Choice.equals(Scissors)) {
                result.setText("Player 2 wins");
                player2Score.setText(String.valueOf(Integer.parseInt(player2Score.getText()) +1));
            }
        } else if (player2Choice.equals(Scissors)) {
            if (player1Choice.equals(Rock)) {
                result.setText("Player 1 wins");
                player1Score.setText(String.valueOf(Integer.parseInt(player1Score.getText()) +1));
            } else if (player1Choice.equals(Paper)) {
                result.setText("Player 2 wins");
                player2Score.setText(String.valueOf(Integer.parseInt(player2Score.getText()) +1));
            }
        }
    }
}
