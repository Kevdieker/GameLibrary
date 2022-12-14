package at.ac.fhcampuswien.gamelibrary.pong;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class PongBall extends Rectangle {

    Random random;
    double xVelocity;
    double yVelocity;

    double initialSpeed = 3;

    PongBall(double x, double y, double w, double h) {
        super(x,y,w,h);

        random = new Random();

        int XDirection = random.nextInt(2);

        if (XDirection == 0)
            XDirection--;

        setXDirection(XDirection * initialSpeed);

        int YDirection = random.nextInt(2);

        if (YDirection == 0)
            YDirection--;

        setYDirection(YDirection * initialSpeed);
    }
    public void setXDirection(double XDirection) {
        xVelocity = XDirection;
    }
    public void setYDirection(double YDirection) {
        yVelocity = YDirection;
    }

    public void move() {
        double ballPosX = getX();
        setX(ballPosX + xVelocity);

        double ballPosY = getY();
        setY(ballPosY + yVelocity);

    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.ORANGE);
        gc.fillOval(getX(),getY(),getWidth(),getHeight());
    }
}