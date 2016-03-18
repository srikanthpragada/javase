import java.io.RandomAccessFile;
import java.util.Scanner;

public class MarksMenu {

	public static void main(String[] args) {
      try (RandomAccessFile marksFile = 
    		   new RandomAccessFile("c:\\jdk8\\feb29\\marks.dat","rw"))
      {
	  Scanner s = new Scanner(System.in);
      while(true) {
    	  System.out.println("\nMarks Menu\n");
    	  System.out.println("============\n");
    	  System.out.println("1. Add Marks");
    	  System.out.println("2. List Marks");
    	  System.out.println("3. Exit");
    	  System.out.println("Enter choice : ");
    	  int choice = s.nextInt();
    	  
    	  switch(choice) {
    	     case 1  :   System.out.print("\nEnter Rollno : ");
    	                 int rollno = s.nextInt();
    	                 System.out.print("\nEnter Marks  : ");
    	                 int marks = s.nextInt();
    	                 // go to position based on rollno
    	                 marksFile.seek( (rollno-1) * 4);
                         marksFile.writeInt(marks);
                         System.out.println("\nMarks added successfully!\n");
    	    	         break;
    	     case 2  :   
                         marksFile.seek(0);
                         System.out.println("\nMarks List \n");
                         int count = (int) marksFile.length() / 4;
                         for(int i = 0; i < count ; i ++)
                         {
                        	 System.out.printf("%d : %d\n",
                        			 i + 1, marksFile.readInt());
                         }
                         
    	    	         break;
    	     case 3  :
    	    	 System.out.println("\nThe End\n");
    	    	 return;
    	  }
        }
      }//try 
      catch(Exception ex) {
    	  System.out.println("Error : " + ex.getMessage());
      }
	} // main()
}
