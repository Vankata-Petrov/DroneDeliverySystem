package requests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.Data;

import droneDeliverySystem.DeliveryRequest;
import droneDeliverySystem.Location;
import droneDeliverySystem.Parser;
import droneDeliverySystem.Product;
import droneDeliverySystem.Request;
import droneDeliverySystem.SupplyRequest;

public class RequestProducer extends Thread {

	private RequestManager requestManager;
	private Parser parser;
	private File file;

	public RequestProducer(RequestManager requestManager, File file) {
		this.requestManager = requestManager;
		this.file = file;
	}

	public void run() {

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
	
			while ((line = br.readLine()) != null) {
				if (line.contains("delivery") == true) {
					String[] deliveryContent = line.split(" ");
					Map<Product, Integer> products = new HashMap<>();
					int deliveryId = Integer.parseInt(deliveryContent[1]);

					for (int i = 5; i < deliveryContent.length; i += 2) {
						products.put(new Product(deliveryContent[i], 0), Integer.parseInt(deliveryContent[i + 1]));
					}

					int locationX = Integer.parseInt(deliveryContent[4].substring(0, deliveryContent[4].indexOf(',')));
					int locationY = Integer.parseInt(deliveryContent[4].substring(deliveryContent[4].indexOf(',') + 1,
							deliveryContent[4].length()));
					Location location = new Location(locationX, locationY);
					Date parsedDate = null;

					try {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
						parsedDate = dateFormat.parse(deliveryContent[2] + deliveryContent[3]);
					} catch (Exception e) {// this generic but you can control
											// another types of exception
					}
					
					DeliveryRequest dr = new DeliveryRequest(parsedDate, location, products);
					requestManager.addRequest(dr);
				} else if (line.contains("supply") == true) {
					String[] deliveryContent = line.split(" ");
					Map<Product, Integer> products = new HashMap<>();
					int deliveryId = Integer.parseInt(deliveryContent[1]);

					for (int i = 5; i < deliveryContent.length; i += 3) {
						products.put(new Product(deliveryContent[i], 0), Integer.parseInt(deliveryContent[i + 2]));
					}

					int locationX = Integer.parseInt(deliveryContent[4].substring(0, deliveryContent[4].indexOf(',')));
					int locationY = Integer.parseInt(deliveryContent[4].substring(deliveryContent[4].indexOf(',') + 1,
							deliveryContent[4].length()));
					Location location = new Location(locationX, locationY);
					Date parsedDate = null;

					try {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
						parsedDate = dateFormat.parse(deliveryContent[2] + deliveryContent[3]);
					} catch (Exception e) {// this generic but you can control
											// another types of exception
					}
					SupplyRequest dr = new SupplyRequest(parsedDate, location, products);
					System.out.println("wtf");
					requestManager.addRequest(dr);
				}
			}
		} catch (IOException e) {
		}
	}
}
