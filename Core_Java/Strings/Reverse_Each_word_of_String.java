package Strings;

public class Reverse_Each_word_of_String {

	public static void main(String[] args) {
		String s = "Welcome to Java Automation";
		String[] words = s.split(" ");

		String reverse = "";

		for (String w : words) {
			String rvsword = "";
			for (int i = w.length() - 1; i>=0; i--) {
				rvsword += w.charAt(i);
			}
			reverse += rvsword + " ";
		}

		System.out.println(reverse);
	}
}
