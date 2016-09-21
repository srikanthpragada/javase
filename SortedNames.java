import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeSet;

public class SortedNames {

	public static void main(String[] args) throws Exception {
		 
		FileReader fr  = new FileReader("c:\\jdk8\\aug9\\names.txt");
		BufferedReader br = new BufferedReader(fr);
		
		TreeSet<String> names = new TreeSet<>();
		
		while(true) {
			String line = br.readLine();
			if ( line == null)
				 break;
			String [] parts = line.split(" ");
			for(String s : parts)
			{
				if(s.length() > 0)
				   names.add(s);
			}
		}
		
		// print names
		for(String n : names)
			System.out.printf("\n%s %d",n, n.length());
		
	}

}


c:\jdk8\aug9\names.txt
======================
Scott
Gavin   Rod
Jhonson   Jason
Resig   Greg
Scott Guthrie
Rod Jhonson











