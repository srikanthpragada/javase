package col;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class PhoneBook2 {

	public static void main(String[] args) throws Exception {

        TreeMap<String,LinkedHashSet<String>> phones = new TreeMap<>();
        BufferedReader br = Files.newBufferedReader( Paths.get("f:\\classroom\\nov28\\phones.txt"));
        
        while(true) {
        	String line = br.readLine();
        	if ( line == null)
        		 break;
        	
        	String parts [] = line.split(",");
        	if (parts.length < 2)
        		continue;
        	
        	String name = parts[0].trim();
        	String number = parts[1].trim();
        	
        	if (! Pattern.matches("[A-Za-z ]+", name))
        		continue;
        	
        	if (! Pattern.matches("[0-9-]+", number))
        		continue; 
        		
        	// check whether name is present
        	
        	if (phones.containsKey(name))
        	{
        		phones.get(name).add(number);  // add number to existing set 
        	}
        	else
        	{
        		LinkedHashSet<String> numbers = new LinkedHashSet<>();
        		numbers.add(number);
        		phones.put(name, numbers); // add new entry 
        	}
        		
        }
        br.close();
        
        for(String name : phones.keySet())
        {
        	String numbers = String.join(",", phones.get(name));
        	System.out.printf("%-10s  %s\n", name, numbers);
        }
	}
}

Phones.txt
==========
Scott,9898989898
Jason,9282818181
Steve,9383833333
Bill, 9343433333
Joe,  9282818777
James,9392882222 
Joe,  3493943949
Joe,  3493943949
Steve,1828381111
Gates,303-39393-333
Abc, 39dsjsdaljfs
Herbert,    
Larry
Andy, 3939393933
Andy, 3939393333
Andy, 3939393123

Output
======
Andy        3939393933,3939393333,3939393123
Bill        9343433333
Gates       303-39393-333
James       9392882222
Jason       9282818181
Joe         9282818777,3493943949
Scott       9898989898
Steve       9383833333,1828381111

