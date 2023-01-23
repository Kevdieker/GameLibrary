package at.ac.fhcampuswien.gamelibrary.pong;

import static at.ac.fhcampuswien.gamelibrary.pong.PongConstants.*;

import at.ac.fhcampuswien.gamelibrary.MainSceneSwitch;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.io.IOException;

/*****************************************************************************
 * Class for running the pong-game. Drawing playing field. Update game states.
 * @author Kevin D. Kerbl
 *****************************************************************************/

public class PongGame {
    private int winCon;
    private int paddleOneIntersections, paddleTwoIntersections;
    private boolean roundStarted = false;
    private boolean gameEnded = false;
    private double storedPaddleOneBallYVelocity, storedPaddleTwoBallYVelocity;
    private double storedPaddleOneBallXVelocity, storedPaddleTwoBallXVelocity;
    @FXML
    private Canvas canvas;
    @FXML
    private Text playerLabel;
    @FXML
    private RadioButton rdb7, rdb13, rdb21;
    private PongPaddle paddleOne;
    private PongPaddle paddleTwo;
    private PongBall ball;
    private int playerOneScore;
    private int playerTwoScore;
    private boolean twoPlayerMode;

    /*****************************************************************
     * TwoPlayerMode setter.
     * @param twoPlayerMode to set two player mode.
     *****************************************************************/
    public void setTwoPlayerMode(boolean twoPlayerMode) {
        this.twoPlayerMode = twoPlayerMode;
    }

    /*****************************************************************
     * Win condition setter.
     * @param winCon to set winning condition.
     *****************************************************************/
    public void setWinCon(int winCon) {
        this.winCon = winCon;
    }

    /*****************************************************************
     * Get winning condition from radiobutton
     * @return winCon, is the winning condition.
     *****************************************************************/
    public int getWinCon() {
        if (rdb7.isSelected()) setWinCon(7);
        else if (rdb13.isSelected()) setWinCon(13);
        else if (rdb21.isSelected()) setWinCon(21);
        return winCon;
    }

    /*****************************************************************
     * Creates new ball entity.
     *****************************************************************/
    private void newBall() {
        ball = new PongBall((WIDTH / 2) - (BALL_R / 2), ((HEIGHT / 2) - (BALL_R / 2)), BALL_R, BALL_R);
    }

