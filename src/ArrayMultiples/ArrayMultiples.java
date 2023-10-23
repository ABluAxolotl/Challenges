package ArrayMultiples;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayMultiples {
    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);
        int number = 1, size = 1;
        boolean reset = false;
        do {
            try {
                reset = false;
                System.out.print("Enter a number to multiply: ");
                number = keyb.nextInt();
                System.out.print("Enter the size of array: ");
                size = keyb.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid number, Insert an integer \n");
                reset = true;
                keyb.nextLine();
            }
        } while(reset);
        System.out.println(Arrays.toString(multiplesArray(number, size)));
    }

    public static int[] multiplesArray(int number, int size) {
        int[] array = new int[size];
        for (int i = 1; i <= size; i++) {
            array[i-1] = number * i;
        }
        return array;
    }

}
