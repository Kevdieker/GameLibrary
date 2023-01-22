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
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.io.IOException;

/*****************************************************************************
 * Class for running the PongGame. Drawing playing field. Update Game states.
 * @author Kevin D. Kerbl
 *****************************************************************************/

public class PongGame {
    private boolean gameStarted = false;
    private double nax, nbx, nay, nby;
    private double oax, obx, oay, oby;
    @FXML
    private Canvas canvas;
    private PongPaddle paddleOne;
    private PongPaddle paddleTwo;
    private PongBall ball;
    private int playerOneScore;
    private int playerTwoScore;

    /*****************************************************************
     * Creates new ball entity.
     *****************************************************************/
    private void newBall() {
        ball = new PongBall((WIDTH / 2) - (BALL_R / 2), ((HEIGHT / 2) - (BALL_R / 2)), BALL_R, BALL_R);
    }

    /*****************************************************************
     * Creates new pall entities.
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
                    paddleTwo.keyPressed(e);
                }
        );
        canvas.setOnKeyReleased(e -> {
            paddleOne.keyReleased(e);
            paddleTwo.keyReleased(e);
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
        gc.setFont(new Font( "Consolas",50));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.fillText(playerOneScore / 10 +String.valueOf(playerOneScore %10), (WIDTH/2)-75,50);
        gc.fillText(playerTwoScore / 10 +String.valueOf(playerTwoScore %10),(WIDTH/2)+ 75,50);

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
     * This method handles the start of a Round
     * @param gc used to draw on canvas using a buffer
     *****************************************************/

    private void processInput(GraphicsContext gc) {
        if (gameStarted) {
            paddleOne.move();
            paddleTwo.move();
            ball.move();
        } else {
            gc.setLineWidth(2);
            gc.setStroke(Color.BLUEVIOLET);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Press Any Button to Start", WIDTH / 2, HEIGHT / 2);

            canvas.addEventFilter(KeyEvent.ANY, keyEvent -> {
                gameStarted = true;
            });
        }
    }

    /***************************************************************************
     * This method
     * + handles how play field, paddles and ball interacts with each other.
     * + changes score when ball gets behind paddle
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

            /* nbx = pongBall.xVelocity;
             nby = pongBall.yVelocity;

            if (nbx != nax){
                pongBall.xVelocity = nax;
            }
*/
            ball.xVelocity = Math.abs(ball.xVelocity);

            //makes ball faster
            if (ball.xVelocity <= BALL_SPEED_CAP && ball.yVelocity <= BALL_SPEED_CAP && ball.yVelocity >= -BALL_SPEED_CAP) {
                ball.xVelocity += BALL_SPEED_INCREASE;
                if (ball.yVelocity > 0)
                    ball.yVelocity += BALL_SPEED_INCREASE;
                else ball.yVelocity -= BALL_SPEED_INCREASE;
            }

            if (ball.intersects(paddleOne.getBoundsInLocal())) {
                ball.setXVelocity(ball.xVelocity);

            } else if (ball.intersects(paddleTwo.getBoundsInLocal())) {
                ball.setXVelocity(-ball.xVelocity);
            }

            ball.setYVelocity(ball.yVelocity);

         /*   obx = ball.xVelocity;
            oby = ball.yVelocity;*/

        }

        //adds point to scoring player and redraws entities
        if (ball.getX() <= 0 || ball.getX() >= WIDTH - BALL_R) {

            if (ball.getX() <= 0)
                playerTwoScore++;
            else if (ball.getX() >= WIDTH - BALL_R)
                playerOneScore++;

            newPaddles();
            newBall();
            gameStarted = false;
        }
    }

    /******************************************************************************************
     * This method runs every 10ms on the timeline tl.
     * it draws everyting on the canvas, looks at every user input and updates the game state.
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
     * @throws IOException when we can't read the fxml file.
     ******************************************************************************************/
    public void switchToMainMenu(ActionEvent e) throws IOException {
        new MainSceneSwitch().switchToMainMenu(e);

    }
}