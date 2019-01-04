// Add mobile numbers by splitting lines and checking for validity 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListMobiles {
	public static void addNumbers(TreeSet<String> mobiles, String line) {
		String parts[] = line.split("\\W+");
		for (String w : parts) {
			if (Pattern.matches("^\\d{10}$", w))
				mobiles.add(w);
		}
	}

	public static void main(String[] args) throws Exception {
		Path file = Paths.get("e:\\classroom\\java\\mobiles.txt");
		TreeSet<String> mobiles = new TreeSet<>();

		Files.lines(file) // Stream<String>
				.filter(line -> line.length() >= 10).forEach(line -> addNumbers(mobiles, line)); 
																									
		mobiles.forEach(System.out::println);
	}
}
