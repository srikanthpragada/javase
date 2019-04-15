// Sorts students data taken from students.txt by admno and displays it on screen
public class SortStudentsNyAdmno {

	public static void main(String[] args) throws Exception {
 
		  Path file = Paths.get("e:\\classroom\\java\\feb28\\students.txt");
		  List<String> lines = Files.readAllLines(file);
		  var students = new TreeMap<String,String>();
		  
		  for(String line : lines)
		  {
			  String [] parts  = line.split(",");
			  if (parts.length >= 2)
			     students.put(parts[0], parts[1]);
		  }
		  
		  for(String key : students.keySet())
		  {
			  System.out.printf("%5s - %s\n", key, students.get(key));
		  }
	}
}

Output
===========
 102 - Bill
 111 - Ben
 112 - Scott
 120 - Steve
 233 - Tom
 234 - Steve


students.txt
============
102,Bill
120,Steve
233,Tom
111,Ben

234,Steve
112,Scott

130

