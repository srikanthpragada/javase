// Display how many times each char in string occurs 
import java.util.LinkedHashMap;

public class CharFequency {

	public static void main(String[] args) {
		 String st = "This is to test how well you write a program!";
		 var frequency = new LinkedHashMap<Character,Integer>();
		 for (int i = 0; i < st.length(); i ++)
		 {
			 char ch = st.charAt(i);
			 if (frequency.containsKey(ch))
				 frequency.put(ch, frequency.get(ch) + 1);
			 else
				 frequency.put(ch,1);
	     }
		 
		 for(char ch : frequency.keySet())
			 System.out.printf("%c - %d\n", ch, frequency.get(ch));
	}
}
