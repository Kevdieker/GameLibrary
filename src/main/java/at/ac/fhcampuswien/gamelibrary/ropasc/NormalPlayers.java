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
 * Class for Normal-Player-Mode if chosen in Rock,Paper,Scissors-Menu
 * @author Fatima Hossain
 *****************************************************************************/
public class NormalPlayers {
    private Stage stage;
    private Scene scene;
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";

    private String player1Choice;
    private String player2Choice;
    @FXML
    private Label player2Score;
    @FXML
    private Label player1Score;
    @FXML
    private ImageView player1;
    @FXML
    private ImageView player2;
    @FXML
    private Label result;
    private Image image;
    @FXML
    Rectangle tool;

    /*****************************************************************************
     * switches to Rock,Paper,Scissors-Menu if Back-Button is clicked
     *****************************************************************************/
    public void switchToMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*****************************************************************************
     * identifies player1's buttons and sets correct image
     * winner-method() is implemented
     *****************************************************************************/
    @FXML
    private void player1Turn(ActionEvent event){
        tool.setVisible(true);
        switch (((Button) event.getSource()).getId()) {
            case "paperBtn1":
                player1Choice = PAPER;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case "rockBtn1":
                player1Choice = ROCK;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case "scissorBtn1":
                player1Choice = SCISSORS;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                break;
        }
        player1.setImage(image);
        winner();
    }

    /*****************************************************************************
     * identifies player2's buttons and sets correct image
     * winner-method() is implemented
     *****************************************************************************/
    @FXML
    private void player2Turn(ActionEvent ev) {
        tool.setVisible(false);
        switch (((Button) ev.getSource()).getId()) {
            case "paperBtn2":
                player2Choice = PAPER;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/paper.png");
                break;
            case "rockBtn2":
                player2Choice = ROCK;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/rock.png");
                break;
            case "scissorBtn2":
                player2Choice = SCISSORS;
                image = new Image("at/ac/fhcampuswien/gamelibrary/ropasc/scissors.png");
                break;
        }
        player2.setImage(image);
        winner();
    }

    /*****************************************************************************
     * result set to "Player 1 wins!", if player 1 wins
     * if tool is not visible player1Scores raises to +1 point
     * if tool is visible player2Score stays the same
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
     * result set to "Player 2 wins!", if player 1 wins
     * if tool is not visible player2Scores raises to +1 point
     * if tool is visible player1Score stays the same
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
     * result set to "It's a tie" if player1 and player2 chooses same option
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
            }
        } else if (player1Choice.equals(ROCK)) {
            if (player2Choice.equals(PAPER)) {
                player2Win();
            } else if (player2Choice.equals(SCISSORS)) {
                player1Win();
            }
        } else if (player1Choice.equals(SCISSORS)) {
            if (player2Choice.equals(ROCK)) {
                player2Win();
            } else if (player2Choice.equals(PAPER)) {
                player1Win();
            }
        }
    }


}




