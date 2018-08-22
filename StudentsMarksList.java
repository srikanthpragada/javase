e:\classroom\java\july16\marks.txt)
============
1,80
2,50
1,79
2,70
3,70
4,55
6,39
5,80
1,60


MarksList.Java
================
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class StudentsMarksList {

	public static void main(String[] args) throws Exception {
		 
		Path file = Paths.get("e:\\classroom\\java\\july16\\marks.txt");
		List<String> lines = Files.readAllLines(file);
		
		TreeMap<String,List<String>> marksList = new TreeMap<>();
		
		for(String line : lines)
		{
			String parts[]  = line.split(",");
			if( parts.length < 2)
				continue;
			
			String rollno = parts[0];
			String marks = parts[1];
			
            // rollno is present
			if ( marksList.containsKey(rollno))
				 marksList.get(rollno).add(marks);
			else
			{
				ArrayList<String> values = new ArrayList<>();
				values.add(marks);
				marksList.put(rollno, values); 
			}
		}
		
		for(String rollno : marksList.keySet())
			System.out.printf("\n%-5s  %s", rollno,  
					 String.join(",", marksList.get(rollno)));
	}
}


Output
=======
1      80,79,60
2      50,70
3      70
4      55
5      80
6      39
