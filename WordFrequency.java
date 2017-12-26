import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class WordFreqency {

	public static void main(String[] args) throws Exception {
		  Path file = Paths.get("f:\\classroom\\dec6\\text.txt");
		  BufferedReader br = Files.newBufferedReader(file);
		  
		  TreeMap<String, Integer>  freq =   new TreeMap<>();
		  
		  while(true) {
			  String line = br.readLine();
			  if ( line == null)
				   break;
			  
			  String words[] = line.split("[ ,.;-]");
			  
			  
			  for(String w : words) {
				  w = w.trim();
				  if (freq.containsKey(w)) {
					   Integer count = freq.get(w);
					   count ++;
					   freq.put(w, count);
				  }
				  else
					   freq.put(w,  1);
    		  }
			  
		  }
		  
		  for(String w : freq.keySet()) {
			  System.out.printf("%-10s  : %d\n", w, freq.get(w));
		  }
	}

}
