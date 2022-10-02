package baseHook;

public class StringProgramAddInteger {

	public static void main(String[] args) {
       String str="23abcd@@@1234";
        int sum =0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
            	int a = ch - '0';
            	sum=sum+ a;
                
            }

        }
 
      System.out.println(sum);

	}

}
