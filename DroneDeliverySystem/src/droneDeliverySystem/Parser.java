package droneDeliverySystem;

import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import basicClasses.DeliveryRequest;
import basicClasses.Location;
import basicClasses.Product;
import basicClasses.SupplyRequest;
import interfaces.Request;

public class Parser {
	
	/*public Request createRequest() {
		Map<Product, Integer> products = new HashMap<>();
		
		UserInterface ui = new UserInterface();
		
		Date date = new Date();
		
		String requestType = ui.typeOfRequest();
		
		String[] coordinates = ui.askForLocation();
		
		System.out.println(coordinates[0] + " " + coordinates[1]);
		
		Location location = new Location(Integer.getInteger(coordinates[0]), Integer.getInteger(coordinates[1]));
		
		while(ui.stopper() == "stop") {
			products.put(new Product(ui.askForProductName(), Double.parseDouble(ui.askForProductQuantity())), Integer.getInteger(ui.askForHowMantProducts()));
		}
		
		if(requestType == "delivery") {
			return new SupplyRequest(date, location, products);
		}
		
		else {
			return new DeliveryRequest(date, location, products);
		// != instead of == ?
		while(ui.stopper() == "stop") {
			products.put(new Product(ui.askForProductName(), Double.parseDouble(ui.askForProductQuantity())), Integer.getInteger(ui.askForHowMantProducts()));
		}
		
		
	}*/
}
