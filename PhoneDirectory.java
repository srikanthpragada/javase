// Prints name and mobile number from person.txt 
// Name is first entry and mobile is found in the reamining string 

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneDirectory {

	public static String getMobile(String details[]) {
		Pattern mobile = Pattern.compile("\\d+"); // 10 digits
		for (int i = 1; i < details.length ; i ++) {
			Matcher matcher = mobile.matcher(details[i]);
			while(matcher.find())
			{
				 if ( matcher.group().length() == 10)
					 return matcher.group();
			}
		}

		return null;
	}

	public static void main(String[] args) throws Exception {

		Path file = Paths.get("e:\\classroom\\java\\may14\\persons.txt");
		BufferedReader br = Files.newBufferedReader(file);

		TreeMap<String, String> persons = new TreeMap<>();

		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			String parts[] = line.split(",");
			if (parts.length < 2)
				continue;

			String mobileNumber = getMobile(parts);
			if (mobileNumber != null)
				persons.put(parts[0], mobileNumber);
		} // while

		for (String name : persons.keySet()) {
			System.out.printf("%-20s  %s\n", name, persons.get(name));
		}
	}
}

Persons.txt
===========
Tim, tim@apple.com,  9899999988 12-11-60 3838338333
Bill,bill@microsoft.com 11-15-60 7654321123 
Micheal, 3939393332 3343433333
Jeff,jeff@amazon.com 192922222
Larry,2933939333 
Steve

Output
=======
Bill                  7654321123
Larry                 2933939333
Micheal               3939393332
Tim                   9899999988



