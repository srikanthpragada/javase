
public class Contact {
	private String name, email;

	public Contact(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return  name + "," + email;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
}
