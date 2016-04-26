import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchJavaPrograms {

	private static String  PATH = "f:\\classroom\\apr1\\apr1demo"; 
	
	public static void main(String[] args) throws Exception {
	  
		Path  dir = Paths.get(PATH);
		Files.walkFileTree(dir, new ProcessFile() );
	}
	
	public static boolean isFound(Path path, String pattern) {
	
		try (BufferedReader br = Files.newBufferedReader(path))
		{
			String line = br.readLine();
			while( line!= null) {
				if (line.contains(pattern))
					return true;
				
				line =br.readLine();
			}
			
			return false; 
		}
		catch(Exception ex) {
			System.out.println(ex);
			return false; 
		}
	}

	
	static  class ProcessFile extends SimpleFileVisitor<Path> {
		@Override
		public FileVisitResult visitFile(Path path, BasicFileAttributes arg1) throws IOException {
			if ( path.toString().endsWith(".java"))
			{
               if (isFound(path, "int"))
				    System.out.println(path);
                  
			}
			
			return FileVisitResult.CONTINUE;
		}
	 
		
	}

}
