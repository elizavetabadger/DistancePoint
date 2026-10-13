public class MooreMethodCalc implements  ICalcDistance{
    @Override
    public double calcDistance(Point a, Point b) {
        double dx = Math.abs(a.getX() - b.getX());
        double dy = Math.abs(a.getY() - b.getY());
        return Math.max(dx, dy);
    }
}