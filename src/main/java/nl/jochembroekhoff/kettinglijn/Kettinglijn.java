package nl.jochembroekhoff.kettinglijn;

import nl.jochembroekhoff.kettinglijn.formula.CatenaryFormula;
import nl.jochembroekhoff.kettinglijn.formula.SlopeLineFormula;

public class Kettinglijn {

    public static final double STRAIGHT_THRESHOLD = 0.1;

    private final DoublePoint pointA;
    private final DoublePoint pointB;
    private final double ropeLength;
    private final boolean isStraight;
    private final double slopeAToB;

    private SlopeLineFormula slopeLineFormula;
    private CatenaryFormula catenaryFormula;

    /**
     * Point A must be to the left of Point B.
     *
     * @param pointA
     * @param pointB
     * @param ropeLength
     */
    public Kettinglijn(DoublePoint pointA, DoublePoint pointB, double ropeLength) {

        if (pointA.getX() >= pointB.getX())
            throw new IllegalArgumentException("Point A most be to the left of Point B.");

        this.pointA = pointA;
        this.pointB = pointB;
        this.ropeLength = ropeLength;
        this.isStraight = Math.abs(pointA.distanceTo(pointB) - ropeLength) < STRAIGHT_THRESHOLD;
        this.slopeAToB = pointA.slopeTowards(pointB);
    }

    public DoublePoint getPointA() {
        return pointA;
    }

    public DoublePoint getPointB() {
        return pointB;
    }

    public double getRopeLength() {
        return ropeLength;
    }

    public double getSlopeAToB() {
        return slopeAToB;
    }

    public double calculateY(double x) {
        if (isStraight) {
            if (slopeLineFormula == null)
                slopeLineFormula = new SlopeLineFormula(slopeAToB, pointA);

            return slopeLineFormula.calculate(x);
        }

        if (catenaryFormula == null)
            catenaryFormula = new CatenaryFormula(pointA, pointB, ropeLength);

        return catenaryFormula.calculate(x);
    }


}
