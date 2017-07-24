import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class ListMobileNumbers {

	public static void main(String[] args) throws Exception {

		try (FileWriter fw = new FileWriter("f:\\classroom\\june19\\mobilenumbers.txt")) 
		{
			FileReader fr = new FileReader("f:\\classroom\\june19\\mobile.txt");

			BufferedReader br = new BufferedReader(fr);

			while (true) {
				String line = br.readLine();
				if (line == null)
					break;

				if (line.trim().length() == 0)
					continue;

				String[] numbers = line.split(",");

				for (String n : numbers) {
					if ( n.length() != 10)
						continue;
					
					System.out.println(n);
					fw.write(n + "\n");
				}
			}

			fr.close();
			br.close();
		}

	}

}
