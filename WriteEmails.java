package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class WriteEmails {

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("f:\\classroom\\jan23\\emails.txt");
		BufferedReader br = new BufferedReader(fr);

		try (FileWriter fw = new FileWriter("f:\\classroom\\jan23\\outemails.txt")) {
			String line;

			while (true) {
				line = br.readLine();
				if (line == null) // EOF
					break;

				if (line.trim().length() == 0) // Empty Line
					continue;

				// process line
				String emails[] = line.split(",");

				for (String email : emails)
					fw.write(email + "\n");
			}

			fr.close();
		} // try 

	} // main()

}
