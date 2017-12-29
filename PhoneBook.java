// Displays name and phone numbers of the person 
// Takes data from PHONES.TXT 

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.TreeMap;

public class PhoneBook {

	public static void main(String[] args) throws Exception {

         Path path = Paths.get("f:\\classroom\\nov20\\phones.txt");
         BufferedReader br = Files.newBufferedReader(path);
         TreeMap<String, LinkedHashSet<String> > phones = new TreeMap<>();
         
         while(true) {
        	 String line = br.readLine();
        	 if ( line == null)
        		 break;
        	 String parts[] = line.split(",");
        	 if (parts.length > 1)
        	 {
        		 String name = parts[1];
        		 String phone = parts[0];
        		 // check whether name is already present
        		 if (phones.containsKey(name)) {
        			 // add new number to existing list 
        			 LinkedHashSet<String> numbers =  phones.get(name);
        			 numbers.add(phone);
        		 }
        		 else
        		 {
        			 // new name so add it to treemap
        			 LinkedHashSet<String> numbers = new LinkedHashSet<>();
        			 numbers.add(phone);
        			 phones.put(name, numbers);
        		 }
        	 }
         } // while
         br.close();
         
         for( String name  : phones.keySet()) {
        	 String phoneNumbers = String.join(",", phones.get(name));  // join all phones with , as separator 
        	 System.out.printf("%-15s  %s\n",name, phoneNumbers);
         }
	}
}

------------------------------------------------
phones.txt
===========
9899998899,Larry
3933343333,Adam
9898989898,Steve
9333333333,Mike
9334343221,Mike
1234567890,Adam
3838383833,Adam
1234567890,Adam


Ouput of the program
=====================
Adam             3933343333,1234567890,3838383833
Larry            9899998899
Mike             9333333333,9334343221
Steve            9898989898
