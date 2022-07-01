package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterviewThis {
	int a=100;
	public void sum(int a) {
		this.a=a*10;
		System.out.println(a);
		
	}
	public static void main(String[] args) {
		InterviewThis x=new InterviewThis();
		x.sum(5);
		System.out.println(x.a);
	}
	
}