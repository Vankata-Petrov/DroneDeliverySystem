package droneDeliverySystem;

import managers.DroneManager;
import managers.WarehouseManager;

public class RequestsConsumer extends Thread {
	
	private RequestManager requestManager;
	private WarehouseManager warehouseManager;
	private DroneManager droneManager;
	
	public RequestsConsumer(RequestManager requestManager) {
		this.requestManager = requestManager;
	}
	
	public void run() {
		Request request = requestManager.sendRequest();
		if(request.getClass().getSimpleName() == "DeliveryRequest") {
			
			if(warehouseManager.productsAvailabilityChecker(request.getProducts())) {
				//droneManager.executeDelivery(request.getProducts(), request.getLocation(), request.getID());
			}
			
		} else {
			warehouseManager.supply(request.getProducts());
		}
	}
	
	
	
}
