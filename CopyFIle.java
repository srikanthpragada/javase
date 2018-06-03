// CopyFIle to copy source to target by checking for existing of target 
package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("Enter source file : ");
		String source = s.nextLine();
		try {
			FileReader fr = new FileReader(source);

			System.out.print("Enter target file : ");
			String target = s.nextLine();

			File file = new File(target);
			if (file.exists()) {
				System.out.println("Sorry! Target file exists!");
				System.exit(1);
			}
			
			try (FileWriter fw = new FileWriter(target)) {
				while (true) {
					int ch = fr.read();
					if (ch == -1) // EOF
						break;
					fw.write(ch);
				}
			}
			
			System.out.printf("\nCopied %s to %s!\n", source, target);

		} catch (FileNotFoundException ex) {
			System.out.printf("Sorry! Source file [%s] not found!\n", source);
		} catch (IOException ex) {
			System.out.printf("Sorry! Could complete complete task due to error : %s\n", ex.getMessage());
		}

	}

}
