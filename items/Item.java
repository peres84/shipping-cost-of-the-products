package items;
import java.util.Random;
public abstract class Item {
	

	private double length;
	private double width;
	private double height;
	private double weight;
	private String productName;
	private int ID;
	private int min = 1; // Minimum value of range
    private int max = 1000; // Maximum value of range
	
	
	//length, width, height, weight
	
	public Item(double length, double width, double height, double weight, String productName) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.productName = productName; 
		this.ID = (int)Math.floor(Math.random() * (max - min + 1) + min);
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double Volum() {
		
		return this.length * surface();
	}
	
	public abstract double surface();
	
	public void printInfo() {
	    	
	        System.out.println("--------------------------------------------------------------------------------------------------");
	        System.out.printf("%10s | %20s | %5s | %5s | %5s | %5s | %5s", "PRODUCT ID", "DESCRIPTION", "LENGHT (cm)", "WIDTH (cm)", "HEIGHT (cm)", "WEIGHT (g)", "VOLUM (cm3)");
	        System.out.println();
	        System.out.println("--------------------------------------------------------------------------------------------------");
	        System.out.printf("%10d | %20s | %.2f \t  %.2f        %.2f \t     %.2f \t %.2f",
                    this.ID, this.productName, this.length, this.width, this.height, this.weight, this.length * surface());
	        System.out.println();
	        System.out.println("---------------------------------------------------------------------------------------------------");
	        
	       
	}


}
