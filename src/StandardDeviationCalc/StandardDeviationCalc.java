package StandardDeviationCalc;

import java.util.Scanner;

public class StandardDeviationCalc {
    public static void main(String[] args) {
        double[] data;
        Scanner keyb = new Scanner(System.in);

        System.out.print("How many datapoints: ");
        data = new double[keyb.nextInt()];

        for (int i = 0; i < data.length; i++) {
            System.out.print("Enter data value " + (i + 1) + ": ");
            data[i] = keyb.nextDouble();
        }

        double sd = calcSD(data);

        System.out.printf("The standard deviation is: %.3f.\n", sd);
    }

    public static double calcSD(double[] data) {
        double avg = 0;

        //Get Average
        for (int i = 0; i < data.length; i++) {
            avg += data[i];
        }
        avg /= data.length;

        //Get numerator
        double SDnum = 0;
        for (int i = 0; i < data.length; i++) {
            SDnum += (data[i] - avg) * (data[i] - avg);
        }

        //Get dev
        double sd = SDnum / (double) (data.length - 1);
        sd = Math.sqrt(sd);
        return sd;
    }


}