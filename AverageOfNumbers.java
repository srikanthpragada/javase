package demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AverageOfNumbers {
	public static void main(String[] args) {
		int count=0, sum=0, n;
		Scanner s = new Scanner(System.in);
		 for(int i=1; i <= 5; i ++)
		 {
			 try {
			     n = s.nextInt();
			     sum += n;
				 count ++;
			 }
			 catch(InputMismatchException ex) {
				 System.out.println("Sorry! Invalid number!");
				 // clear keyboard buffer
				 s.nextLine(); // read line from buffer 
			 }
		 }
		 System.out.printf("Average of numbers : %d", sum / count);
	}

}
