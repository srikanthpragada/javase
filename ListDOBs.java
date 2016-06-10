import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.TreeSet;

public class ListDobs {

	public static void main(String[] args) throws Exception {

		TreeMap<String,TreeSet<String>> dobs = new TreeMap<>();
		
		FileReader fr = new FileReader("f:\\classroom\\dob.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		while(line != null) {
		  if ( line.trim().length() > 0)
		  {
			  String [] parts = line.split(",");
			  if ( dobs.containsKey(parts[0]))
			  {
				   TreeSet<String> names = dobs.get(parts[0]);
				   names.add(parts[1]);
			  }
			  else
			  {
				  TreeSet<String> names = new TreeSet<>();
				  names.add(parts[1]);
				  dobs.put( parts[0],names);
			  }
		  }
		  
		  line = br.readLine();
		}
		
		br.close();
		
		// print
		
		for(String date :  dobs.keySet()) {
			
			System.out.println(date);
			for(String name :  dobs.get(date)) {
				System.out.println(name);
			}
		}
		
	}
}

Dobs.txt
========
01-10, Abc
12-12, hij
01-11, Bbc
01-11, Xyz
12-12, cbe
02-15, Def
05-15, Pqr
12-12, Cde

