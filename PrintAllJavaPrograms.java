import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintAllJavaPrograms {

	private static String PATH = "f:\\classroom\\apr1\\apr1demo";

	public static void main(String[] args) throws Exception {
		Path dir = Paths.get(PATH);
		Files.walk(dir).filter(p -> p.toString().endsWith(".java"))
		               .forEach(PrintJavaPrograms::print);
	}

	public static void print(Path p) {
		System.out.println(p.toString());
		System.out.println("======================================");
		
		try {
			Files.lines(p).forEach(System.out::println);
		} catch (Exception ex) {

		}
	}

}
