import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class ListEmployees {
	public static void main(String[] args) throws Exception {
 
		 Path path = Paths.get("f:\\classroom\\emp.txt");
		 List<String> lines  = Files.readAllLines(path);
		 
		 LinkedHashMap<String, LinkedHashSet<String>> depts = new LinkedHashMap<>();
		 
		 for(String line : lines) {
		       String [] parts = line.split(",");
		       
		       if(parts.length < 2)
		    	   continue;
		       
		       String dept  = parts[1];
		       String employee = parts[0];
		       
		       // check whether dept is present 
		       if ( depts.containsKey(dept))
		    	    depts.get(dept).add(employee); // add employee to existing list 
		       else
		       {  
		    	    // create a new list and place it in map
		    	    LinkedHashSet<String> emps = new LinkedHashSet<>();
		    	    emps.add(employee);
		    	    depts.put(dept,emps);
		       }
		 }
		 
		 for(String dept : depts.keySet())
		 {
			 System.out.printf("\n%-10s",dept);
			 for(String emp : depts.get(dept))
				 System.out.printf("%-15s", emp);
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
