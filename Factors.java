
public class Factors{

     public static void main(String args[]) {

      if (args.length == 0){
		      System.out.println("Sorry! Number is missing!");
		     return;
	    }

	    for(String s : args) {
        int num = Integer.parseInt(s);
        System.out.printf("\nFactors of [%d]\n",num);

        for(int i=2; i <= num/2 ; i++) {
           if (num % i == 0)
              System.out.println(i);
        } // for
      } // outer for
   } // main()
} // class

Sample Output
=============
>java Factors2 123 393
Factors of [123]
3
41

Factors of [393]
3
131
