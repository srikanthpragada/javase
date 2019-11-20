import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.List;
 
public class SymmetricDifference {

	public static void main(String[] args) throws Exception {
		List<String> names1 = Files.readAllLines(Paths.get("e:\\classroom\\java\\oct4\\names1.txt"));
		List<String> names2 = Files.readAllLines(Paths.get("e:\\classroom\\java\\oct4\\names2.txt"));
		LinkedHashSet<String> names = new LinkedHashSet<>(names1);
		LinkedHashSet<String> common = new LinkedHashSet<>();

		for (String n : names2) {
			if (names.contains(n))
				common.add(n);
			else
				names.add(n);
		}
		
  	names.removeAll(common);
		
		System.out.println("Symmetric Difference");
		
		for(String n : names)
			System.out.println(n);

	}
}


names1.txt
==========
Tom
Bill
Joe
James

names2.txt
==========
Joe
Steve
Bill
Andy
