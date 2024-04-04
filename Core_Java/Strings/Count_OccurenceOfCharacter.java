package Strings;

public class Count_OccurenceOfCharacter {

	public static void main(String[] args) {
		String s = "Java Programming for Automation";
		
		//Converting to Lower case
		System.out.println("String in Lower case : " + s.toLowerCase());
		
		String s1 = s.toLowerCase();
		
		int totalCharacters = s1.length();
		
		//Remove character a from a String
		 int characters_removing_a = s1.replace("a", "").length();
		 
		 int count = totalCharacters - characters_removing_a;
		 System.out.println("Number of occurences of a is : " + count);
	}

}
