package requests;

import exceptions.DroneException;
import interfaces.Request;
import managers.DroneManager;
import managers.WarehouseManager;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import droneDeliverySystem.DeliveryRequest;
import droneDeliverySystem.Drone;
import droneDeliverySystem.Location;
import droneDeliverySystem.Warehouse;

public class RequestsConsumer extends Thread {

	private RequestManager requestManager;
	private WarehouseManager warehouseManager = new WarehouseManager();
	private DroneManager droneManager;

	public RequestsConsumer(RequestManager requestManager) {
		
	}

	public void run() {
		while (true) {

			Request request = requestManager.sendRequest();
			if (request instanceof DeliveryRequest) {
				System.out.println("tuk");
				if (warehouseManager.productsAvailabilityChecker(request.getProducts())) {
					// droneManager.executeDelivery(request.getProducts(),
					// request.getLocation(), request.getID());
					System.out.println(droneManager.executeDelivery(request.getProducts(), request.getLocation(),
							request.getID(), request.getTimestamp()));
				}

			} else {
				warehouseManager.supply(request.getProducts());
				System.out.println();
		Request request = requestManager.sendRequest();
		if(request.getClass().getSimpleName() == "DeliveryRequest") {
			
			if(warehouseManager.productsAvailabilityChecker(request.getProducts())) {
				//droneManager.executeDelivery(request.getProducts(), request.getLocation(), request.getID());
				try {
					droneManager.executeDelivery(request.getProducts(), request.getLocation(), request.getID(), request.getTimestamp());
				} catch (DroneException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
