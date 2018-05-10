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

    /**
     * 1: Other point is to the right of this point.<br/>
     * -1: Other point is to the left of this point.<br/>
     * 0: Other point is in line with this point.
     * @param otherPoint
     * @return
     */
    public int compareX(DoublePoint otherPoint) {
        if (otherPoint.x > x)
            return 1;
        if (otherPoint.x < x)
            return -1;
        return 0;
    }

    /**
     * 1: Other point is above this point.<br/>
     * -1: Other point is below this point.<br/>
     * 0: Other point is in line with this point.
     * @param otherPoint
     * @return
     */
    public int compareY(DoublePoint otherPoint){
        if (otherPoint.y > y)
            return 1;
        if (otherPoint.y < y)
            return -1;
        return 0;
    }
}