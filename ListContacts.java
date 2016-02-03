import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListContacts {
	public static void main(String[] args) {
		ArrayList<Contact> contacts = new ArrayList<>();
		contacts.add( new Contact("Abc","abc@yahoo.com"));
		contacts.add( new Contact("Xyz","xz@gmail.com"));
		contacts.add( new Contact("Def","def@yahoo.com"));
		contacts.add( new Contact("Pqr","pqr@gmail.com"));
		
		Collections.sort(contacts,
   		   (c1,c2) ->  c1.getName().compareTo(c2.getName()));
		
		for(Contact c : contacts)
			System.out.println(c.toString());

		Collections.sort(contacts, new ContactCompare() );
	}
	
	public static class ContactCompare implements Comparator<Contact> {
		@Override
		public int compare(Contact c1, Contact c2) {
             return c1.getName().compareTo( c2.getName());
		}
	}

}
