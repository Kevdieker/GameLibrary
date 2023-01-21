package at.ac.fhcampuswien.gamelibrary.pong;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static at.ac.fhcampuswien.gamelibrary.pong.PongConstants.*;

public class PongPaddle extends Rectangle {
    private final int id;
    private double yVelocity;

    PongPaddle(double x, double y, double w, double h, int id) {
        super(x,y,w,h);
        this.id = id;
    }

    private void setYDirection(double yDirection) {
        yVelocity = yDirection;
    }
    public void move() {
        setY(getY()+ yVelocity);
    }
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

    public void keyReleased(KeyEvent e) {

        if(id == 1 && e.getCode() == KeyCode.W || e.getCode() == KeyCode.S){
            setYDirection(0);
            move();
        }
        if(id ==2 && e.getCode() == KeyCode.UP || e.getCode() == KeyCode.DOWN){
            setYDirection(0);
            move();
        }

    }

    public void draw(GraphicsContext gc) {
        if (id == 1) {
            gc.setFill(Color.DEEPSKYBLUE);
        } else gc.setFill(Color.LIME);

        gc.fillRect(getX(),getY(),getWidth(),getHeight());
        gc.setFill(Color.RED);
        gc.fillRect(getX(),getY(),getWidth(),getHeight()-PADDLE_HEIGHT+5);
        gc.fillRect(getX(),getY()+PADDLE_HEIGHT,getWidth(),getHeight()-PADDLE_HEIGHT+5);
    }
}
