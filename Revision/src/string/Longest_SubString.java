package string;

import java.util.HashSet;
import java.util.Set;

public class Longest_SubString {

	public static void main(String[] args) {
		String str = "abcdebbccdde";
		// Why HashSet ? Because Set don't allow duplicates
		Set<Character> set = new HashSet<>();
		// Take two empty Strings to store and compare Characters
		String longestOverall = "";
		String longesttillNow = "";
		
		for (char c : str.toCharArray()) {
			if (set.contains(c)) {
				longesttillNow = "";
				set.clear();
			}
			set.add(c);
			longesttillNow = longesttillNow + c; // OR longesttillNow += c

			if (longesttillNow.length() > longestOverall.length()) {
				longestOverall = longesttillNow;
			}
		}
		System.out.println("Longest SubString without repetition of character is : " + longestOverall);
	}
}
