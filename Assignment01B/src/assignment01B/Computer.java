package assignment01B;

public class Computer {
	
	// Atributes
	public String brand;
	public String model;
	public long SN = 1;
	public double price;
	private long numComp = 0;
	private static int serialNumberCounter = 0;
	
	// Constructors
	public Computer() {
		SN = serialNumberCounter++;
		serialNumberCounter++;
	}
	
	// Parameter constructor
	public Computer(String brand, String model, double price) {
	//  System.out.println("Using parameter constructor.");
		this.brand = brand;
		this.model = model;
		SN = serialNumberCounter++;
		serialNumberCounter++;
		this.price = price;
		System.out.println("Brand: " + this.brand);
		System.out.println("Model: " + this.model);
		System.out.println("Serial Number: " + this.SN);
		System.out.println("Price: $" + this.price);		
		System.out.println("---------------------------------------------");
	}
	
	// Copy constructor
	public Computer(Computer c) {
//		System.out.println("Using copy constructor.");
		brand = c.brand;
		price = c.price;
		model = c.model;
		SN = serialNumberCounter++;
		serialNumberCounter++;
		System.out.println("Brand: " + this.brand);
		System.out.println("Model: " + this.model);
		System.out.println("Serial Number: " + SN);
		System.out.println("Price: $" + this.price);
		System.out.println("---------------------------------------------");
	}
	
	// Getters and setters
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getSN() {
		return SN;
	}

	public void setSN(long sn) {
		this.SN = sn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// Method to find created computers
	public void findNumberOfCreatedComputers() {
		
		numComp = SN;
		if(numComp == 0) {
			System.out.println(0);
		} else {
			System.out.println("The number of computers created is " + numComp + ".");
		}
	}
	
	
	// Method to show computer's information
	@Override
	public String toString() {
		return "Computer [brand=" + brand + ", model=" + model + ", SN=" + SN + ", price=" + price + "]";
	}
	
	
	// Method to check if one computer is equal to another computer
	public boolean equals(Computer c) {
		String c1 = this.getModel().toString();
		String c2 = c.getModel().toString();
		if(brand == c.brand && price == c.price && model == c.model) {
			System.out.println("Computer " + c1 + " is equal to " + c2 + ".");
			return true;
		} else {
			System.out.println("Computer " + c1 + " is not equal to " + c2 + ".");
			return false;
		}
		
	}	
}
