package nl.jochembroekhoff.kettinglijn.formula;

import nl.jochembroekhoff.kettinglijn.DoublePoint;

public class SlopeLineFormula extends Formula {

    private final double slope;
    private final double offsetY;

    public SlopeLineFormula(double slope, DoublePoint somePoint) {
        this.slope = slope;

        // Calculate the Y-offset (y = ax + b) where `b` is the Y-offset
        this.offsetY = somePoint.getY() - this.slope * somePoint.getX();
    }

    @Override
    public double calculate(double x) {
        return slope * x + offsetY;
    }
}
