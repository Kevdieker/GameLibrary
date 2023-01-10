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

public class NormalPlayers {
    private Stage stage;
    private Scene scene;
    private static final String Rock = "rock";
    private static final String Paper = "paper";
    private static final String Scissors = "scissors";
    private String player1Choice;
    private String player2Choice;
    @FXML
    private Label player2Score;
    @FXML
    private Label player1Score;
    @FXML
    private Button paperBtn1;
    @FXML
    private Button paperBtn2;
    @FXML
    private Label player1;
    @FXML
    private Label player2;
    @FXML
    private Label result;
    @FXML
    private Button rockBtn1;
    @FXML
    private Button rockBtn2;
    @FXML
    private Button scissorBtn1;
    @FXML
    private Button scissorBtn2;

    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void player1Turn(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            case "paperBtn1":
                player1Choice = Paper;
                player1.setText("Paper");
                break;
            case "rockBtn1":
                player1Choice = Rock;
                player1.setText("Rock");
                break;
            case "scissorBtn1":
                player1Choice = Scissors;
                player1.setText("Scissors");
                break;
        }
        checkIfWon();
    }

    @FXML
    private void player2Turn(ActionEvent ev) {
        switch (((Button) ev.getSource()).getId()) {
            case "paperBtn2":
                player2Choice = Paper;
                player2.setText("Paper");
                break;
            case "rockBtn2":
                player2Choice = Rock;
                player2.setText("Rock");
                break;
            case "scissorBtn2":
                player2Choice = Scissors;
                player2.setText("Scissors");
                break;
        }
        checkIfWon();
    }

    public void player1Win(){
        result.setText("Player 1 wins!");
        player1Score.setText(String.valueOf(Integer.parseInt(player1Score.getText()) +1));
    }

    public void player2Win(){
        result.setText("Player 2 wins!");
        player2Score.setText(String.valueOf(Integer.parseInt(player2Score.getText()) +1));
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
            }
        } else if (player1Choice.equals(Rock)) {
            if (player2Choice.equals(Paper)) {
                player2Win();
            } else if (player2Choice.equals(Scissors)) {
                player1Win();
            }
        } else if (player1Choice.equals(Scissors)) {
            if (player2Choice.equals(Rock)) {
                player2Win();
            } else if (player2Choice.equals(Paper)) {
                player1Win();
            }
        }
    }
}

    /*
    private void scoreplayer2 () {
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
     */



