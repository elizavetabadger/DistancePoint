import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Point> points = Point.readPoints(scanner, 3);
        ICalcDistance[] calculators = {
                new EuclideanMethodCalc(),
                new VonNeumannCalc(),
                new MooreMethodCalc()
        };

        DistanceMethods service = new DistanceMethods();

        for (int i = 0; i < calculators.length; i++) {
            ICalcDistance calculator = calculators[i];

            Point[] pair = service.shortestDistance(points, calculator);
            double shortestDistance = calculator.calcDistance(pair[0], pair[1]);
            double totalDistance = service.totalDistance(points, calculator);

            String methodName = calculator.getClass().getSimpleName();

            System.out.println("Кратчайшее расстояние: " + shortestDistance + " между точками " + pair[0] + " и " + pair[1] + " по методу " + methodName);
            System.out.println("Общее расстояние по методу " + methodName + ": " + totalDistance);
        }
    }
}