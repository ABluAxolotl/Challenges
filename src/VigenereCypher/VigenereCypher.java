package VigenereCypher;

import java.lang.reflect.Array;
import java.util.Arrays;

public class VigenereCypher {
    /*
        To encrypt easily we can turn a string into a number array                       x
        ask if the keywords are case-sensitive
        add the value of the keyword code to the plaintext (loop any overlap) to encrypt
        subtract the value of the keyword code to the encrypted text to decrypt
        return int array to characters and print it out                                  x
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(stringToIntArray("test")));
        System.out.println(intArrayToString(stringToIntArray("test")));
    }

    public static int[] stringToIntArray(String word) {
        int[] array = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            int asciiCode = word.charAt(i);
            array[i] = asciiCode;
        }

        return array;
    }

    public static String intArrayToString(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i : array) {
            builder.append((char) i);
        }
        return builder.toString();
    }
}
