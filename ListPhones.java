import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;

public class ListPhones {
	 public static void main(String args[]) throws Exception {
	 
		 FileReader fr =new FileReader("f:\\classroom\\phones.txt");
		 BufferedReader br = new BufferedReader(fr);
		 TreeMap<String,String> phones = new TreeMap<>();
		 
		 String line = br.readLine();
		 while(line!= null) 
		 {
		    String parts [] = line.split(":");
		    if (parts.length >= 2 )
		        phones.put( parts[0], parts[1]);
		    
			line = br.readLine();
		 }
		 br.close();
		 fr.close();
		 
		 for(String name : phones.keySet()) {
			 System.out.println( name  + " " + phones.get(name) );
		 }
		 
			 
		 
	 }
}
