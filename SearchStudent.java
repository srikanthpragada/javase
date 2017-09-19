students.txt
=================
1:Bill,Java,20170809
2:Steve,C#,20170809
3:Joe,C#,20170809
4:James,Java,20170909
5:Anders,Oracle,20170810
2:Scott,Java,20170909
7:Abc,Java


package col;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.TreeMap;


public class SearchStudent {
	
	public static class Student {
		private String  name, course;
		private String dj;
		
		public Student(String name, String course, String dj) {
			super();
			this.name = name;
			this.course = course;
			this.dj = dj;
		}

		public String getName() {
			return name;
		}

		public String getCourse() {
			return course;
		}

		public String getDj() {
			return dj;
		}

		@Override
		public String toString() {
			return   name + " - " + course + " - " +  dj.toString();
		}
		
	}

	public static void main(String[] args) throws Exception {
		 
		Path  path = Paths.get("f:\\classroom\\students.txt");
		TreeMap<String,Student> students = new TreeMap<>();
		
		for(String  line : Files.readAllLines(path))
		{
			String [] parts = line.split(":");
			if ( parts.length > 1) 
			{
			  String [] fields = parts[1].split(",");
			  if ( fields.length >= 3)
			  {
				students.put(parts[0], new Student(fields[0], fields[1],fields[2]));
			  }
			}
		}
		
		// Print All Students - Assignment 
		
		Scanner s  = new Scanner(System.in);
		
		while(true) {
		  
			System.out.print("Enter admno : ");
			String admno = s.nextLine(); 
			if ( admno.equals("0")) {
				System.out.println("\nThank you for using!");
				break;
				
			}
			
		    if ( students.containsKey(admno)) 
		    {
		    	Student student = students.get(admno);
		    	System.out.printf("\nName        : %s",  student.getName());
		    	System.out.printf("\nCourse      : %s",  student.getCourse());
		    	System.out.printf("\nDate Joined : %s\n",  student.getDj());
		    }
		    else
		    	System.out.println("\nSorry! Admno not found!\n");
					
		}
	}
}
