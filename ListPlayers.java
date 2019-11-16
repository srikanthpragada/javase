import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TreeMap;

public class ListPlayers {

	public static void main(String[] args) throws Exception {
	     Path p = Paths.get("e:\\classroom\\java\\oct4\\players.txt");
		 List<String> lines = Files.readAllLines(p);
         TreeMap<String,Integer> players = new TreeMap<>();
		 LocalDate today = LocalDate.now();
		 
		 for (String line : lines)
		 {
			String parts[] = line.split(",");
			// Ignore line if two parts are not present 
			if (parts.length < 2)
				continue; 
			
			String str_dob = parts[1];
			// Split date of birth into three parts - day, month and year 
			String dparts [] = str_dob.trim().split("[ /-]");
			
			// Create LocalDate from day,month and year
			LocalDate dob = null;
			try {
			   dob = LocalDate.of(Integer.parseInt(dparts[2]),
                               Integer.parseInt(dparts[1]),Integer.parseInt(dparts[0]));
			}
			catch(Exception ex) {
			  continue; 
			}
			
			// Calculate no. of years 
			int age = (int) ChronoUnit.YEARS.between(dob, today);
			
			// Add entry to map 
			players.put(parts[0], age);
		 }
		 
		 
		 for(String name : players.keySet()) {
			 System.out.printf("%-20s %d\n",  name, players.get(name));
		 }
	}
}


plyers.txt
===========
Xyz, 21 11 1992
Abc, 12-22-1995
Pqr, 1/1/1994
Joe 
Def, 12 12 2000

Bill,1-2-2000
