import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;

public class PrintJavaPrograms {

	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
		 System.out.print("Enter folder : ");
		 String folder = s.nextLine();
		 
//		 String folder = "c:\\jdk8\\feb9";
		 
		 File dir =  new File(folder);
		 String files [] = dir.list();
		 for(String filename: files)
		 {
			if ( filename.endsWith(".java"))
			     printFile( folder + "\\" + filename);
		 }

	}
	
	public static void printFile(String filename) {
		try(FileReader fr = new FileReader(filename);
		    LineNumberReader lnr = new LineNumberReader(fr)) {
			String line = lnr.readLine();
			while(line != null) {
				System.out.printf("%d:%s\n",  lnr.getLineNumber(), line);
				line = lnr.readLine();
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		 
	}
}






