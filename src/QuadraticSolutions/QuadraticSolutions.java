package QuadraticSolutions;

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

    }

    public static int getQuadraticSolutions(double a, double b, double c) {
        double result = (b * b) - (4 * a * c);
        if (result > 0) return 2;
        if (result == 0) return 1;
        return 0;
    }
}
