package Strings;

public class Find_Duplicate_Characters {

	public static void main(String[] args) {
		
		String s = "Vandemataram";
		int  count; 
		
		char[] str = s.toCharArray();
		System.out.println("Duplicate Characters in " + s + " are : ");
		
		for(int i=0; i<str.length; i++) {
			count = 1;
			for(int j = i+1; j<str.length; j++) {
				if(str[i] == str[j] && str[i] != ' ') {
					count++;
					str[j] = '0';
				}
			}
			if(count > 1 && str[i] != '0')
				System.out.println(str[i]);

		}
		
	}

}
