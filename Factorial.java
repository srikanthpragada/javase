// Program to print factorial of the given number
import java.util.Scanner;

public class Factorial {
   public static void main(String args[]) {
   	    Scanner s = new Scanner(System.in);  // read input from keyboard

   	    System.out.print("Enter a number :");
          int num = s.nextInt();  // read an int 
 
          int fact = 1; 
          for (int i=2; i <= num; i++)
          	 fact = fact * i;

          System.out.printf("Factorial of %d is %d", num,fact);
   }
}
