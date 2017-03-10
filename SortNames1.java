package col;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class LengthCompare implements Comparator<String> 
{
	@Override
	public int compare(String s1, String s2) {
	   return  s1.length() - s2.length();
	}
}

class CaseInsensitveCompare implements Comparator<String> 
{
	@Override
	public int compare(String s1, String s2) {
	   String s1u = s1.toUpperCase();
	   String s2u = s2.toUpperCase();
	   return  s1u.compareTo(s2u);
	}

}

public class SortNames {

	public static void main(String[] args) {

       ArrayList<String> names = new ArrayList<>();
       names.add("Bill Gates");
       names.add("Steve Jobs");
       names.add("Larry Ellison");
       names.add("Larry Page");
       names.add("Elon Musk");
       names.add("Mark Zukerberg");
       names.add("bill gates");
       
       // Case insensitive sorting 
       Collections.sort(names, new CaseInsensitveCompare());
       
       for(String n : names)
    	   System.out.println(n);
       
       // Length based sorting
       Collections.sort(names, new LengthCompare());
       
       for(String n : names)
    	   System.out.println(n);
	}

}
