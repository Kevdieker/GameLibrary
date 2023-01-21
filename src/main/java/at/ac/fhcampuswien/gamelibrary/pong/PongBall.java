package at.ac.fhcampuswien.gamelibrary.pong;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

import static at.ac.fhcampuswien.gamelibrary.pong.PongConstants.BALL_SPEED;

/*****************************************************************************
 * Class for Ball entity. Random ball spawn. Ball movement. Draw ball.
 * @author Kevin D. Kerbl
 *****************************************************************************/
public class PongBall extends Rectangle {
    Random random = new Random();
    ;
    public double xVelocity;
    public double yVelocity;

    /*********************************************
     * Sets x velocity to x direction
     * @param xDirection random x direction
     *********************************************/
    public void setXVelocity(double xDirection) {
        xVelocity = xDirection;
    }

    /*********************************************
     * Sets y velocity to y direction
     * @param yDirection random y direction
     *********************************************/
    public void setYVelocity(double yDirection) {
        yVelocity = yDirection;
    }

    //Ball constructor with random direction implementation
    PongBall(double x, double y, double w, double h) {
        super(x, y, w, h);

        int XDirection = random.nextInt(2);
        int YDirection = random.nextInt(2);

        if (XDirection == 0)
            XDirection--;

        if (YDirection == 0)
            YDirection--;

        setXVelocity(XDirection * BALL_SPEED);
        setYVelocity(YDirection * BALL_SPEED);
    }

    /**********************************************************
     * moves ball from old in x y position to new x y position
     ****************************************************+*****/
    public void move() {
        setX(getX() + xVelocity);
        setY(getY() + yVelocity);
    }

    /**********************************************************
     * draws ball
     * @param gc used to draw on canvas using a buffer
     ****************************************************+*****/
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.ORANGE);
        gc.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}