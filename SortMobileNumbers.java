import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class SortMobilePhones {
	public static void main(String[] args) throws Exception {
		TreeSet<String> numbers = new TreeSet<>();
		Path p = Paths.get("f:\\classroom\\mobile_numbers.txt");
		Files.lines(p)
		     .forEach( line -> process(numbers,line));
		numbers.forEach(System.out::println);
	}
	
	public static void process(TreeSet<String> numbers, String line) {
		String [] parts = line.split("[ ,;:]");
		
		for(String part : parts)
		{
			if ( Pattern.matches("^\\d{10}$", part))  // valid mobile number
				     numbers.add(part);
		}
	}
}


mobile_numbers.txt
===================
8338338383,3939393
3838383333,393939393393
3938943433,3333333333:8877665544 9303333333
3343443433;3434333333
abcabcabcd
3838383838

output
=======
3333333333
3343443433
3434333333
3838383333
3838383838
3938943433
8338338383
8877665544
9303333333



