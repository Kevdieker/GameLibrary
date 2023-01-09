package at.ac.fhcampuswien.gamelibrary.pong;


import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class PongScore extends Rectangle {
    static double GAME_WIDTH;
    static double GAME_HEIGHT;
    int player1;
    int player2;

    PongScore(double GAME_WIDTH, double GAME_HEIGHT){
        PongScore.GAME_WIDTH = GAME_WIDTH;
        PongScore.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void draw(GraphicsContext gc){

        gc.setFill(Color.WHITE);
        gc.setFont(new Font( "Consolas",60));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.fillText(player1 / 10 +String.valueOf(player1%10), (GAME_WIDTH/2)-75,50);
        gc.fillText(player2 / 10 +String.valueOf(player2%10),(GAME_WIDTH/2)+ 75,50);
    }
}
