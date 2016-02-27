package requests;

import exceptions.DroneException;
import interfaces.Drone;
import interfaces.Request;
import managers.DroneManager;
import managers.WarehouseManager;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import basicClasses.BasicDrone;
import basicClasses.DeliveryRequest;



public class RequestsConsumer extends Thread {

	private RequestManager requestManager;
	private WarehouseManager warehouseManager = new WarehouseManager();
	private DroneManager droneManager;

	public RequestsConsumer(RequestManager requestManager) {
		this.requestManager = requestManager;
		warehouseManager.add();
		Drone firstDrone = new BasicDrone();
		Drone secondDrone = new BasicDrone();
		Drone thirdDrone = new BasicDrone();
		Drone fourthDrone = new BasicDrone();
		
		Map<Drone, Date> droneList = new ConcurrentHashMap<>();
		droneList.put(firstDrone, new Date(System.currentTimeMillis()));
		droneList.put(secondDrone, new Date(System.currentTimeMillis()));
		droneList.put(thirdDrone, new Date(System.currentTimeMillis()));
		droneList.put(fourthDrone, new Date(System.currentTimeMillis()));
		
		droneManager = new DroneManager(droneList, warehouseManager.warehouses.getLast());
	}

	public void run() {
		while (true) {
			Request request = requestManager.sendRequest();

			if (request instanceof DeliveryRequest) {
				if (warehouseManager.productsAvailabilityChecker(request.getProducts())) {
					try {
						System.out.println(request.getProducts() + " " + request.getLocation() + " "
					    + request.getID() + " " +request.getTimestamp() + "\n");
						System.out.println(droneManager.executeDelivery(request.getProducts(), request.getLocation(),
								request.getID(), request.getTimestamp()));
						System.out.println("===========================================================");
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
