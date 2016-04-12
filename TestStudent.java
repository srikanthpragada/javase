Student.java
==============

abstract public class Student {
	protected String name, mobile;

	public Student(String name, String mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}

	public void print() {
		System.out.println(name);
		System.out.println(mobile);
	}

	abstract public int getMarks();
}

OracleStudent.java
==================
public class OracleStudent extends Student {
	protected int theoryMarks;

	public OracleStudent(String name, String mobile, int theoryMarks) {
		super(name, mobile);
		this.theoryMarks = theoryMarks;
	}
	
	@Override 
	public void print() {
		super.print();
		System.out.println(theoryMarks);
	}
	
	public int getMarks() {
		return theoryMarks;
	}

}


JavaStudent.java
================

public class JavaStudent extends Student {
    protected int labMarks;
	public JavaStudent(String name, String mobile, int labMarks) {
		super(name, mobile);
		this.labMarks = labMarks;
	}
	
	@Override 
	public void print() {
		super.print();
		System.out.println(labMarks);  // compile-time polymorphism 
	}
	@Override 
	public int getMarks() {
		return labMarks;
	}

}

JavaEEStudent.java
=================


public class JavaEEStudent extends JavaStudent {

	protected int projectMarks;
	public JavaEEStudent(String name, String mobile, int labMarks, int projectMarks) {
		super(name, mobile, labMarks);
        this.projectMarks = projectMarks; 
	}

	@Override 
	public void print() {
		super.print();
		System.out.println(projectMarks);
	}
	
	@Override 
	public int getMarks() {
		return super.getMarks() + projectMarks;
	}
}


TestStudent.java
================

public class TestStudent {
	
	public static void print(Student s) {
		s.print();  // runtime polymorphism 
		int marks = s.getMarks();
		
		if ( marks > 80)
			  System.out.println("A");
		else
			if ( marks > 70)
				System.out.println("B");
			else
				System.out.println("C");
	}

	public static void main(String[] args) {
		
		OracleStudent s1 = new OracleStudent("Larry","9988776655", 80);
		print(s1);
	
		JavaEEStudent s2 = new JavaEEStudent("Gavin","9900990099",45,40);
	    print(s2); 
	}

}


