package nl.jochembroekhoff.kettinglijn;

public class Main {
    public static void main(String... args) {
        DoublePoint A = new DoublePoint(0, 0);
        DoublePoint B = new DoublePoint(5, 3);
        double ropeLength = 20;

        Kettinglijn line = new Kettinglijn(A, B, ropeLength);

        System.out.println(line.calculateY(5));
    }
}
