package VigenereCypher;

public class VigenereCypherManipulator {

    public static String vEncrypt(String word, String key) {
        word = word.toUpperCase();
        key = key.toUpperCase();
        int[] wordArray = stringToIntArray(word);
        int[] keyArray = stringToIntArray(key, wordArray.length);

        int[] encryptedArray = new int[wordArray.length];

        wordArray = addValueToArray(wordArray, -65);
        keyArray = addValueToArray(keyArray, -65);

        for (int i = 0; i < encryptedArray.length; i++) {
            encryptedArray[i] = wordArray[i] + keyArray[i];
            if (encryptedArray[i] >= 26) {
                encryptedArray[i] = encryptedArray[i] % 26;
            }
        }

        encryptedArray = addValueToArray(encryptedArray, 65);

        return intArrayToString(encryptedArray);
    }

    public static String vDecrypt(String word, String key) {
        word = word.toUpperCase();
        key = key.toUpperCase();
        int[] wordArray = stringToIntArray(word);
        int[] keyArray = stringToIntArray(key, wordArray.length);

        int[] decryptedArray = new int[wordArray.length];

        wordArray = addValueToArray(wordArray, -65);
        keyArray = addValueToArray(keyArray, -65);

        for (int i = 0; i < decryptedArray.length; i++) {
            decryptedArray[i] = wordArray[i] - keyArray[i];
            if (decryptedArray[i] < 0) {
                decryptedArray[i] += 26;
            }
        }

        decryptedArray = addValueToArray(decryptedArray, 65);

        return intArrayToString(decryptedArray);
    }

    public static int[] stringToIntArray(String word) {
        int[] array = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') continue;
            int asciiCode = word.charAt(i);
            array[i] = asciiCode;
        }

        return array;
    }

    public static int[] stringToIntArray(String word, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int asciiCode = word.charAt(i % word.length());
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

    public static int[] addValueToArray(int[] array, int value) {
        int[] out = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            out[i] = array[i] + value;
        }
        return out;
    }
}
