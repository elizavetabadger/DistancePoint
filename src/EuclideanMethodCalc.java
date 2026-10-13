public class EuclideanMethodCalc implements ICalcDistance{
    @Override
    public double calcDistance(Point a, Point b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}