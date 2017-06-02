import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class ListLinesCount {

	static class ProcessFile extends SimpleFileVisitor<Path> {
		@Override
		public FileVisitResult visitFile(Path path, BasicFileAttributes arg1) throws IOException {
			if (path.toString().endsWith(".java"))
   	 		    printFile(path.toString());
			return FileVisitResult.CONTINUE;
		}
	}
	
	public static void printFile(String path) {
	
		try (FileReader fr = new FileReader(path);
			 BufferedReader lnr = new BufferedReader(fr))
		{
			int count = 0;
			while(true) {
				String line = lnr.readLine();
				if ( line == null)
					 break;
				count ++;
			}
			System.out.printf("%-60s %4d\n",path,count);
		}
		catch(Exception ex) {
			ex.printStackTrace(System.out);
		}
	}

	public static void main(String[] args) throws Exception {

       String pathString  = "F:\\classroom\\may12se\\demo\\src";
       Path  folder = Paths.get(pathString);
       Files.walkFileTree(folder, new ProcessFile());

	}

}
