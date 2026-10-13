public class VonNeumannCalc implements ICalcDistance {
    @Override
    public double calcDistance(Point a, Point b) {
        return Math.abs(a.getX() - b.getX())
                + Math.abs(a.getY() - b.getY());
    }
}