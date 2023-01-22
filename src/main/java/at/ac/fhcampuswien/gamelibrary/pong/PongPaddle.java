package at.ac.fhcampuswien.gamelibrary.pong;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static at.ac.fhcampuswien.gamelibrary.pong.PongConstants.*;

public class PongPaddle extends Rectangle {
    private final int id;
    public double yVelocity;

    PongPaddle(double x, double y, double w, double h, int id) {
        super(x, y, w, h);
        this.id = id;
    }

    /*********************************************
     * Sets y velocity to y direction
     * @param yDirection random y direction
     *********************************************/
    void setYDirection(double yDirection) {
        yVelocity = yDirection;
    }

    /**********************************************************
     * moves paddle from old in x y position to new x y position
     ****************************************************+*****/
    public void move() {
        setY(getY() + yVelocity);
    }

    /****************************************************
     * Reads pressed keys and calculates new y position
     * @param e event key for KeyEvent
     ****************************************************/
    public void keyPressed(KeyEvent e) {

        switch (id) {
            case 1 -> {
                if (e.getCode() == KeyCode.W) {
                    setYDirection(-PADDLE_SPEED);
                    move();
                }
                if (e.getCode() == KeyCode.S) {
                    setYDirection(PADDLE_SPEED);
                    move();
                }
            }
            case 2 -> {
                if (e.getCode() == KeyCode.UP) {
                    setYDirection(-PADDLE_SPEED);
                    move();
                }
                if (e.getCode() == KeyCode.DOWN) {
                    setYDirection(PADDLE_SPEED);
                    move();
                }
            }
        }
    }

    /****************************************************
     * Reads released keys and calculates new y position
     * @param e event key for KeyEvent
     ****************************************************/
    public void keyReleased(KeyEvent e) {

        switch (id) {
            case 1 -> {
                if (e.getCode() == KeyCode.W) {
                    setYDirection(0);
                    move();
                }
                if (e.getCode() == KeyCode.S) {
                    setYDirection(0);
                    move();
                }
            }
            case 2 -> {
                if (e.getCode() == KeyCode.UP) {
                    setYDirection(0);
                    move();
                }
                if (e.getCode() == KeyCode.DOWN) {
                    setYDirection(0);
                    move();
                }
            }
        }
    }

    /**********************************************************
     * draws paddles
     * @param gc used to draw on canvas using a buffer
     ****************************************************+*****/
    public void draw(GraphicsContext gc) {
        if (id == 1) {
            gc.setFill(Color.DEEPSKYBLUE);
        } else gc.setFill(Color.LIME);

        gc.fillRect(getX(), getY(), getWidth(), getHeight());
        gc.setFill(Color.RED);
        gc.fillRect(getX(), getY(), getWidth(), getHeight() - PADDLE_HEIGHT + 5);
        gc.fillRect(getX(), getY() + PADDLE_HEIGHT, getWidth(), getHeight() - PADDLE_HEIGHT + 5);
    }
}
