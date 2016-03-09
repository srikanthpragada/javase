Doctor.java
------------
abstract public class Doctor {
	protected String name, mobile;

	public Doctor(String name, String mobile) {
		this.name = name;
		this.mobile = mobile;
	}
	
	public void print() {
		System.out.println(name); // compiletime polymorphism 
		System.out.println(mobile);
	}
	
	final public String getMobile() {
		return mobile;
	}
	
	public abstract int getPay();
}

ResidentDoctor.java
===================

public class ResidentDoctor extends Doctor{
	protected int salary;

	public ResidentDoctor(String name, String mobile, int salary) {
		super(name, mobile);
		this.salary = salary;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(salary);
	}
	
	@Override
	public int getPay() {
		return salary;
	}
}

Consultant.java
===============

public class Consultant extends Doctor {
	protected int visits, chargePerVisit;

	public Consultant(String name, String mobile, int visits, int chargePerVisit) {
		super(name, mobile);
		this.visits = visits;
		this.chargePerVisit = chargePerVisit;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(visits);
		System.out.println(chargePerVisit);
	}
	@Override
	public int getPay() {
		return visits * chargePerVisit;
	}
}

Surgeon.java
=============

public class Surgeon extends Consultant {
	protected int surgeries, chargePerSurgery;

	public Surgeon(String name, String mobile, int visits, int chargePerVisit,
			      int surgeries, int chargePerSurgery) {
		super(name, mobile, visits, chargePerVisit);
		this.surgeries = surgeries;
		this.chargePerSurgery = chargePerSurgery;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(surgeries);
		System.out.println(chargePerSurgery);
	}

	@Override 
	public int getPay() {
		return  super.getPay() + surgeries * chargePerSurgery;
	}
}

TestDoctor.java
===============

public class TestDoctor {

	public static void main(String[] args) {
		 Consultant c = new Consultant("Dr. Jean","9988776655",10,500);
		 ResidentDoctor r = new ResidentDoctor("Dr. Andy","8888776655",2_00_000);
		 
		 print(c);
		 print(r);
		 
	}
	
	public static void print(Doctor d) {
		d.print(); // runtime polymorphism 
		
		int amount = d.getPay();  // runtime polymorphism
		
		if ( amount > 20000)
			 System.out.printf("Pay %d by cheque\n", amount);
		else
			 System.out.printf("Pay %d by cash\n", amount);
	}

}







