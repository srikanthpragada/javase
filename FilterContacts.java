import java.util.ArrayList;
import java.util.stream.Stream;

public class FilterContacts {
	public static void main(String[] args) {
		ArrayList<Contact> contacts = new ArrayList<>();
		contacts.add( new Contact("Abc","abc@yahoo.com"));
		contacts.add( new Contact("Xyz","xz@gmail.com"));
		contacts.add( new Contact("Def","def@yahoo.com"));
		contacts.add( new Contact("Pqr","pqr@gmail.com"));
		
	
		contacts.stream()
		     .filter(v -> v.getEmail().contains("yahoo.com"))
             .forEach( v -> System.out.println(v));
		
		
		
	}
	
	

}
