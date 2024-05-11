package containers;

public class smallContainer extends Container {
	
	
 	private double length;
	private double width;
	private double height;
	
	
	public smallContainer(double length, double width, double height) {
		super(length, width, height, "Small Container > 500");
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




	public double surface() {
		return this.width * this.height;
	}
	
	
}
