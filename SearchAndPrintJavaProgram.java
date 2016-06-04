import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchAndPrintJavaProgram {

	static String searchFile = "HELLO.JAVA";
	static boolean found = false; 

	public static void main(String[] args) throws Exception {
		String path = "c:\\jdk8\\may6e";

		Path folder = Paths.get(path);
		Files.walkFileTree(folder, new HandleFile());
		if (!found)
			System.out.printf("Sorry! [%s] not found in folder [%s]\n", searchFile, path);
			
	}

	// nested class
	static class HandleFile extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
			if (file.toString().toUpperCase().endsWith(searchFile)) {
				printFile(file);
				found = true; 
				return  FileVisitResult.TERMINATE;
			}

			return FileVisitResult.CONTINUE;
		}

		public void printFile(Path file) {
			try {
				Object [] lines = Files.lines(file).toArray();
				int lineno=1;
				for(Object line : lines) {
					System.out.printf("%4d: %s\n",lineno,line);
					lineno ++;
				}

			} catch (Exception ex) {
				System.out.println(ex);
			}

		}

	}

}
