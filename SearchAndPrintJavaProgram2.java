import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchAndPrintJavaProgram2 {

	static String searchFile = "hello.java";
	static boolean found = false; 

	public static void main(String[] args) throws Exception {
		String path = "c:\\jdk8\\may6e";

		Path folder = Paths.get(path);
		Files.walk(folder)
		.filter( p -> p.toString().toLowerCase().endsWith(searchFile))
		.forEach( p -> printFile(p));
	}

	
	public static void printFile(Path file) {
			try {
				Files.lines(file)
				  .forEach(System.out::println);
			} catch (Exception ex) {
				System.out.println(ex);
			}
	}

}
