package at.ac.fhcampuswien.gamelibrary.Tetris;



import javafx.scene.shape.Rectangle;

public class TetrisController {
    private static TetrisController TetrisMain;
    // Getting the numbers and the MESH from Tetris
    public static final int MOVE = TetrisMain.MOVE;
    public static final int SIZE = TetrisMain.SIZE;
    public static int XMAX = TetrisMain.XMAX;
    public static int YMAX = TetrisMain.YMAX;
    public static int[][] MESH = TetrisMain.MESH;

    public static void MoveRight(TetrisForm tetrisForm) {
        if (tetrisForm.a.getX() + MOVE <= XMAX - SIZE && tetrisForm.b.getX() + MOVE <= XMAX - SIZE
                && tetrisForm.c.getX() + MOVE <= XMAX - SIZE && tetrisForm.d.getX() + MOVE <= XMAX - SIZE) {
            int movea = MESH[((int) tetrisForm.a.getX() / SIZE) + 1][((int) tetrisForm.a.getY() / SIZE)];
            int moveb = MESH[((int) tetrisForm.b.getX() / SIZE) + 1][((int) tetrisForm.b.getY() / SIZE)];
            int movec = MESH[((int) tetrisForm.c.getX() / SIZE) + 1][((int) tetrisForm.c.getY() / SIZE)];
            int moved = MESH[((int) tetrisForm.d.getX() / SIZE) + 1][((int) tetrisForm.d.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                tetrisForm.a.setX(tetrisForm.a.getX() + MOVE);
                tetrisForm.b.setX(tetrisForm.b.getX() + MOVE);
                tetrisForm.c.setX(tetrisForm.c.getX() + MOVE);
                tetrisForm.d.setX(tetrisForm.d.getX() + MOVE);
            }
        }
    }

    public static void MoveLeft(TetrisForm tetrisForm) {
        if (tetrisForm.a.getX() - MOVE >= 0 && tetrisForm.b.getX() - MOVE >= 0 && tetrisForm.c.getX() - MOVE >= 0
                && tetrisForm.d.getX() - MOVE >= 0) {
            int movea = MESH[((int) tetrisForm.a.getX() / SIZE) - 1][((int) tetrisForm.a.getY() / SIZE)];
            int moveb = MESH[((int) tetrisForm.b.getX() / SIZE) - 1][((int) tetrisForm.b.getY() / SIZE)];
            int movec = MESH[((int) tetrisForm.c.getX() / SIZE) - 1][((int) tetrisForm.c.getY() / SIZE)];
            int moved = MESH[((int) tetrisForm.d.getX() / SIZE) - 1][((int) tetrisForm.d.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                tetrisForm.a.setX(tetrisForm.a.getX() - MOVE);
                tetrisForm.b.setX(tetrisForm.b.getX() - MOVE);
                tetrisForm.c.setX(tetrisForm.c.getX() - MOVE);
                tetrisForm.d.setX(tetrisForm.d.getX() - MOVE);
            }
        }
    }

    public static TetrisForm makeRect() {
        int block = (int) (Math.random() * 100);
        String name;
        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
                d = new Rectangle(SIZE-1, SIZE-1);
        if (block < 15) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "j";
        } else if (block < 30) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "l";
        } else if (block < 45) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 - SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2);
            d.setY(SIZE);
            name = "o";
        } else if (block < 60) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 - SIZE);
            d.setY(SIZE);
            name = "s";
        } else if (block < 75) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            name = "t";
        } else if (block < 90) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "z";
        } else {
            a.setX(XMAX / 2 - SIZE - SIZE);
            b.setX(XMAX / 2 - SIZE);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + SIZE);
            name = "i";
        }
        return new TetrisForm(a, b, c, d, name);
    }
}
