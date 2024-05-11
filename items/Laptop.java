package items;

public class Laptop extends Item {
	
	private double length;
	private double width;
	private double height;

	public Laptop(double length, double width, double height, double weight, String productName) {
		super(length, width, height, weight, productName);
		this.length = length;
		this.width = width;
		this.height = height;
	}
	

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double surface() {
		return this.width * this.height;
	}
	
}
