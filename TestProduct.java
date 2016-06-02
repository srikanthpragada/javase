Product.java
--------------

public class Product {
	private int id;
	private String name;
	private double price;
	private String[] features = new String[5];
	private static double tax = 14.5;

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product(int id, String name, double price, String[] features) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.features = features;
	}

	
	public void setFeature(int index, String feature) {
		features[index] = feature; 
	}
	
	public String getFeature(int index) {
		 return features[index]; 
	}
	
	public void print() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(price);
		System.out.println(price + ( price * tax / 100));
		
		for(String f : features)
			if ( f != null)
				  System.out.println(f);
	}
	
	public double getSellingPrice() {
		return  price + (price * tax /100);
	}
	
	
	public static double getTax() {
		return tax;
	}

	public static void setTax(double tax) {
		Product.tax = tax;
	}

}



TestProduct.java
------------------

public class TestProduct {

	public static void main(String[] args) {

		
		Product p1 = new Product(1,"Product1", 10000);
		p1.setFeature(0, "More memory");  
		p1.setFeature(2, "More Secondary storage");
		p1.print();
		
		Product.setTax(15.5);
		System.out.println( p1.getSellingPrice() );

	}
}
