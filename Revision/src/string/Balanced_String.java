package string;

import java.util.Stack;

public class Balanced_String {

	public static void main(String[] args) {
		String str = "<{([{}])}>";
		Stack<Character> st = new Stack<>();
		/*for(int i=0; i<str.length(); i++) { 
		    char ch = str.charAt(i); */
		// OR using For each Loop
		for (char c : str.toCharArray()) {
			if (st.empty()) {
				st.push(c);
			} else if (c=='[' || c=='(' || c=='{' || c=='<') {
				st.push(c);
			} else if (c == ']' && st.peek() == '[') {
				st.pop();
			} else if (c == '}' && st.peek() == '{') {
				st.pop();
			} else if (c == ')' && st.peek() == '(') {
				st.pop();
			}else if (c == '>' && st.peek() == '<') {
				st.pop();
			}
		}
		if (st.empty()) {
			System.out.println("Given String is Balanced");
		} else {
			System.out.println("Given String is not Balanced");
		}
	}
}
