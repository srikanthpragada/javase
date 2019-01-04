// Uses streams, files, RE and collections to take mobile numbers from a file and display them in sorted order 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ListMobiles {
	
	public static void addNumbers(TreeSet<String> mobiles, String line)
	{
		Pattern p = Pattern.compile("\\d{10}");
		Matcher m = p.matcher(line);
		while(m.find())
		{
			mobiles.add(m.group());
		}
	}
	public static void main(String[] args)  throws Exception {
		 Path file = Paths.get("e:\\classroom\\java\\mobiles.txt");
		 TreeSet<String> mobiles = new TreeSet<>();
		 
		 Files.lines(file)   //  Stream<String>
		  .filter(line -> line.length() >= 10)
		  .forEach(line -> addNumbers(mobiles,line)); // Consumer - void accept(T)
		 
		 mobiles.forEach(System.out::println);
	}
}

mobiles.txt
===========
Abc  3939339393  3939411323
9894491222  PQR 9894491111
8723772923,8382383833
Bill
Larry 39399393993


Output
=======
3939339393
3939411323
3939939399
8382383833
8723772923
9894491111
9894491222