    /*****************************************************************
     * Creates new paddle entities.
     *****************************************************************/
    private void newPaddles() {
        paddleOne = new PongPaddle(25, HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddleTwo = new PongPaddle(WIDTH - PADDLE_WIDTH - 25, HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }

    /*****************************************************************
     * Creates entities. Make controls accessible.
     * Starts a timeline which updates the UserInterface every 10ms.
     *****************************************************************/
    public void createGrid() {

        newPaddles();
        newBall();

        canvas.setFocusTraversable(true);

        canvas.setOnKeyPressed(e -> {
                    paddleOne.keyPressed(e);
                    if (twoPlayerMode) {
                        paddleTwo.keyPressed(e);
                    }
                }
        );
        canvas.setOnKeyReleased(e -> {
            paddleOne.keyReleased(e);
            if (twoPlayerMode) {
                paddleTwo.keyReleased(e);
            }
        });

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    /***************************************************
     * Draws the play field.
     * @param gc used to draw on canvas using a buffer
     **************************************************/
    private void drawPlayField(GraphicsContext gc) {

        //draws field
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        //draws score
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("Consolas", 50));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.fillText(playerOneScore / 10 + String.valueOf(playerOneScore % 10), (WIDTH / 2) - 75, 50);
        gc.fillText(playerTwoScore / 10 + String.valueOf(playerTwoScore % 10), (WIDTH / 2) + 75, 50);

        //Draws the net in the middle of the field.
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(5);
        for (int i = 0; i <= 15; i++) {
            gc.strokeLine(WIDTH / 2, i * (HEIGHT / 16) + 5, WIDTH / 2, i * (HEIGHT / 16) + HEIGHT / 32);
        }
    }

    /*****************************************************************
     * Draws the play field, ball and paddles on the canvas.
     * @param gc used to draw on canvas using a buffer
     *****************************************************************/
    private void draw(GraphicsContext gc) {
        drawPlayField(gc);
        ball.draw(gc);
        paddleOne.draw(gc);
        paddleTwo.draw(gc);
    }

    /*****************************************************
     * This method lets the bot run after the ball
     *****************************************************/
    public void simpleBot() {

        if (paddleTwo.getY() < ball.getY()) {
            paddleTwo.setYDirection(PADDLE_SPEED);
        } else if (paddleTwo.getY() >= ball.getY()) {
            paddleTwo.setYDirection(-PADDLE_SPEED);
        }
    }

    /*******************************************************************
     * This method handles the start of a Round and the End of a game
     * @param gc used to draw on canvas using a buffer
     ******************************************************************/

    private void processInput(GraphicsContext gc) {
        if (roundStarted && !gameEnded) {
            if (!twoPlayerMode) simpleBot();
            paddleOne.move();
            paddleTwo.move();
            ball.move();

        } else if (!gameEnded) {
            gc.setLineWidth(2);
            gc.setStroke(Color.BLUEVIOLET);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Press Any Button to Start", WIDTH / 2, HEIGHT / 2);

            canvas.addEventFilter(KeyEvent.ANY, keyEvent -> {
                roundStarted = true;
            });
        } else {

            gc.setLineWidth(2);
            if (playerOneScore == winCon) {
                playerOneWins(gc);
            } else if (playerTwoScore == winCon) {
                if (twoPlayerMode) playerTwoWins(gc);
                else botWins(gc);
            }
        }
    }

    /***************************************************************************
     * This method
     * + handles how play field, paddles and ball interacts with each other
     * + changes score when ball gets behind paddle
     * + looks who won
     ***************************************************************************/
    public void updateState() {

        //stops paddles at window edges
        if (paddleOne.getY() <= 0) paddleOne.setY(0);
        if (paddleOne.getY() >= (HEIGHT - PADDLE_HEIGHT)) paddleOne.setY(HEIGHT - PADDLE_HEIGHT);

        if (paddleTwo.getY() <= 0) paddleTwo.setY(0);
        if (paddleTwo.getY() >= (HEIGHT - PADDLE_HEIGHT)) paddleTwo.setY(HEIGHT - PADDLE_HEIGHT);

        // ball bounces off top/bottom window edges
        if (ball.getY() <= 0) ball.setYVelocity(-ball.yVelocity);
        if (ball.getY() >= HEIGHT - BALL_R) ball.setYVelocity(-ball.yVelocity);

        // ball bounces off paddles
        if (ball.intersects(paddleOne.getBoundsInLocal()) || ball.intersects(paddleTwo.getBoundsInLocal())) {

            ball.xVelocity = Math.abs(ball.xVelocity);

            //makes ball faster
            if (ball.xVelocity <= BALL_SPEED_CAP && ball.yVelocity <= BALL_SPEED_CAP && ball.yVelocity >= -BALL_SPEED_CAP) {
                ball.xVelocity += BALL_SPEED_INCREASE;
                if (ball.yVelocity > 0)
                    ball.yVelocity += BALL_SPEED_INCREASE;
                else ball.yVelocity -= BALL_SPEED_INCREASE;
            }
            if (ball.intersects(paddleOne.getBoundsInLocal())) {

                //saves Bal velocity when it intersects with paddle the second time
                if (paddleOneIntersections == 1) {
                    storedPaddleOneBallXVelocity = Math.abs(ball.xVelocity);
                    storedPaddleOneBallYVelocity = ball.yVelocity;
                }

                /*if a ball intersected with player two more than one time,
                 set back ball-velocity to before the multiple intersections*/
                if (paddleTwoIntersections > 1) {
                    ball.xVelocity = storedPaddleTwoBallXVelocity;
                    ball.yVelocity = storedPaddleTwoBallYVelocity;
                }


                ball.setXVelocity(ball.xVelocity);
                ball.setYVelocity(ball.yVelocity);

                paddleOneIntersections++;
                paddleTwoIntersections = 0;
            }
            if (ball.intersects(paddleTwo.getBoundsInLocal())) {

                if (paddleTwoIntersections == 1) {
                    storedPaddleTwoBallXVelocity = Math.abs(ball.xVelocity);
                    storedPaddleTwoBallYVelocity = ball.yVelocity;
                }

                if (paddleOneIntersections > 1) {
                    ball.xVelocity = storedPaddleOneBallXVelocity;
                    ball.yVelocity = storedPaddleOneBallYVelocity;
                }

                ball.setXVelocity(-ball.xVelocity);
                ball.setYVelocity(ball.yVelocity);

                paddleOneIntersections = 0;
                paddleTwoIntersections++;
            }
        }
        //adds point to scoring player and redraws entities
        if (ball.getX() <= 0 || ball.getX() >= WIDTH - BALL_R) {

            if (ball.getX() <= 0)
                playerTwoScore++;
            else if (ball.getX() >= WIDTH - BALL_R)
                playerOneScore++;

            newPaddles();
            newBall();
            storedPaddleOneBallXVelocity = BALL_SPEED;
            storedPaddleTwoBallXVelocity = BALL_SPEED;

            roundStarted = false;
        }
        //looks who won and ends game
        if (playerOneScore == winCon || playerTwoScore == winCon) gameEnded = true;
    }

    /***************************************************************************
     * Draws that Player 1 did not cheat
     * @param gc used to draw on canvas using a buffer
     ***************************************************************************/
    private void playerOneWins(GraphicsContext gc) {
        gc.setStroke(Color.DEEPSKYBLUE);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.strokeText("PLAYER 1 WINS", WIDTH / 4, HEIGHT / 4);
    }

    /***************************************************************************
     * Draws that player 2 did not lose
     * @param gc used to draw on canvas using a buffer
     ***************************************************************************/
    private void playerTwoWins(GraphicsContext gc) {
        gc.setStroke(Color.LIME);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.strokeText("PLAYER 2 WINS", WIDTH - WIDTH / 4, HEIGHT / 4);
    }

    /***************************************************************************
     * Draws the real winner of the hearts
     * @param gc used to draw on canvas using a buffer
     ***************************************************************************/
    private void botWins(GraphicsContext gc) {
        gc.setFont(new Font("Consolas", 80));
        gc.setStroke(Color.LIME);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.strokeText("You lose", WIDTH / 2, HEIGHT / 2);
    }


    /******************************************************************************************
     * This method runs every 10ms on the timeline tl.
     * it draws everything on the canvas, looks at every user input and updates the game state.
     *
     * @param gc used to draw on canvas using a buffer
     ******************************************************************************************/
    private void run(GraphicsContext gc) {
        draw(gc);
        processInput(gc);
        updateState();
    }

    /******************************************************************************************
     * Switches scene to main menu
     * @param e used to draw on canvas using a buffer
     * @throws IOException if we can't read the fxml file.
     ******************************************************************************************/
    public void switchToMainMenu(ActionEvent e) throws IOException {
        new MainSceneSwitch().switchToMainMenu(e);
    }

    /******************************************************************************************
     * Switches scene to PongMenu
     * @param e used to draw on canvas using a buffer
     * @throws IOException if we can't read the fxml file.
     ******************************************************************************************/
    public void switchToPongMenu(ActionEvent e) throws IOException {
        new MainSceneSwitch().switchToPongMenu(e);

    }

    /******************************************************************************************
     * Switches scene to PongMenu
     * @param e used to draw on canvas using a buffer
     * @throws IOException if we can't read the fxml file.
     ******************************************************************************************/
    public void switchToPongGame(ActionEvent e) throws IOException {
        MainSceneSwitch newSwitch = new MainSceneSwitch();
        newSwitch.switchToPongGame(e, twoPlayerMode, getWinCon());
    }

    /******************************************************************************************
     * Switches to 2 player mode
     ******************************************************************************************/
    public void twoPlayerMode() {
        playerLabel.setText("2 Player");
        setTwoPlayerMode(true);
    }

    /******************************************************************************************
     * Switches to bot mode
     ******************************************************************************************/
    public void onePLayerMode() {
        playerLabel.setText("1 Player");
        setTwoPlayerMode(false);
    }

    /******************************************************************************************
     * Opens secret heart scene for special person.
     * @throws IOException if we can't read the fxml file.
     ******************************************************************************************/
    public void heartWindow() throws IOException {
        new MainSceneSwitch().heartWindow();
    }

    @FXML
    TextField txtfieldHeart;

    public void checktxtdield() throws IOException {
        if (txtfieldHeart.getText().equals("0312")) {
            new MainSceneSwitch().biggerHeartWindow();
        }
    }
}