Person.java
===========

abstract public class Person {
	protected String name, email;

	public Person(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public void print() {
		System.out.println(name);
		System.out.println(email);
	}
	
	final public void setEmail(String email) {
		this.email = email;
	}
	
	public abstract String getOccupation();


}

Faculty.java
=============

public class Faculty extends Person {

	protected String subjects;

	public Faculty(String name, String email, String subjects) {
		super(name, email);
		this.subjects = subjects;
	}
	
	@Override 
	public void print() {
		super.print();
		System.out.println(subjects);
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	
	public String getOccupation() {
		   return  "Teaches " + subjects;
	}
}

Student.java
===========
public class Student extends Person {

	protected String course;

	public Student(String name, String email, String course) {
		super(name, email);
		this.course = course;
	}
	
	@Override 
	public void print() {
		super.print();
		System.out.println(course);
	}

	public void setSubjects(String course) {
		this.course = course;
	}
	
	public String getOccupation() {
		   return  "Persuing  " + course;
	}
}

TestPerson.java
===============
public class TestPerson {

	public static void main(String[] args) {

		Person p;
		
		p = new Faculty("James","james@google.com","Java");
		p.print();  // runtime polymorphism 
		System.out.println( p.getOccupation() ); // runtime polymorphism 
		
		p = new Student("Andy","andy@gmail.com","BE CS");
		p.print();
		System.out.println( p.getOccupation() );
		

	}

}




