SavingsAccount.java
===================

public class SavingsAccount {

	private int acno;
	private String customer;
	private double balance;
	private static int minbal=5000;
	
	public static int getMinbal() {
		return minbal;
	}

	public SavingsAccount(int acno, String customer) {
		super();
		this.acno = acno;
		this.customer = customer;
	}
	
	public SavingsAccount(int acno, String customer, double balance) {
		super();
		this.acno = acno;
		this.customer = customer;
		this.balance = balance;
	}


	public void print() {
		System.out.println(this.acno);
		System.out.println(this.customer);
		System.out.println(this.balance);
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= balance - minbal)
			this.balance -= amount;
		else
			System.out.println("Sorry! Insufficient balance!");
	}

	public double getBalance() {
		return balance;
	}

}


TestAccount.java
================

public class TestAccount {

	public static void main(String[] args) {
		 SavingsAccount s1;    
		 
		 s1 = new SavingsAccount(1, "Bill Gates");
		 s1.deposit(10000);
		 s1.deposit(50000);
		 s1.withdraw(20000);
		 s1.withdraw(40000);
		 
		 s1.print();
		 
		 System.out.println(SavingsAccount.getMinbal());

	}

}
