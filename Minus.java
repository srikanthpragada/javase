import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashSet;

public class Minus {

	public static void main(String[] args) throws Exception  {
		FileReader fr = new FileReader("f:\\classroom\\lines1.txt");
		BufferedReader br = new BufferedReader(fr);
		
		// copy all lines from first file into set 
		LinkedHashSet<String> lines = new LinkedHashSet<>();
		String line = br.readLine(); 
		while (line!=null) {
		      lines.add(line);
		      line = br.readLine();
		}
		 
		fr.close();
		
		fr = new FileReader("f:\\classroom\\lines2.txt");
		br = new BufferedReader(fr);
		line = br.readLine(); 
		while (line!=null) {
			  // if line is present in first file then remove 
		      if (lines.contains(line))
		    	     lines.remove(line); 
		      line = br.readLine();
		}
		
		fr.close();
		
		for(String l : lines)
			System.out.println(l);

	}

}
