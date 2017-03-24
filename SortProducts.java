Product.java
=============

public class Product  implements  Comparable<Product> {
	// instance variables 
	private String name;
	private double price;
	
    // class variable 
	private static double taxRate = 0.17;
	
	public static void setTaxRate(double rate) {
		  taxRate = rate;
	}

	// Constructor
	public Product(String name, double price)
	{
		this.name  = name;
		this.price = price;
	}
	public Product(String name)
	{
		this.name  = name;
	}

	// methods
	public void print()
	{
		System.out.println(name);
		System.out.println(price);
	}
	
	public double getNetPrice() {
		return this.price +  this.price * taxRate;
	}

	public void setPrice(double price) {
		this.price = price; 
	}
	
	public String toString() {
		return  String.format("%-20s %10.2f", name,price);
	}


	@Override
	public int compareTo(Product other) {
		// System.out.println(this + " : " + other);
		// return  (int) Math.floor(this.price - other.price);
		return  this.name.compareTo(other.name);
	}
}



SortProducts.java
===================
import java.util.Arrays;

public class SortProducts {

	public static void main(String[] args) {
		 
		Product prods[] = new Product[] 
	    {
				new Product("IPad Air 2",45000),
				new Product("Google Pixel ",60000),
				new Product("IPhone 7 Plus",70000),
				new Product("Nexus 6p ",39000)
		};
		
		
		Arrays.sort(prods);
		
		for(Product p : prods)
			System.out.println(p);  //  p.toString()
		
	}

}

