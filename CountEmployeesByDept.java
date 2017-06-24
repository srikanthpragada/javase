import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class CountEmployees {

	public static void main(String[] args) throws Exception {
	 
		 Path path = Paths.get("f:\\classroom\\emp.txt");
		 List<String> lines  = Files.readAllLines(path);
		 
		 LinkedHashMap<String, Integer> depts = new LinkedHashMap<>();
		 
		 for(String line : lines) {
		       String [] parts = line.split(",");
		       
		       if(parts.length < 2)
		    	   continue;
		       
		       String dept  = parts[1];
		       String employee = parts[0];
		       
		       // check whether dept is present 
		       if ( depts.containsKey(dept))
		    	    depts.put(dept,  depts.get(dept) + 1);
		       else
		    	    depts.put(dept,1);
		 }
		 
		 for(String dept : depts.keySet())
		 {
			 System.out.printf("%-10s  %3d\n", dept, depts.get(dept));
		 }
	}
}

employees.txt
=============
Bill, IT
Andy, Sales
Joe, IT
Scott, Finance
Tim, IT
John, Sales
Roberts, Finance
Ben, IT
