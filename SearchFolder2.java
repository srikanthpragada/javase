import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchFolder2 {
	static String folder = "c:\\jdk8";
	static String pattern = "Date";
	static String extension = ".java";
	
	public static class ProcessFile extends SimpleFileVisitor<Path> {
		@Override
		public FileVisitResult visitFile(Path path, BasicFileAttributes arg1) throws IOException {
			if (path.toString().endsWith(extension)) {
			     if( containsPattern(path, pattern))
			    	 System.out.println(path);
			}
			return FileVisitResult.CONTINUE;
		}
	
	}

	public static void main(String[] args) throws Exception {
		if ( args.length > 0 )
		{
			folder = args[0];  // first parameter 
		}
		
		if ( args.length > 1 )
		{
			pattern = args[1];  // second parameter 
		}
		
		if ( args.length > 2 )
		{
			extension  = args[2];  // Third  parameter 
		}
		
		Path dir = Paths.get(folder);
		Files.walkFileTree(dir, new ProcessFile());

	}

	public static boolean containsPattern(Path path, String pattern) {
		try(BufferedReader br =  Files.newBufferedReader(path))
		{
			while(true) {
				String line = br.readLine();
				if ( line == null)
					break;
				
				if (line.contains(pattern))
				{
					return true; 
				}
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return false; 
	}

}
