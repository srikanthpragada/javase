
public abstract class Employee {
	protected int id;
	protected String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void print() {
		System.out.println(id);
		System.out.println(name);
	}
	
	public abstract int getPay();

}



public class Consultant extends Employee {
	protected int hours, charge;
	
	
	public Consultant(int id, String name, int hours, int charge)
	{
	   super(id,name);
	   this.hours = hours;
	   this.charge = charge;
	}
	
	@Override 
	public void print() {
		super.print();
		System.out.println(hours);
		System.out.println(charge);
	}
	
	public int getPay() {
		return hours * charge;
	}

}




public class SalariedEmployee extends Employee {
	protected int salary;
	
	public SalariedEmployee(int id, String name, int salary)
	{
	   super(id,name);
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



public class OverseasEmployee extends SalariedEmployee {

	protected int allowance;

	public OverseasEmployee(int id, String name, int salary, int allowance) {
		super(id, name, salary);
		this.allowance = allowance;
	} 
	
	@Override 
	public void print() {
		super.print();
		System.out.println(this.allowance);
	}
	
	@Override
	public int getPay() {
		return  salary + allowance; 
	}

	
}



public class TestEmployee {
	
	public static void print(Employee e) {
	   e.print();	// Runtime polymorphism 
	   int salary = e.getPay();
	   
	   if ( salary >= 20000)
		   System.out.printf("Pay %d by cheque!\n", salary);
	   else
		   System.out.printf("Pay %d by cash!\n", salary);
	}


	public static void main(String[] args) {

		
       Employee e = new SalariedEmployee(1,"Bill", 100000);
       print(e);
       
       e = new OverseasEmployee(2,"Larry", 10000,5000);
       print(e);
       
     
       

	}

}
