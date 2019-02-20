// Program to print how many times each number occurs in an array 
// Uses TreeMap

import java.util.TreeMap;

public class NumberFreqency {

	public static void main(String[] args) {
		 int a[]  = new int[50];
		 
		 for(int i = 0; i < a.length ; i ++)
		 {
			 a[i] = (int)  Math.floor(Math.random() * 10);
			 System.out.printf("%3d",a[i]);
		 }
		 
		 System.out.println("\nFrequency Table\n");
		 TreeMap<Integer,Integer> ft = new TreeMap<>();
		 for(int n : a)
		 {
			 if (ft.containsKey(n))
				 ft.put(n, ft.get(n) + 1);  // increment count 
			 else
				 ft.put(n, 1);  // new entry with value 1
		 }
		 
		 for(Integer key : ft.keySet())
			 System.out.printf("\n%3d  %d" , key, ft.get(key));

	}

}
