import java.util.Scanner;
import java.util.StringJoiner;

public class StringJoinerDemo {

	public static void main(String[] args) {

		StringJoiner sj = new StringJoiner(",", "<", ">");
		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.print("Enter a string [end to stop] :");
			String st = s.nextLine();
			
			if (st.equals("end"))
				break;
			
			sj.add(st);
		}
		
		System.out.println(sj);
	}

}
