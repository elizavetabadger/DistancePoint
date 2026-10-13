import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        List<Point> points = Point.readPoints(scanner, 3);

        example1(scanner, points);
        example2(points);
    }

    public static void example2(List<Point> points){
        ICalcDistance[] calculators = {
                new EuclideanMethodCalc(),
                new VonNeumannCalc(),
                new MooreMethodCalc()
        };

        DistanceMethods service = new DistanceMethods();

        for (ICalcDistance calculator : calculators) {
            Point[] pair = service.shortestDistance(points, calculator);
            double shortestDistance = calculator.calcDistance(pair[0], pair[1]);

            String methodName = calculator.getClass().getSimpleName();

            System.out.println("Кратчайшее расстояние: " + shortestDistance + " между точками " + pair[0] + " и " + pair[1] + " по методу " + methodName);
        }
    }
    public static void example1(Scanner scanner, List<Point> points){

        System.out.println("Каким методом посчитаем?");
        System.out.println("1 — по Евклиду");
        System.out.println("2 — по фон Нейману");
        System.out.println("3 — по Муру");

        int choice = scanner.nextInt();

        DistanceMethods service = new DistanceMethods();
        ICalcDistance calculator = service.getCalc(choice);

        Point[] pair = service.shortestDistance(points, calculator);
        double distance = calculator.calcDistance(pair[0], pair[1]);
        double totalDistance = service.totalDistance(points, calculator);

        System.out.println("Кратчайшее расстояние: " + distance + " между точками " + pair[0] + " и " + pair[1]);
        System.out.println("Расстояние через все точки: " + totalDistance);

    }
}