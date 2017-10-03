package interview.viagogo;

/**
 * Created by zubairchowdhury on 01/10/2017.
 */
public class Point {


    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
