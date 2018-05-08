package nl.jochembroekhoff.kettinglijn.formula;

import nl.jochembroekhoff.kettinglijn.DoublePoint;

public class CatenaryFormula extends Formula {

    public static long APPROXIMATION_CYCLES = 10;

    private final double curveRadius;

    public CatenaryFormula(double curveRadius) {
        this.curveRadius = curveRadius;
    }

    public CatenaryFormula(DoublePoint pointA, DoublePoint pointB, double ropeLength) {
        this(0);

        // Approximate the curve radius
        double c = 0.1;
        double lowerGuessLength = Double.MIN_VALUE;
        double upperGuessLength = Double.MAX_VALUE;

        // If length increases, c increases as well

        for (long i = 0; i < APPROXIMATION_CYCLES; i++) {

        }
    }


    public static double calculate(double x, double curveRadius) {
        /*

        a: curveRadius

        y = a * cosh ( x / a )

        OR

        y = ( a / 2 ) * ( exp (x / a) + exp (-x / a) )

         */
        return curveRadius * Math.cosh(x / curveRadius);
    }

    public double calculate(double x) {
        return calculate(x, curveRadius);
    }
}
