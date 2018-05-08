package nl.jochembroekhoff.kettinglijn;

public class Main {
    public static void main(String... args) {
        DoublePoint A = new DoublePoint(0, 0);
        DoublePoint B = new DoublePoint(3, 4);
        double ropeLength = 5;
        //According to the 3-4-5 rule, the rope is just long enough

        Kettinglijn line = new Kettinglijn(A, B, ropeLength);

        System.out.println(line.calculateY(3));
    }
}
