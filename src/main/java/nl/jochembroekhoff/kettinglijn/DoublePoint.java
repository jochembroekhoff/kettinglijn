package nl.jochembroekhoff.kettinglijn;

public class DoublePoint {
    private double x;
    private double y;

    public DoublePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double distanceTo(DoublePoint otherPoint) {
        return Math.sqrt(Math.pow(otherPoint.x - x, 2) + Math.pow(otherPoint.y - y, 2));
    }

    public double slopeTowards(DoublePoint otherPoint) {
        return (otherPoint.y - y) / (otherPoint.x - x);
    }
}