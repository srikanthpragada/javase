import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.TreeSet;

public class ListDOBAndNames {

	public static void main(String[] args)  throws Exception {
    
		FileReader fr = new FileReader("f:\\classroom\\dobs.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		
		TreeMap<String, TreeSet<String>> dobs = new TreeMap<>();
		while ( line!= null) {
			String [] parts = line.split(",");
			
			if (parts.length == 2) {
				// look for dob in dobs
				TreeSet<String> names = dobs.get(parts[1]);
				if ( names != null)
					 names.add(parts[0]);
				else
				{
					names = new TreeSet<String>();
					names.add(parts[0]);
					dobs.put(parts[1],names);
				}
			}
			
			line = br.readLine();
		}
		
		fr.close();
		
		for(String dob :  dobs.keySet()) {
			System.out.print(dob + ":" );
			StringBuffer sb = new StringBuffer();
			for (String name : dobs.get(dob))
			{
				sb.append(name + ",");
			}
			sb.setCharAt(sb.length()-1, ' ');  // remove extra , at the end 
		  System.out.println(sb);
		}

	}
}
