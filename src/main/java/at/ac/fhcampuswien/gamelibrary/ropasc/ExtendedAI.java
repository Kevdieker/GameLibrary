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

public class ExtendedAI {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private static final String Rock = "rock";
    private static final String Paper = "paper";
    private static final String Scissors = "scissors";
    private static final String Spock = "spock";
    private static final String Lizard = "lizard";
    private static final String Fire = "fire";
    private static final String Air = "air";
    private static final String Water = "water";
    @FXML
    private Label ai;
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
    private Label player;
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

    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void playerTurn(ActionEvent event){
        String playerChoice = null;
        switch(((Button)event.getSource()).getId()){
            case "paperBtn":
                playerChoice = Paper;
                player.setText("Paper");
                break;
            case "rockBtn":
                playerChoice = Rock;
                player.setText("Rock");
                break;
            case "scissorsBtn":
                playerChoice = Scissors;
                player.setText("Scissors");
                break;
            case "spockBtn":
                playerChoice = Spock;
                player.setText("Spock");
                break;
            case "lizardBtn":
                playerChoice = Lizard;
                player.setText("Lizard");
                break;
            case "fireBtn":
                playerChoice = Fire;
                player.setText("Fire");
                break;
            case "airBtn":
                playerChoice = Air;
                player.setText("Air");
                break;
            case "waterBtn":
                playerChoice = Water;
                player.setText("Water");
                break;
        }
        winner(playerChoice, AITurn());
    }

    private String AITurn(){
        String computerChoice = null;
        int r = (int) (Math.random()*8);
        switch (r){
            case 0:
                computerChoice = Paper;
                ai.setText("Paper");
                break;
            case 1:
                computerChoice = Rock;
                ai.setText("Rock");
                break;
            case 2:
                computerChoice = Scissors;
                ai.setText("Scissors");
                break;
            case 3:
                computerChoice = Spock;
                ai.setText("Spock");
                break;
            case 4:
                computerChoice = Lizard;
                ai.setText("Lizard");
                break;
            case 5:
                computerChoice = Fire;
                ai.setText("Fire");
                break;
            case 6:
                computerChoice = Air;
                ai.setText("Air");
                break;
            case 7:
                computerChoice = Water;
                ai.setText("Water");
                break;
        }
        return computerChoice;
    }

    public void playerWin(){
        result.setText("You Win");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) +1));
    }

    public void computerWin(){
        result.setText("You Lost");
        aiScore.setText(String.valueOf(Integer.parseInt(aiScore.getText()) +1));
    }

    public void draw(){
        result.setText("It's a tie");
    }

    private void winner(String playerChoice, String computerChoice){

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
