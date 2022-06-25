package demo;

import java.util.Arrays;
import java.util.List;

public class FindOccuranceUsingOneLoop {

	public static void main(String[] args) {
		/*  input=welcome to chennai
to chararray
sort
for()
if(arr[i]==i+1){
count=count++;
else{
syso(arr[i]+count

count=1;
} */
		String input="welcome to chennai";
		int count=1;
		char[] charArray = input.toCharArray();
		
		Arrays.sort(charArray);
		
		for (int i = 0; i <charArray.length; i++) {
			if(charArray.length==i+1) {
				System.out.println("occurance: "+ charArray[i]+count);
				break;
			}
			if(charArray[i]==charArray[i+1]) {
				count++;	
			}
			else {
				System.out.println("occurance: "+ charArray[i]+" "+count);
				count=1;
			}
			
		}
		
	}

}
