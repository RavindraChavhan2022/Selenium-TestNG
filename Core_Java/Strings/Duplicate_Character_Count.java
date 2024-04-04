package Strings;

public class Duplicate_Character_Count {

	public static void main(String[] args) {
		String s = "Ravindra Shivaji Chavhan";
		int[] count = new int[256];
		
		// Convert String into character Array using toCharArray() method
		char[] cA = s.toCharArray();

		// Count occurrences of each character
		for (int i = 0; i < cA.length; i++) {
			count[cA[i]]++;
		}
		System.out.println("Duplicate characters in the String are : ");
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 1) {
				System.out.println((char) i + " = " + count[i]);
			}
		}
	}

}
