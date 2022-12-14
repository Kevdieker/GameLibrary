package at.ac.fhcampuswien.gamelibrary.pong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import static at.ac.fhcampuswien.gamelibrary.pong.PongConstants.*;

public class PongGame {
    PongPaddle pongPaddle1;
    PongPaddle pongPaddle2;
    PongBall pongBall;
    public boolean gameStarted;

    @FXML
    Canvas canvas;
    @FXML
    Button exitButton;

    PongScore score;

    public void createGrid() {

        newPaddles();
        newBall();
        score = new PongScore(WIDTH, HEIGHT);

        //canvas.setOnMouseMoved(e -> playerOneYPos = e.getY());

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(new ALPressed());
        canvas.setOnKeyReleased(new ALReleased());

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();



        exitButton.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
    }

    public void newBall() {
        pongBall = new PongBall((WIDTH / 2) - (BALL_R / 2), ((HEIGHT / 2) - (BALL_R / 2)), BALL_R, BALL_R);
    }

    public void newPaddles( ) {
        pongPaddle1 = new PongPaddle(100, HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        pongPaddle2 = new PongPaddle(WIDTH - PADDLE_WIDTH - 100, HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }

    public void draw(GraphicsContext gc) {
        pongBall.draw(gc);
        pongPaddle1.draw(gc);
        pongPaddle2.draw(gc);
        score.draw(gc);

        gc.setLineWidth(1);
        gc.setStroke(Color.YELLOW);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.strokeText("Click to Start", WIDTH / 2, HEIGHT / 2);

        gc.setStroke(Color.WHITE);
        gc.setLineWidth(10);
        gc.strokeLine(WIDTH/2,0,WIDTH/2,HEIGHT);


    }

    private void processInput() {
        pongPaddle1.move();
        pongPaddle2.move();
        pongBall.move();
    }

    public void update_state(GraphicsContext gc) {

        //bounce ball off top & bottom window edges
        if (pongBall.getY() <= 0) {
            pongBall.setYDirection(-pongBall.yVelocity);
        }
        if (pongBall.getY() >= HEIGHT - BALL_R) {
            pongBall.setYDirection(-pongBall.yVelocity);
        }

        //bounces ball off paddles
        if (pongBall.intersects(pongPaddle1.getBoundsInLocal())) {
            pongBall.xVelocity = Math.abs(pongBall.xVelocity);

            if (pongBall.xVelocity <= BALL_SPEED_CAP && pongBall.yVelocity <= BALL_SPEED_CAP && pongBall.yVelocity >= -BALL_SPEED_CAP) {
                pongBall.xVelocity++; // difficulty

                if (pongBall.yVelocity > 0)
                    pongBall.yVelocity++;
                else pongBall.yVelocity--;
            }

            pongBall.setXDirection(pongBall.xVelocity);
            pongBall.setYDirection(pongBall.yVelocity);
        }

        if (pongBall.intersects(pongPaddle2.getBoundsInLocal())) {
            pongBall.xVelocity = Math.abs(pongBall.xVelocity);

            if (pongBall.xVelocity <= BALL_SPEED_CAP && pongBall.yVelocity <= BALL_SPEED_CAP && pongBall.yVelocity >= -BALL_SPEED_CAP) {
                pongBall.xVelocity++; // difficulty

                if (pongBall.yVelocity > 0)
                    pongBall.yVelocity++;
                else pongBall.yVelocity--;
            }

            pongBall.setXDirection(-pongBall.xVelocity);
            pongBall.setYDirection(pongBall.yVelocity);
        }

        //stops paddles at window edges
        if (pongPaddle1.getY() <= 0)
            pongPaddle1.setY(0);
        if (pongPaddle1.getY() >= (HEIGHT - PADDLE_HEIGHT))
            pongPaddle1.setY(HEIGHT - PADDLE_HEIGHT);
        if (pongPaddle2.getY() <= 0)
            pongPaddle2.setY(0);
        if (pongPaddle2.getY() >= (HEIGHT - PADDLE_HEIGHT))
            pongPaddle2.setY(HEIGHT - PADDLE_HEIGHT);

        //give a player 1 point and creates new paddles & ball
        if (pongBall.getX() <= 0) {
            score.player2++;
            newPaddles();
            newBall();
            gameStarted = false;
        }

        if (pongBall.getX() >= WIDTH - BALL_R) {
            score.player1++;
            newPaddles();
            newBall();
            gameStarted = false;

        }
    }
    public void render(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
    }

    private void run(GraphicsContext gc) {
        processInput();
        update_state(gc);
        render(gc);
        draw(gc);
    }

    public class ALPressed implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent e) {

            pongPaddle1.keyPressed(e);
            pongPaddle2.keyPressed(e);
        }
    }

    public class ALReleased implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent e) {
            pongPaddle1.keyReleased(e);
            pongPaddle2.keyReleased(e);
        }
    }
}