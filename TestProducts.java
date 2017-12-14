abstract class Product {
	protected String name;
	protected int price, qty;

	public Product(String name, int price, int qty) {
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	
	public final int getQty() {
		return qty;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(price);
		System.out.println(qty);
	}

	public abstract double getNetPrice();
}

class DiscountProduct extends Product{
	protected double disRate;
	
	public DiscountProduct(String name, int price, int qty, double disRate) {
		super(name, price, qty);
		this.disRate = disRate;
	}

    @Override
	public void print() {
		super.print();
		System.out.println(disRate);
	}
	
	public double getNetPrice() {
		return  price -  (price * disRate / 100);
	}

}

class TaxProduct extends Product{
	protected double taxRate;
	public TaxProduct(String name, int price, int qty, double taxRate) {
		super(name, price, qty);
		this.taxRate = taxRate;
	}

	public void print() {
		super.print();
		System.out.println(taxRate);
	}
	
	public double getNetPrice() {
		return  price +  (price * taxRate / 100);
	}

}

class ImportedProduct extends TaxProduct{
	protected double duty;

	public ImportedProduct(String name, int price, int qty, double taxRate, double duty) {
		super(name, price, qty, taxRate);
		this.duty = duty;
	}

	public void print() {
		super.print();
		System.out.println(duty);
	}
	
	public double getNetPrice() {
		double  amount = price +  (price * duty / 100);
		return  amount + ( amount * taxRate / 100);
	}

}

public class TestProduct {

	public static void print(Product p) {
		 p.print();  // Runtime polymorphism
		 System.out.println("Net Price : " + p.getNetPrice()); // Runtime polymorphism
	}
	
	public static void main(String[] args) {
		DiscountProduct p = new DiscountProduct("iPhone6",30000,1,20);
		print(p);
		
		 
		ImportedProduct ip = new ImportedProduct("iPhone X", 60000, 2, 12,20);
		print(ip);
		 
	}

}
