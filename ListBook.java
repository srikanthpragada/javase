titles.txt
==========
Java Complete Reference,550
Angular JS, 400
jQuery in Action, 450
C++ Comp. Ref, 425
Learning Android,525
C# Cook Book,600

Book.java
==========

public class Book implements Comparable<Book> {

	private String title;
	private int price;

	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Book other = (Book) obj;
		if (price != other.price || !title.equals(other.title))
			return false;

		return true;
	}

	@Override
	public int compareTo(Book other) {
		return this.price - other.price;
	}

}


ListBooks.java
==============
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class TitleComparator implements Comparator<Book> {
	@Override
	public int compare(Book b1, Book b2) {
		return b1.getTitle().toUpperCase().compareTo(b2.getTitle().toUpperCase());
	}
}

public class ListBooks {

	public static void main(String[] args) throws Exception {

		Set<Book> books = new TreeSet<>(new TitleComparator());
		
		// To use default sort order, use the following
		// Set<Book> books = new TreeSet<>();

		FileReader fr = new FileReader("f:\\classroom\\titles.txt");
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String line = br.readLine();
			if (line == null)
				break;

			String parts[] = line.split(",");

			if (parts.length == 2) {
				try {
					Book b = new Book(parts[0], Integer.parseInt(parts[1].trim()));
					books.add(b);
				} catch (Exception ex) {
					// System.out.println("Invalid Entry due to " +
					// ex.getMessage());

				}
			}
		}

		for (Book b : books)
			System.out.println(String.format("%-30s %5d", b.getTitle(), b.getPrice()));

	}

}




