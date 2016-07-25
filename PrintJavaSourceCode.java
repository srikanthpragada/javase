import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintJavaSourceCode {

	public static void main(String[] args) throws Exception {

		Path folder = Paths.get("c:\\jdk8\\june20");
		Files.walkFileTree(folder, new ProcessFile());

	}

	static class ProcessFile extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult visitFile(Path path, BasicFileAttributes arg1) throws IOException {
			if (path.toString().endsWith(".java")) {
				printFile(path);
			}
			return FileVisitResult.CONTINUE;
		}

		public void printFile(Path path) {
			System.out.println("*********** " + path.toString() + " ***************");

			try (FileReader fr = new FileReader(path.toString()); BufferedReader br = new BufferedReader(fr)) {
				int count = 1;
				String line;
				while (true) {
					line = br.readLine();
					if (line == null)
						break;
					System.out.printf("%4d: %s\n", count, line);
					count++;
				}
			} catch (Exception ex) {

			}
		}

	}
}
