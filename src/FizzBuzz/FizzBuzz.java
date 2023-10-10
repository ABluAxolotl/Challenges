package FizzBuzz;
import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);
        System.out.print("Enter integer n: ");

        Object[] array = fizzBuzz(keyb.nextInt());
        printArray(array);
    }
    public static Object[] fizzBuzz(int n) {
        Object[] objects = new Object[n];

        for(int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                objects[i-1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                objects[i-1] = "Fizz";
            } else if (i % 5 == 0) {
                objects[i-1] = "Buzz";
            } else {
                objects[i-1] = i;
            }
        }

        return objects;
    }

    public static void printArray(Object[] array) {
        System.out.print("\n[");
        for (int i = 0; i < array.length-1; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length-1] + "]");
    }
}
