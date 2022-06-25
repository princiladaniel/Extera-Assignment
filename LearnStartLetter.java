package demo;

public class LearnStartLetter {

	public static void main(String[] args) {
		//1. String - "testleaf" - Print the number of e in the string e=2
		/*
		 * String name="testleafee"; int count=0; char[] chArray = name.toCharArray();
		 * for (int i = 0; i < chArray.length; i++) { if(chArray[i]=='e') { count++;
		 * 
		 * }
		 * 
		 * } System.out.println(count);
		 */
		
		
		//2. String - "Testleaf is situated in twin towers teynampet"
				//print the words that starts 't' or 'T'
		String input="Testleaf is situated in twin towers teynampet";
		String[] split = input.split(" ");
		for (int i = 0; i < split.length; i++) {
			if(split[i].startsWith("T")||split[i].startsWith("t")){
				System.out.println(split[i]);
				
			}
			
		}
		

	}

}
