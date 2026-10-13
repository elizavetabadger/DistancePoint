import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static List<Point> readPoints(Scanner scanner, int count) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите координаты точки " + (i + 1)+" (x y) :");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }

        return points;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
