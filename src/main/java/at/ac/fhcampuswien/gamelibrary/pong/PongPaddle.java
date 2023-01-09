package at.ac.fhcampuswien.gamelibrary.pong;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PongPaddle extends Rectangle {

    private int id;
    private double yVelocity;
    private int speed = 8;

    PongPaddle(double x, double y, double w, double h, int id) {
        super(x,y,w,h);
        this.id = id;
    }

    private void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void keyPressed(KeyEvent e) {

        switch (id) {
            case 1:
                if (e.getCode() == KeyCode.W) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getCode() == KeyCode.S) {
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if (e.getCode() == KeyCode.UP) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getCode() == KeyCode.DOWN) {
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getCode() == KeyCode.W) {
                    setYDirection(0);
                    move();
                }
                if (e.getCode() == KeyCode.S) {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (e.getCode() == KeyCode.UP) {
                    setYDirection(0);
                    move();
                }
                if (e.getCode() == KeyCode.DOWN) {
                    setYDirection(0);
                    move();
                }
                break;
        }

    }

    public void move() {
        double paddlePos = getY();
        setY(paddlePos + yVelocity);
    }

    public void draw(GraphicsContext gc) {
        if (id == 1) {
            gc.setFill(Color.DEEPSKYBLUE);
        } else gc.setFill(Color.LIME);
        gc.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}





