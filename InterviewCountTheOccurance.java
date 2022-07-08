package collectioncode;



public class InterviewCountTheOccurance {

	public static void main(String[] args) {
		String input = "aaabbbcccdddeef";
		
		int count=1;
		
		for (int i = 0; i <input.length(); i++) {
			if(input.length() == i+1) {
				System.out.println("occurance: "+ input.charAt(i)+" "+count);
				break;
			}
			if(input.charAt(i)==input.charAt(i+1)) {
				count++;
			
			}
			
			else {
				System.out.println("occurance: "+ input.charAt(i)+" "+count);
				count=1;
			}
			
		}
		
	}
	}


