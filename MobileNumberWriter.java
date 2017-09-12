// Writes mobile numbers from source file to target file - one number per line 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class WriteMobileNumbers {

	public static void main(String[] args) throws Exception {

 
		try (FileReader fr = new FileReader("f:\\classroom\\aug9jse\\mobile.txt"); 
		 	 FileWriter fw = new FileWriter("f:\\classroom\\aug9jse\\mobile_numbers.txt")) {
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				String line = br.readLine();
				if (line == null) // EOF
					break;

				if (line.length() == 0)
					continue;

				String numbers[] = line.split(",");

				for (String n : numbers) {
					if (n.length() == 10)
						fw.write(n + "\n");
				}
			}
		}

	}

}

f:\classroom\aug9jse\mobile.txt (input file)
============================================
9988776655,3939393999
9338776655,3939393933,3939999993

3939393933
383838333

29292abc45

f:\classroom\aug9jse\mobile_numbers.txt (output file)
====================================================
9988776655
3939393999
9338776655
3939393933
3939999993
3939393933
29292abc45


