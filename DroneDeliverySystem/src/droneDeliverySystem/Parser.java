package droneDeliverySystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Parser {
	
	public Request createSupplyRequest() {
		Map<Product, Integer> products = new HashMap<>();
		
		System.out.println("LOLOLOL");
		
		UserInterface ui = new UserInterface();
		
		Date date = new Date();
		
		String[] coordinates = ui.askForLocation();
		
		Location location = new Location(Integer.getInteger(coordinates[0]), Integer.getInteger(coordinates[1]));
		
		while(ui.stopper() == "stop") {
			products.put(new Product(ui.askForProductName(), Double.parseDouble(ui.askForProductQuantity())), Integer.getInteger(ui.askForHowMantProducts()));
		}
				
		return new SupplyRequest(date, location, products);
	}

	public DeliveryRequest createDeliveryRequest() {
		Map<Product, Integer> products = new HashMap<>();
		
		UserInterface ui = new UserInterface();
		
		Date date = new Date();
		
		String[] coordinates = ui.askForLocation();
		
		Location location = new Location(Integer.getInteger(coordinates[0]), Integer.getInteger(coordinates[1]));
		
		while(ui.stopper() == "stop") {
			products.put(new Product(ui.askForProductName(), Double.parseDouble(ui.askForProductQuantity())), Integer.getInteger(ui.askForHowMantProducts()));
		}
		
		return new DeliveryRequest(date, location, products);
	}

}
