import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.print("Enter filename :");
		String filename = s.nextLine();
		try {
			FileReader fr = new FileReader(filename);
			int chars, words, lines;

			chars = words = lines = 0;
			int ch = fr.read();
			while (ch != -1) {
				chars++;
				if (ch == 32) // end of word
					words++;

				if (ch == '\n') { // end of line
					lines++;
					words++;
				}

				ch = fr.read();
			}
			fr.close();
			System.out.printf("\nChars   : %d", chars);
			System.out.printf("\nWords   : %d", words);
			System.out.printf("\nLines   : %d", lines);
		} catch (Exception ex) {
			System.out.println("Sorry! Error -> " + ex.getMessage());
		}

	}

}
