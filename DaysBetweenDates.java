import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysBetween {
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
     	 System.out.print("Enter first date [dd-mm-yyyy] :");
	     String fds = s.nextLine();
	    
	     LocalDate fd = LocalDate.parse(fds, 
	    		         DateTimeFormatter.ofPattern("d-M-y"));
	     
	     System.out.print("Enter second date [dd-mm-yyyy]:");
	     String sds = s.nextLine();
	     
	     LocalDate sd = LocalDate.parse(sds, 
		         DateTimeFormatter.ofPattern("d-M-y"));
	     
	     System.out.println( ChronoUnit.DAYS.between(fd, sd));
	}

}
