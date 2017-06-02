import java.io.RandomAccessFile;
import java.util.Scanner;

public class MarksManager {

	private static RandomAccessFile file = null;
	private static Scanner s=null;

	// static initializer
	static {
		try {
			file = new RandomAccessFile("f:\\classroom\\may5\\marks.dat", "rw");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void createMarks() throws Exception {

		file.seek(0);
		for (int i = 1; i <= 50; i++) {
			file.writeInt((int) (Math.random() * 100));
		}
		
		System.out.println("\n****** Create Marks! ******** \n");
	}

	public static void listMarks() throws Exception {

		file.seek(0);
		for (int i = 1; i <= 50; i++) {
			System.out.printf("%2d : %2d\n", i, file.readInt());
		}
	}

	public static void searchMarks() throws Exception {
		while (true) {
			System.out.print("Enter rollno [0 to stop] : ");
			
			int rollno = s.nextInt();
			if ( rollno == 0)
				 break;  
			file.seek((rollno - 1) * 4);
			System.out.printf("\nMarks :  %d\n", file.readInt());
		}
 
	}
	
	public static void updateMarks() throws Exception {

		while (true) {
			System.out.print("Enter rollno [0 to stop] : ");
			int rollno = s.nextInt();
			if (rollno == 0)
				 break;
			System.out.print("Enter new marks          : ");
			int marks = s.nextInt(); 
			file.seek((rollno - 1) * 4);
			file.writeInt(marks);
			System.out.printf("\nUpdate!\n");
		}
	}

	public static void main(String[] args) throws Exception {

		s = new Scanner(System.in);

		while (true) {
			System.out.println("Menu");
			System.out.println("===============");
			System.out.println("1. Create Marks");
			System.out.println("2. List Marks");
			System.out.println("3. Search Marks");
			System.out.println("4. Update Marks");
			System.out.println("5. Exit");
			System.out.print("Enter your choice [1-5] :");
			int opt = s.nextInt();

			switch (opt) {
			case 1:
				createMarks();
				break;
			case 2:
				listMarks();
				break;
			case 3:
				searchMarks();
				break;
			case 4:
				updateMarks();
				break;
			case 5:
				file.close();
				return;
			}
		}
	}

}
