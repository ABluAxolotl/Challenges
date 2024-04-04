package QuadraticSolutions;

import java.util.Scanner;

//
public class QuadraticSolutionsV2 {
    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);
        System.out.print("a = ");
        double a = keyb.nextDouble();
        System.out.print("b = ");
        double b = keyb.nextDouble();
        System.out.print("c = ");
        double c = keyb.nextDouble();

        System.out.printf("Equation: (%.3f)x^2 + (%.3f)x + (%.3f)\n", a, b, c);
        if (getSolutionCount(a, b, c) == 1) System.out.println("Has " + getSolutionCount(a, b, c) + " solution.");
        else System.out.println("Has " + getSolutionCount(a, b, c) + " solutions.");

        double[] solutions = getSolutions(a, b, c);

        if (solutions == null) return; //no need to print anything here
        else if (solutions.length == 2) System.out.printf("x = %.2f, %.2f.", solutions[0], solutions[1]);
        else if (solutions.length == 1) System.out.printf("x = %.2f.", solutions[0]);

    }

    public static int getSolutionCount(double a, double b, double c) {
        double discr = getDiscriminant(a, b, c); //Solution count via discriminant
        if (discr > 0) return 2;
        if (discr == 0) return 1;
        return 0;
    }

    public static double[] getSolutions(double a, double b, double c) {
        int solCount = getSolutionCount(a, b, c);
        double[] solutions;

        switch (solCount) { //
            case 1 -> {
                solutions = new double[1];
                solutions[0] = -b / (2 * a);
                return solutions;
            }
            case 2 -> {
                double value = Math.sqrt(getDiscriminant(a, b, c));
                solutions = new double[2];
                solutions[0] = (-b - value) / (2 * a);
                solutions[1] = (-b + value) / (2 * a);
                return solutions;
            }
            default -> {
                return null;
            }
        }
    }

    public static double getDiscriminant(double a, double b, double c) {
        return (b*b) - (4 * a * c);
    }
}
