package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Encrypt {

	public static void main(String[] args) throws Exception {
	 
		File srcfile = new File("f:\\classroom\\jan23\\test.txt");
		File trgfile = new File("f:\\classroom\\jan23\\temp.txt");
		
		FileReader fr = new FileReader(srcfile);
		FileWriter fw = new FileWriter(trgfile);
		int ch;
		while(true) 
		{
			ch  = fr.read();
			if ( ch == -1)
				 break;
			
			fw.write(ch + 1);  // add 1 to char code 
		}
		
		fw.close();
		fr.close();
		
		// delete source 
		srcfile.delete();
        // rename temp file to source 		
		trgfile.renameTo(srcfile);
        System.out.println("Encrypted successfully!");				
	}
}
