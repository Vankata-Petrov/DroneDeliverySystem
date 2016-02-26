package requests;

import managers.DroneManager;
import managers.WarehouseManager;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import droneDeliverySystem.DeliveryRequest;
import droneDeliverySystem.Drone;
import droneDeliverySystem.Location;
import droneDeliverySystem.Request;
import droneDeliverySystem.Warehouse;

public class RequestsConsumer extends Thread {

	private RequestManager requestManager;
	private WarehouseManager warehouseManager = new WarehouseManager();
	private DroneManager droneManager;

	public RequestsConsumer(RequestManager requestManager) {
		this.requestManager = requestManager;
		warehouseManager.warehouses.add(new Warehouse(new Location(42, 42)));
		Drone firstDrone = new Drone(5, 2000, 100, 5);
		Drone secondDrone = new Drone(5, 2000, 100, 5);
		Drone thirdDrone = new Drone(5, 2000, 100, 5);
		Drone fourthDrone = new Drone(5, 2000, 100, 5);

		Map<Drone, Date> droneList = new ConcurrentHashMap<>();
		droneManager = new DroneManager(droneList);
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
			}
		}
	}

}
