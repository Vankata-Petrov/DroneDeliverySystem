package requests;

import exceptions.DroneException;
import interfaces.Request;
import managers.DroneManager;
import managers.WarehouseManager;
import basicClasses.DeliveryRequest;



public class RequestsConsumer extends Thread {

	private RequestManager requestManager;
	private WarehouseManager warehouseManager = new WarehouseManager();
	private DroneManager droneManager = new DroneManager();

	public RequestsConsumer(RequestManager requestManager) {
		this.requestManager = requestManager;
		warehouseManager.add();
	}

	public void run() {
		while (true) {
			Request request = requestManager.sendRequest();

			if (request instanceof DeliveryRequest) {
				if (warehouseManager.productsAvailabilityChecker(request.getProducts())) {
					try {
						System.out.println(droneManager.executeDelivery(request.getProducts(), request.getLocation(),
								request.getID(), request.getTimestamp()));
					} catch (DroneException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			} else {
				warehouseManager.supply(request.getProducts());
			}
		}
	}
}
