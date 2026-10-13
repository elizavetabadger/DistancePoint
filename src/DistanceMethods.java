import java.util.List;

public class DistanceMethods {

    public ICalcDistance getCalc(int choice) {
        return switch (choice) {
            case 1 -> new EuclideanMethodCalc();
            case 2 -> new VonNeumannCalc();
            case 3 -> new MooreMethodCalc();
            default -> throw new IllegalArgumentException("Неизвестный метод: " + choice);
        };
    }

    public Point[] shortestDistance(List<Point> points, ICalcDistance calculator) {
        Point first = null;
        Point second = null;
        double shortest = Double.MAX_VALUE;

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                double distance = calculator.calcDistance(points.get(i), points.get(j));

                if (distance < shortest) {
                    shortest = distance;
                    first = points.get(i);
                    second = points.get(j);
                }
            }
        }

        return new Point[]{first, second};
    }

    public double totalDistance(List<Point> points, ICalcDistance calculator) {
        double total = 0;

        for (int i = 1; i < points.size(); i++) {
            total += calculator.calcDistance(points.get(i - 1), points.get(i));
        }

        return total;
    }
}
