import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeSet;

public class SortEmails {

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("f:\\classroom\\emails.txt");
		BufferedReader br = new BufferedReader(fr);
		TreeSet<String> emails = new TreeSet<>();

		String line;

		while (true) {
			line = br.readLine();
			if (line == null) // EOF
				break;

			if (line.trim().length() == 0) // Empty Line
				continue;

			// process line
			String mails[] = line.split(",");

			for (String email : mails)
				emails.add(email);

		}
		fr.close();

		// print emails
		for (String email : emails)
			System.out.println(email);

	} // main()
}
