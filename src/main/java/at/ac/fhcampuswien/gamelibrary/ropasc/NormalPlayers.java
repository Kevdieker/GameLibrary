package at.ac.fhcampuswien.gamelibrary.ropasc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

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
    private ImageView player1;
    @FXML
    private ImageView player2;
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
    private void player1Turn(ActionEvent event){
        tool.setVisible(true);
        switch (((Button) event.getSource()).getId()) {
            case "paperBtn1":
                player1Choice = Paper;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case "rockBtn1":
                player1Choice = Rock;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case "scissorBtn1":
                player1Choice = Scissors;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                break;
        }
        player1.setImage(image);
        checkIfWon();
    }

    @FXML
    private void player2Turn(ActionEvent ev) {
        tool.setVisible(false);
        switch (((Button) ev.getSource()).getId()) {
            case "paperBtn2":
                player2Choice = Paper;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case "rockBtn2":
                player2Choice = Rock;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case "scissorBtn2":
                player2Choice = Scissors;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
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




