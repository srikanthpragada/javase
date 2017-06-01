import java.io.BufferedReader;
import java.io.FileReader;

public class CountWords {

	public static void main(String[] args) throws Exception {

      String filename = "f:\\classroom\\may5\\lines.txt";
      
      FileReader fr = new FileReader(filename);
      BufferedReader br = new BufferedReader(fr);
      
      while(true) {
    	  String line = br.readLine();
    	  if ( line == null)
    		   break;
    	  String words[] = line.split(" ");
    	  int count = 0;
    	  for(String w : words)
    	  { 
    		if ( w.length() != 0 )
    			 count++;
    	  }
    	  System.out.println(count);
      }
      br.close();
      fr.close();
     
	}

}
