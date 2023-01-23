package at.ac.fhcampuswien.gamelibrary.tetris;


import at.ac.fhcampuswien.gamelibrary.MainSceneSwitch;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class TetrisGame {
    // The variables
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 10;
    public static int YMAX = SIZE * 21;
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
    @FXML
    Pane group;
    private static TetrisForm object;

    public static int score = 0;
    private static int top = 0;
    private static boolean game = true;
    private static TetrisForm nextObj = TetrisController.makeRect();
    private static int linesNo = 0;


    public void createGrid()  {
        for (int[] a : MESH) {
            Arrays.fill(a, 0);
        }



        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretext = new Text("Score: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        scoretext.setFill(Color.WHITE);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.GREEN);
        group.getChildren().addAll(scoretext, line, level);
        group.setFocusTraversable(true);
        // background color change
        BackgroundFill bkg = new BackgroundFill(Paint.valueOf("#ff00ff"), new CornerRadii(0), new Insets(0));
        Background bg = new Background(bkg);
        group.setBackground(bg);
        TetrisForm a = nextObj;
        group.getChildren().addAll(a.a, a.b, a.c, a.d);
        moveOnKeyPress(a);
        object = a;
        nextObj = TetrisController.makeRect();


        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0
                                || object.d.getY() == 0)
                            top++;
                        else
                            top = 0;

                        if (top == 2) {
                            // GAME OVER
                            Text over = new Text("GAME OVER");
                            over.setFill(Color.RED);
                            over.setStyle("-fx-font: 80 arial;");
                            over.setY(250);
                            over.setX(-130);
                            group.getChildren().add(over);
                            game = false;
                        }

                        if (game) {
                            MoveDown(object);
                            scoretext.setText("Score: " + Integer.toString(score));
                            level.setText("Lines: " + Integer.toString(linesNo));
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);
    }

    private void moveOnKeyPress(TetrisForm tetrisForm) {
        group.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case D:
                        TetrisController.MoveRight(tetrisForm);
                        break;
                    case S:
                        MoveDown(tetrisForm);
                        break;
                    case A:
                        TetrisController.MoveLeft(tetrisForm);
                        break;
                    case W:
                        MoveTurn(tetrisForm);
                        break;
                }
            }
        });
    }

    private void MoveTurn(TetrisForm tetrisForm) {
        int f = tetrisForm.form;
        Rectangle a = tetrisForm.a;
        Rectangle b = tetrisForm.b;
        Rectangle c = tetrisForm.c;
        Rectangle d = tetrisForm.d;
        switch (tetrisForm.getName()) {
            case "j":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(tetrisForm.a);
                    MoveDown(tetrisForm.a);
                    MoveDown(tetrisForm.c);
                    MoveLeft(tetrisForm.c);
                    MoveDown(tetrisForm.d);
                    MoveDown(tetrisForm.d);
                    MoveLeft(tetrisForm.d);
                    MoveLeft(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, -2, 2)) {
                    MoveDown(tetrisForm.a);
                    MoveLeft(tetrisForm.a);
                    MoveLeft(tetrisForm.c);
                    MoveUp(tetrisForm.c);
                    MoveLeft(tetrisForm.d);
                    MoveLeft(tetrisForm.d);
                    MoveUp(tetrisForm.d);
                    MoveUp(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, 1) && cB(c, 1, 1) && cB(d, 2, 2)) {
                    MoveLeft(tetrisForm.a);
                    MoveUp(tetrisForm.a);
                    MoveUp(tetrisForm.c);
                    MoveRight(tetrisForm.c);
                    MoveUp(tetrisForm.d);
                    MoveUp(tetrisForm.d);
                    MoveRight(tetrisForm.d);
                    MoveRight(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 2, -2)) {
                    MoveUp(tetrisForm.a);
                    MoveRight(tetrisForm.a);
                    MoveRight(tetrisForm.c);
                    MoveDown(tetrisForm.c);
                    MoveRight(tetrisForm.d);
                    MoveRight(tetrisForm.d);
                    MoveDown(tetrisForm.d);
                    MoveDown(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                break;
            case "l":
                if (f == 1 && cB(a, 1, -1) && cB(c, 1, 1) && cB(b, 2, 2)) {
                    MoveRight(tetrisForm.a);
                    MoveDown(tetrisForm.a);
                    MoveUp(tetrisForm.c);
                    MoveRight(tetrisForm.c);
                    MoveUp(tetrisForm.b);
                    MoveUp(tetrisForm.b);
                    MoveRight(tetrisForm.b);
                    MoveRight(tetrisForm.b);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -1, -1) && cB(b, 2, -2) && cB(c, 1, -1)) {
                    MoveDown(tetrisForm.a);
                    MoveLeft(tetrisForm.a);
                    MoveRight(tetrisForm.b);
                    MoveRight(tetrisForm.b);
                    MoveDown(tetrisForm.b);
                    MoveDown(tetrisForm.b);
                    MoveRight(tetrisForm.c);
                    MoveDown(tetrisForm.c);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, 1) && cB(c, -1, -1) && cB(b, -2, -2)) {
                    MoveLeft(tetrisForm.a);
                    MoveUp(tetrisForm.a);
                    MoveDown(tetrisForm.c);
                    MoveLeft(tetrisForm.c);
                    MoveDown(tetrisForm.b);
                    MoveDown(tetrisForm.b);
                    MoveLeft(tetrisForm.b);
                    MoveLeft(tetrisForm.b);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(b, -2, 2) && cB(c, -1, 1)) {
                    MoveUp(tetrisForm.a);
                    MoveRight(tetrisForm.a);
                    MoveLeft(tetrisForm.b);
                    MoveLeft(tetrisForm.b);
                    MoveUp(tetrisForm.b);
                    MoveUp(tetrisForm.b);
                    MoveLeft(tetrisForm.c);
                    MoveUp(tetrisForm.c);
                    tetrisForm.changeForm();
                    break;
                }
                break;
            case "o":
                break;
            case "s":
                if (f == 1 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
                    MoveDown(tetrisForm.a);
                    MoveLeft(tetrisForm.a);
                    MoveLeft(tetrisForm.c);
                    MoveUp(tetrisForm.c);
                    MoveUp(tetrisForm.d);
                    MoveUp(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
                    MoveUp(tetrisForm.a);
                    MoveRight(tetrisForm.a);
                    MoveRight(tetrisForm.c);
                    MoveDown(tetrisForm.c);
                    MoveDown(tetrisForm.d);
                    MoveDown(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
                    MoveDown(tetrisForm.a);
                    MoveLeft(tetrisForm.a);
                    MoveLeft(tetrisForm.c);
                    MoveUp(tetrisForm.c);
                    MoveUp(tetrisForm.d);
                    MoveUp(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
                    MoveUp(tetrisForm.a);
                    MoveRight(tetrisForm.a);
                    MoveRight(tetrisForm.c);
                    MoveDown(tetrisForm.c);
                    MoveDown(tetrisForm.d);
                    MoveDown(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                break;
            case "t":
                if (f == 1 && cB(a, 1, 1) && cB(d, -1, -1) && cB(c, -1, 1)) {
                    MoveUp(tetrisForm.a);
                    MoveRight(tetrisForm.a);
                    MoveDown(tetrisForm.d);
                    MoveLeft(tetrisForm.d);
                    MoveLeft(tetrisForm.c);
                    MoveUp(tetrisForm.c);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(d, -1, 1) && cB(c, 1, 1)) {
                    MoveRight(tetrisForm.a);
                    MoveDown(tetrisForm.a);
                    MoveLeft(tetrisForm.d);
                    MoveUp(tetrisForm.d);
                    MoveUp(tetrisForm.c);
                    MoveRight(tetrisForm.c);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(d, 1, 1) && cB(c, 1, -1)) {
                    MoveDown(tetrisForm.a);
                    MoveLeft(tetrisForm.a);
                    MoveUp(tetrisForm.d);
                    MoveRight(tetrisForm.d);
                    MoveRight(tetrisForm.c);
                    MoveDown(tetrisForm.c);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 4 && cB(a, -1, 1) && cB(d, 1, -1) && cB(c, -1, -1)) {
                    MoveLeft(tetrisForm.a);
                    MoveUp(tetrisForm.a);
                    MoveRight(tetrisForm.d);
                    MoveDown(tetrisForm.d);
                    MoveDown(tetrisForm.c);
                    MoveLeft(tetrisForm.c);
                    tetrisForm.changeForm();
                    break;
                }
                break;
            case "z":
                if (f == 1 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
                    MoveUp(tetrisForm.b);
                    MoveRight(tetrisForm.b);
                    MoveLeft(tetrisForm.c);
                    MoveUp(tetrisForm.c);
                    MoveLeft(tetrisForm.d);
                    MoveLeft(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 2 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
                    MoveDown(tetrisForm.b);
                    MoveLeft(tetrisForm.b);
                    MoveRight(tetrisForm.c);
                    MoveDown(tetrisForm.c);
                    MoveRight(tetrisForm.d);
                    MoveRight(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 3 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
                    MoveUp(tetrisForm.b);
                    MoveRight(tetrisForm.b);
                    MoveLeft(tetrisForm.c);
                    MoveUp(tetrisForm.c);
                    MoveLeft(tetrisForm.d);
                    MoveLeft(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 4 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
                    MoveDown(tetrisForm.b);
                    MoveLeft(tetrisForm.b);
                    MoveRight(tetrisForm.c);
                    MoveDown(tetrisForm.c);
                    MoveRight(tetrisForm.d);
                    MoveRight(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                break;
            case "i":
                if (f == 1 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
                    MoveUp(tetrisForm.a);
                    MoveUp(tetrisForm.a);
                    MoveRight(tetrisForm.a);
                    MoveRight(tetrisForm.a);
                    MoveUp(tetrisForm.b);
                    MoveRight(tetrisForm.b);
                    MoveDown(tetrisForm.d);
                    MoveLeft(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
                    MoveDown(tetrisForm.a);
                    MoveDown(tetrisForm.a);
                    MoveLeft(tetrisForm.a);
                    MoveLeft(tetrisForm.a);
                    MoveDown(tetrisForm.b);
                    MoveLeft(tetrisForm.b);
                    MoveUp(tetrisForm.d);
                    MoveRight(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 3 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
                    MoveUp(tetrisForm.a);
                    MoveUp(tetrisForm.a);
                    MoveRight(tetrisForm.a);
                    MoveRight(tetrisForm.a);
                    MoveUp(tetrisForm.b);
                    MoveRight(tetrisForm.b);
                    MoveDown(tetrisForm.d);
                    MoveLeft(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                if (f == 4 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
                    MoveDown(tetrisForm.a);
                    MoveDown(tetrisForm.a);
                    MoveLeft(tetrisForm.a);
                    MoveLeft(tetrisForm.a);
                    MoveDown(tetrisForm.b);
                    MoveLeft(tetrisForm.b);
                    MoveUp(tetrisForm.d);
                    MoveRight(tetrisForm.d);
                    tetrisForm.changeForm();
                    break;
                }
                break;
        }
    }

    private void RemoveRows(Pane pane) {
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newrects = new ArrayList<Node>();
        int full = 0;
        for (int i = 0; i < MESH[0].length; i++) {
            for (int j = 0; j < MESH.length; j++) {
                if (MESH[j][i] == 1)
                    full++;
            }
            if (full == MESH.length)
                lines.add(i);
            //lines.add(i + lines.size());
            full = 0;
        }
        if (lines.size() > 0)
            do {
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                score += 50;
                linesNo++;

                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        pane.getChildren().remove(node);
                    } else
                        newrects.add(node);
                }

                for (Node node : newrects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() < lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        a.setY(a.getY() + SIZE);
                    }
                }
                lines.remove(0);
                rects.clear();
                newrects.clear();
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    try {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                rects.clear();
            } while (lines.size() > 0);
    }

    private void MoveDown(Rectangle rect) {
        if (rect.getY() + MOVE < YMAX)
            rect.setY(rect.getY() + MOVE);

    }

    private void MoveRight(Rectangle rect) {
        if (rect.getX() + MOVE <= XMAX - SIZE)
            rect.setX(rect.getX() + MOVE);
    }

    private void MoveLeft(Rectangle rect) {
        if (rect.getX() - MOVE >= 0)
            rect.setX(rect.getX() - MOVE);
    }

    private void MoveUp(Rectangle rect) {
        if (rect.getY() - MOVE > 0)
            rect.setY(rect.getY() - MOVE);
    }

    private void MoveDown(TetrisForm tetrisForm) {
        if (tetrisForm.a.getY() == YMAX - SIZE || tetrisForm.b.getY() == YMAX - SIZE || tetrisForm.c.getY() == YMAX - SIZE
                || tetrisForm.d.getY() == YMAX - SIZE || moveA(tetrisForm) || moveB(tetrisForm) || moveC(tetrisForm) || moveD(tetrisForm)) {
            MESH[(int) tetrisForm.a.getX() / SIZE][(int) tetrisForm.a.getY() / SIZE] = 1;
            MESH[(int) tetrisForm.b.getX() / SIZE][(int) tetrisForm.b.getY() / SIZE] = 1;
            MESH[(int) tetrisForm.c.getX() / SIZE][(int) tetrisForm.c.getY() / SIZE] = 1;
            MESH[(int) tetrisForm.d.getX() / SIZE][(int) tetrisForm.d.getY() / SIZE] = 1;
            RemoveRows(group);

            TetrisForm a = nextObj;
            nextObj = TetrisController.makeRect();
            object = a;
            group.getChildren().addAll(a.a, a.b, a.c, a.d);
            moveOnKeyPress(a);
        }

        if (tetrisForm.a.getY() + MOVE < YMAX && tetrisForm.b.getY() + MOVE < YMAX && tetrisForm.c.getY() + MOVE < YMAX
                && tetrisForm.d.getY() + MOVE < YMAX) {
            int movea = MESH[(int) tetrisForm.a.getX() / SIZE][((int) tetrisForm.a.getY() / SIZE) + 1];
            int moveb = MESH[(int) tetrisForm.b.getX() / SIZE][((int) tetrisForm.b.getY() / SIZE) + 1];
            int movec = MESH[(int) tetrisForm.c.getX() / SIZE][((int) tetrisForm.c.getY() / SIZE) + 1];
            int moved = MESH[(int) tetrisForm.d.getX() / SIZE][((int) tetrisForm.d.getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                tetrisForm.a.setY(tetrisForm.a.getY() + MOVE);
                tetrisForm.b.setY(tetrisForm.b.getY() + MOVE);
                tetrisForm.c.setY(tetrisForm.c.getY() + MOVE);
                tetrisForm.d.setY(tetrisForm.d.getY() + MOVE);
            }
        }
    }

    private boolean moveA(TetrisForm tetrisForm) {
        return (MESH[(int) tetrisForm.a.getX() / SIZE][((int) tetrisForm.a.getY() / SIZE) + 1] == 1);
    }

    private boolean moveB(TetrisForm tetrisForm) {
        return (MESH[(int) tetrisForm.b.getX() / SIZE][((int) tetrisForm.b.getY() / SIZE) + 1] == 1);
    }

    private boolean moveC(TetrisForm tetrisForm) {
        return (MESH[(int) tetrisForm.c.getX() / SIZE][((int) tetrisForm.c.getY() / SIZE) + 1] == 1);
    }

    private boolean moveD(TetrisForm tetrisForm) {
        return (MESH[(int) tetrisForm.d.getX() / SIZE][((int) tetrisForm.d.getY() / SIZE) + 1] == 1);
    }

    private boolean cB(Rectangle rect, int x, int y) {
        boolean xb = false;
        boolean yb = false;
        if (x >= 0)
            xb = rect.getX() + x * MOVE <= XMAX - SIZE;
        if (x < 0)
            xb = rect.getX() + x * MOVE >= 0;
        if (y >= 0)
            yb = rect.getY() - y * MOVE > 0;
        if (y < 0)
            yb = rect.getY() + y * MOVE < YMAX;
        return xb && yb && MESH[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
    }

    public void switchToMainMenu(ActionEvent e) throws IOException {
        new MainSceneSwitch().switchToMainMenu(e);
    }

}

