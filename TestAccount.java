Account.java
===============
public class Account {
	// Instance variables
	private int acno;
	private String customer;
	private double balance;

	// Constructors
	public Account(int no, String cust) {
		acno = no;
		customer = cust;
	}

	public Account(int no, String cust, double bal) {
		acno = no;
		customer = cust;
		balance = bal;
	}

	public void print() {
		System.out.println(acno);
		System.out.println(customer);
		System.out.println(balance);
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		if (balance >= amount)
			balance -= amount;
	}

	public double getBalance() {
		return balance;
	}

}


TestAccount.java
==================

public class TestAccount {

	public static void main(String[] args) {
		Account a1;

		a1 = new Account(1, "Bill");

		a1.deposit(10000);
		a1.deposit(20000);

		a1.print();

		Account a2 = new Account(2, "Scott", 10000);
		a2.print();
		

	}

}
