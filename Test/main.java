package Test;
import items.*;

import java.util.ArrayList;

import containers.Container;
import containers.smallContainer;
import methods.Calculation;

public class main {

	public static void main(String[] args) {
		
		Calculation myAccount = new Calculation();
		myAccount.addOrder();
		//myAccount.bestShipping();
		System.out.println("");
		//double price = myAccount.shippingPrice();
		//System.out.println(price);
		
		myAccount.printOrder();

	}

}