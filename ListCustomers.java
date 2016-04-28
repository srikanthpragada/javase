import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;

public class ListCustomers {

	public static void main(String[] args) throws Exception {

		 FileReader fr = new FileReader("f:\\classroom\\customer_emails.txt");
		 BufferedReader br = new BufferedReader(fr);
		 
		 String line = br.readLine();
		 
		 TreeMap<String,String>  customers =new TreeMap<>();
		 
		 while (line!=null) {
			 String [] parts = line.split(",");
			 if ( parts.length == 2)
			      customers.put( parts[0], parts[1]);
			 line = br.readLine(); 
		 }
		 
		 fr.close();
		 
		 for(String name : customers.keySet()) {
			 System.out.println( name + " - " + customers.get(name));
		 }

	}

}
