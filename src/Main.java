import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Point> points = Point.readPoints(scanner, 3);

        System.out.println("Каким методом посчитаем?");
        System.out.println("1 — по Евклиду");
        System.out.println("2 — по фон Нейману");
        System.out.println("3 — по Муру");

        int choice = scanner.nextInt();

        DistanceMethods service = new DistanceMethods();
        ICalcDistance calculator = service.getCalc(choice);

        Point[] pair = service.shortestDistance(points, calculator);
        double shortestDistance  = calculator.calcDistance(pair[0], pair[1]);
        double totalDistance = service.totalDistance(points, calculator);

        System.out.println("Кратчайшее расстояние " + shortestDistance + " между точками " + pair[0] + " и " + pair[1]);
        System.out.println("Расстояние через все точки: " + totalDistance);

    }
}