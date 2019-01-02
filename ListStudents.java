// List students and age by sorting details by name of the student
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.TreeMap;

public class ListStudents {

	public static int getAge(String dob) {
		try {
			LocalDate db = LocalDate.parse(dob, DateTimeFormatter.ofPattern("ddMMyyyy"));
			long years = ChronoUnit.YEARS.between(db, LocalDate.now());
			return (int) years;
		} catch (Exception ex) {
			return -1;
		}
	}

	public static void main(String[] args) throws Exception {
		Path path = Paths.get("e:\\classroom\\java\\nov19\\students.txt");
		TreeMap<String, Integer> students = new TreeMap<>();
		for (String line : Files.readAllLines(path)) {
			String[] parts = line.split(",");
			if (parts.length < 2)
				continue; // ignore lines that do not have name and dob

			int age = getAge(parts[1]);
			if (age >= 0)
				students.put(parts[0], age);
		}

		for (String name : students.keySet())
			System.out.printf("%-20s  %s\n", name, students.get(name));
	}
}
students.txt (input)
====================
Steve,11122001
Joe,01012003
Mike,12101998
Scott,0809200
Larry,09091999

Output
======
Joe                   16
Larry                 19
Mike                  20
Steve                 17





