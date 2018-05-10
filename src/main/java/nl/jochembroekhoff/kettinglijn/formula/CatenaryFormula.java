package nl.jochembroekhoff.kettinglijn.formula;

import nl.jochembroekhoff.kettinglijn.DoublePoint;

public class CatenaryFormula extends Formula {

    private static long APPROX__CYCLES = 1000;
    private static double APPROX__INCREMENT_START = .1;
    private static double APPROX__INCREMENT_MIN = 1e-20;
    private static double APPROX__INCREMENT_MULTIPLIER = 0.8;

    private final double curveRadius;
    /**
     * How far the catenary is shifted to the right on the X-axis.
     */
    private final double offsetX;
    /**
     * How far the catenary is shifted upwards on the Y-axis.
     */
    private final double offsetY;

    public CatenaryFormula(DoublePoint pointA, DoublePoint pointB, double ropeLength) {

        // Approximate the curve radius
        double c = 0.007;
        double increment = APPROX__INCREMENT_START;
        boolean lastTooLow = false;

        // Store the X-coordinates to improve the performance slightly
        double Xa = pointA.getX();
        double Xb = pointB.getX();

        for (long i = 0; i < APPROX__CYCLES; i++) {
            double guessedLength = length(Xa, Xb, c);

            boolean tooLow = guessedLength < ropeLength;
            double howFarOff = Math.abs(ropeLength - guessedLength);

            if (howFarOff < 1 || lastTooLow != tooLow)
                increment *= APPROX__INCREMENT_MULTIPLIER;

            if (increment < APPROX__INCREMENT_MIN)
                increment = APPROX__INCREMENT_MIN;

            c += tooLow
                    ? -increment
                    : increment;

            lastTooLow = tooLow;
        }

        // Store the approximated curve radius
        curveRadius = c;

        // Adjust the X and Y offsets
        offsetX = 0; // TODO: Calculate the correct X-offset
        offsetY = pointA.getY() - calculate(pointA.getX(), curveRadius);
    }

    public static double calculatePrimitiveLineLength(double x, double curveRadius) {
        return curveRadius * Math.sinh(x / curveRadius);
    }

    public static double length(double x1, double x2, double curveRadius) {
        return calculatePrimitiveLineLength(x2, curveRadius) - calculatePrimitiveLineLength(x1, curveRadius);
    }

    public static double calculate(double x, double curveRadius) {
        return curveRadius * Math.cosh(x / curveRadius);
    }

    @Override
    public double calculate(double x) {
        return calculate(x - offsetX, curveRadius) + offsetY;
    }
}
