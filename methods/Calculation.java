package methods;
import items.*;
import containers.*;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList; // import the ArrayList class

public class Calculation {
	
	private ArrayList<Object> containerList = new ArrayList <>();
	private ArrayList<Object> clientItems = new ArrayList <>();
	private double totalPrice;
	
	public void addItems(double length, double width, double height, double weight, String productName, int qtt, int option) {
			
		if (option == 1) {
			for (int i = 0; i < qtt; i++) {
				
				Laptop laptop = new Laptop(length, width, height, weight, productName);
				clientItems.add(laptop);
				}
		}else if (option == 2){
			
			for (int i = 0; i < qtt; i++) {
			Mouse mouse = new Mouse(length, width, height, weight, productName);
			clientItems.add(mouse);
			}
		} else if (option == 3) {
			for (int i = 0; i < qtt; i++) {
			Desktop desktop = new Desktop(length, width, height, weight, productName);
			clientItems.add(desktop);
			}
		} else if (option == 4) {
			for (int i = 0; i < qtt; i++) {
			LCD lcd = new LCD(length, width, height, weight, productName);
			clientItems.add(lcd);
			}
		} else {
			System.out.println("the parameter 'option' is out of range from 1 to 4");
		}
		
	}
	
	//getters and setters
	
	public ArrayList<Object> getContainerList() {
		return containerList;
	}

	public void setContainerList(ArrayList<Object> cList) {
		containerList = cList;
	}

	public void setClientItems(ArrayList<Object> cItems) {
		clientItems = cItems;
	}

	public void setTotalPrice(double tPrice) {
		totalPrice = tPrice;
	}

	public ArrayList<Object> getClientItems() {
		return clientItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	//adding information about the order
	public void addOrder() {
		
		System.out.println("Welcome to DHL, please fill the information of your order");
	    int option, qtt;
    	double width, height, weight, length;
    	String description = null;
	    while (true) {
	    	
	    	
	    	try {
	    	
	    	System.out.println("Which of the following items do you need? "
	    			+ "1. Laptop "
	    			+ "2. Mouse "
	    			+ "3. Desktop "
	    			+ "4. LCD");
	    	
			@SuppressWarnings("resource")
			Scanner userInput = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter your Number from 1-4: ");
		    option = userInput.nextInt();  // Read user input
	    	System.out.println("you choose: " + option);  // Output user input
		    
	    	System.out.println("Enter your product description and quantity: ");  // Output user input
	    	System.out.println("Quantity of your order: ");  // Output user input
	    	qtt = userInput.nextInt();
	    	System.out.println("length in (cm): ");  // Output user input
	    	length = userInput.nextDouble();
	    	System.out.println("width in (cm): ");  // Output user input
	    	width = userInput.nextDouble();
	    	System.out.println("height in (cm): ");  // Output user input
	    	height = userInput.nextDouble();
	    	System.out.println("weight in grams (g): ");  // Output user input
	    	weight = userInput.nextDouble(); 	
	    	@SuppressWarnings("resource")
			Scanner inputText = new Scanner(System.in); 
	    	System.out.println("Description: ");  // Output user input
	    	description = inputText.nextLine();
	    	
	    	 switch(option) {
			    case 1:
			    	addItems(length, width, height, weight, description, qtt, option);
			    	//((Item) ''.clientItems.get(0)).printInfo();
			    	//System.out.print(.clientItems);
			      break;
			    case 2:
			    	addItems(length, width, height, weight, description, qtt, option);
			      break;
			    case 3:
			    	addItems(length, width, height, weight, description, qtt, option);
			    	break;
			    case 4:
			    	addItems(length, width, height, weight, description, qtt, option);
			    	break;
			    default:
			      System.out.println("Wrong option, please choose a number between 1 to 4");
			  }
			
			System.out.println("Do you want to add anything else? (Yes: 1) || (No : 0)");
			@SuppressWarnings("resource")
			Scanner userInput2 = new Scanner(System.in);
			int option2 = userInput2.nextInt();
			
			if (option2 == 1) {
				continue;
			} else {
				break;
			}
	    	
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    }
	 
	    //out loop
	  
	} //out of addOrder method 
	
	
	public double totalVolume() {
		
		double totalVolum = 0;
		for(Object i: clientItems){
			totalVolum += ((Item) i).Volum();            
		}
		return totalVolum;
	}
	

	public double totalWeight() {
		
		double totalWeight = 0;
		for(Object i: clientItems){
			totalWeight += ((Item) i).getWeight();            
		}
		return totalWeight;
	}

	public void printItem() {
		for(Object i: clientItems){
			((Item) i).printInfo();          
		}
	}
	
	public double  shippingPrice () {
		
		return totalPrice;
	}
	
	
	
	public void bestShipping() {
		
		double totalVolume = totalVolume();
		double totalWeight = totalWeight();
		double WeightperVolume = totalWeight/totalVolume;
		smallContainer sc = new smallContainer(606, 243, 259);
		bigContainer bc = new bigContainer(1201, 243, 259);
		
		double scVolume = sc.Volum();
		double bcVolume = bc.Volum();
		
		//System.out.printf("volumnes bc %.2f V ; sc %.2f V ", bcVolume, scVolume );
		
		while (true) {
			//System.out.printf("before %.2f V ; %.2f W ", totalVolume, totalWeight );
			//System.out.println("");
			if(totalWeight > 500000) { //bigger than 500kg
				
				//check big containers 
				if (totalVolume >= bcVolume) {
					containerList.add(bc);
					totalWeight -= totalVolume*WeightperVolume;
					//totalWeight -= 500000;
					totalVolume -= bcVolume;
					totalPrice  += 1800;
					//System.out.printf("500kg > %.2f V ; %.2f W ", totalVolume, totalWeight );
					//System.out.println("");
					
				} else if (totalVolume <= scVolume) { //less than less than volume small container
					sc.setContainerName("Small Container > 500");
					//totalWeight = totalWeight - totalVolume*WeightperVolume;
					containerList.add(sc);
					totalPrice  += 1200;
					break;

				} else {
					// the volume is between the bigger and smaller, to avoid increase
					//the price with 2 smaller containers just send in 1 big container. 
					containerList.add(bc);
					totalPrice += 1800;
					break;
				}
						
				
			} else {
				//check big containers 
				if (totalVolume >= bcVolume) {
					containerList.add(bc);
					totalVolume -= bcVolume;
					totalWeight -= totalVolume*WeightperVolume;
					totalPrice += 1800;
					//System.out.printf("500kg < %.2f V ; %.2f W ", totalVolume, totalWeight );
					//System.out.println("");
					
				} else if (totalVolume <= scVolume) { //less than volume small container
					sc.setContainerName("Small Container < 500");
					containerList.add(sc);
					totalPrice += 1000;
					break;

				} else {
					// the volume is between the bigger and smaller, to avoid increase
					//the price with 2 smaller containers just send in 1 big container. 
					containerList.add(bc);
					totalPrice += 1800;
					break;
				}
				
			}
		
		} // out loop
		
		 
		System.out.printf("your best shipping method for a total volume of %.2f (cm3) and weight %.2f Kg", totalVolume(), totalWeight()/1000);
		System.out.println("");
		for (Object i: containerList) {
			
			System.out.print("1x - ");
			System.out.println(((Container) i).getContainerName());
		}
		System.out.println("======================");
		System.out.printf("Total Price: %.2f", totalPrice);

		
	}
	
	//printing order results 
	public void printOrder() {
		
		System.out.println("Your Order details for each prodcut are: ");
		printItem();
		System.out.println("Your Shipping details per Container ");
		bestShipping();
	}

	
		
	
}
