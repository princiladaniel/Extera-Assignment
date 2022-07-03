package week4.day1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class InterviewQuestionCalm {

	public static void main(String[] args) {
         //input=calm
		//output=caalllmmmm
		String input="calm";
		String output = "";
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			
			for (int j = 0; j < i+1; j++) {
		
				output=output+charArray[i];			 
			}	
		}
		
		System.out.println(output);
	}
}
