package QuadraticSolutions;

import java.util.Arrays;
import java.util.Scanner;

public class QuadraticSolutions {
    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);

        System.out.print("a = ");
        double a = keyb.nextDouble();
        System.out.print("b = ");
        double b = keyb.nextDouble();
        System.out.print("c = ");
        double c = keyb.nextDouble();

        System.out.println("For the quadratic: (" + a + ")x^2 + (" + b + ")x + (" + c + "), there are " + getQuadraticSolutions(a, b, c) + " solutions.");
        System.out.println("x = " + Arrays.toString(getXs(a, b, c)));

    }

    public static int getQuadraticSolutions(double a, double b, double c) {
        double result = (b * b) - (4 * a * c);
        if (result > 0) return 2;
        if (result == 0) return 1;
        return 0;
    }

    public static double[] getXs(double a, double b, double c) {
        double value = Math.sqrt((b * b) - (4 * a * c));
        double[] xs = new double[1];

        if (getQuadraticSolutions(a, b, c) == 0) return null;
        if (getQuadraticSolutions(a, b, c) == 1) {
            xs = new double[1];
            xs[0] = -b / (2 * a);
        }
        else if(getQuadraticSolutions(a, b, c) == 2) {
            xs = new double[2];
            xs[0] = (-b + value) / (2 * a);
            xs[1] = (-b - value) / (2 * a);
        }

        return xs;
    }
}
