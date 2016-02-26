package requests;

import managers.DroneManager;
import managers.WarehouseManager;
import droneDeliverySystem.Request;

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
<<<<<<< HEAD:DroneDeliverySystem/src/droneDeliverySystem/RequestsConsumer.java
				//droneManager.executeDelivery(request.getProducts(), request.getLocation(), request.getID());
=======
				droneManager.executeDelivery(request.getProducts(), request.getLocation(), request.getID(), request.getTimestamp());
>>>>>>> 36df7563b32f527a216aea7294013e9807a44df7:DroneDeliverySystem/src/requests/RequestsConsumer.java
			}
			
		} else {
			warehouseManager.supply(request.getProducts());
		}
	}
	
	
	
}
