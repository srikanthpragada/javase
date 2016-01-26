import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteNames {

	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(System.in);
        int lineno=1;
        
		try (FileWriter fw = new FileWriter("f:\\classroom\\names.txt");) {
			while (true) {
				System.out.print("Enter name [over to end] :");
				String name = s.nextLine();
				if (name.equals("over"))
					break;
				fw.write(lineno + ":" + name + "\n");
				lineno++;
			} // while

		} // try 
	}
}
