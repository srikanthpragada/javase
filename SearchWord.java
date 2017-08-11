import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SearchFolder {

	public static void main(String[] args) {

		String folder = "c:\\jdk8";
		String pattern = "Scanner";

		File dir = new File(folder);

		for (File file : dir.listFiles()) {
			if (file.getName().endsWith(".java"))
			{
				if ( containsPattern(file, pattern) )
					System.out.println(file);
			}
		}

	}

	public static boolean containsPattern(File file, String pattern) {
		try(FileReader fr = new FileReader(file);
   		    BufferedReader br = new BufferedReader(fr))
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
