import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
     	 System.out.print("Enter a string :");
	     String st = s.nextLine();
	
	     for(int i = st.length()-1; i >= 0 ; i --)
	    	 System.out.print( st.charAt(i));
	}

}
