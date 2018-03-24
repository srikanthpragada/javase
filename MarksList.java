package col;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;
public class MarksList {
	public static void main(String[] args) throws Exception {
		Path file = Paths.get("e:\\classroom\\java\\marks.txt");
		BufferedReader br = Files.newBufferedReader(file);
	
		TreeMap<String, Marks>  students = new TreeMap<>();
		while(true)
		{
			String line = br.readLine();
			if (line == null)   // EOF 
				break;
			 
			// Blank line, so ignore 
			if (line.length() == 0 )
				continue;
			
			// process line
			String parts[] = line.split(",");
			Marks marks = new Marks();
			int total  = 0;
			for(int i = 1; i < parts.length ; i ++)
			{
			    int m = Integer.parseInt( parts[i]);
			    total += m;
			    marks.getMarks().add(m);
			}
			marks.setSum(total);
			marks.setAvg(total /  (parts.length - 1) );
			students.put(parts[0],marks);
		}
		br.close();
		
		// Print marks list
		for(String name : students.keySet())
		{
			System.out.printf("%-20s",name);
			// print marks
			Marks marks = students.get(name);
			for(int m :  marks.getMarks()) {
				System.out.printf("%4d ",m);
			}
			// print sum and avg
			System.out.printf("%4d %4d\n",marks.getSum(),marks.getAvg());
		}

	}
}

Marks.java
===========
package col;

import java.util.ArrayList;

public class Marks {
	private ArrayList<Integer> marks;
	private int sum, avg;

	public Marks() {
		marks = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getMarks() {
		return marks;
	}

	public void setMarks(ArrayList<Integer> marks) {
		this.marks = marks;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}
}


Sample Data (marks.txt)
======================
Joe,60,70,70
Jeff,45,66,88,98
Andy,44,87
Michael,99,66,87

Sample Output
=============
Andy                  44   87  131   65
Jeff                  45   66   88   98  297   74
Joe                   60   70   70  200   66
Michael               99   66   87  252   84




