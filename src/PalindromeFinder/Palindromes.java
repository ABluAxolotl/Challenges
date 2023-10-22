package PalindromeFinder;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class Palindromes {
	public static void main(String[] args) {
		Scanner keyb = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = keyb.nextLine().toLowerCase();
		if (isPalindrome(word)) System.out.println("Yes, \"" + word + "\" is a palindrome");
		else System.out.println("No, \"" + word + "\" is not a palindrome");
	}
	public static boolean isPalindrome(String word) {
		Deque<Character> queue = new LinkedList<>();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == '.' || word.charAt(i) == ' ') continue;
			queue.add(word.charAt(i));
		}
		while (queue.size() > 1) {
			if (!(queue.removeFirst().equals(queue.removeLast()))) return false;
		}
		return true;
	}
}