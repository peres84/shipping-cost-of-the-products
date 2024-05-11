package containers;

public abstract class Container{

	private double length;
	private double width;
	private double height;
	private double weight;
	private String containerName;
	private int ID;
	private int min = 1; // Minimum value of range
    private int max = 1000; // Maximum value of range
	
	public Container(double length, double width, double height, String containerName) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
		this.containerName = containerName;
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


	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}


	public double Volum() {
		
		return this.length * surface();
	}
	
	public abstract double surface();
	
	public void printInfo() {
    	
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%14s | %20s | %5s | %5s | %5s | %5s", "CONTAINER ID", "DESCRIPTION", "LENGHT (cm)", "WIDTH (cm)", "HEIGHT (cm)", "VOLUM (cm3)");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%14d | %20s | %.2f       %.2f \t   %.2f \t %.2f",
                this.ID, this.containerName, this.length, this.width, this.height, this.length * surface());
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------");
        
       
}
	

}
