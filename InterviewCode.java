package demo;

import java.util.Arrays;

public class InterviewCode {

	public static void main(String[] args) {
		String input ="HHEELLOO";
		char[] arr = input.toCharArray();
		int length = arr.length;
		
		for (int i=0;i<length;i++) {
			for (int j=i+1;j<length;j++) {
				if (arr[i]==arr[j]) {	
					System.out.print(arr[i]);
					break;
				}	

			}
		}
	}
}

