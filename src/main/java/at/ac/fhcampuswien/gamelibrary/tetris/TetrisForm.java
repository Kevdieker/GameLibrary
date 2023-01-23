package at.ac.fhcampuswien.gamelibrary.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TetrisForm {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color;
    private String name;
    public int form = 1;

    public TetrisForm(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public TetrisForm(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;

        switch (name) {
            case "j":
                color = Color.ROYALBLUE;
                break;
            case "l":
                color = Color.DARKORANGE;
                break;
            case "o":
                color = Color.GOLD;
                break;
            case "s":
                color = Color.FORESTGREEN;
                break;
            case "t":
                color = Color.MEDIUMPURPLE;
                break;
            case "z":
                color = Color.INDIANRED;
                break;
            case "i":
                color = Color.LIGHTSKYBLUE;
                break;

        }
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }


    public String getName() {
        return name;
    }


    public void changeForm() {
        if (form != 4) {
            form++;
        } else {
            form = 1;
        }
    }
}
