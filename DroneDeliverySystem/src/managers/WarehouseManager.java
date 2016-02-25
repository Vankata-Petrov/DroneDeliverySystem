package managers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import basicClasses.BasicDrone;
import basicClasses.DeliveryRequest;
import basicClasses.Location;
import basicClasses.Product;
import basicClasses.SupplyRequest;
import basicClasses.Warehouse;
import interfaces.Request;

public final class WarehouseManager {
	public static LinkedList<Warehouse> warehouses = new LinkedList<>();
	private static Location location = new Location(42, 42);
	/**
	 * Will need this method if we have more warehouses
	 * @param location
	 */
	private static void addWarehouse(Location location) {
		if (warehouses.contains(warehouses) == false) {
			warehouses.add(new Warehouse(location));
		} else {
			// TODO: Exception for trying to add existing warehouse
		}
	}
	/**
	 * Will need this method if we have more warehouses
	 * @param location
	 */
	
	private static void init(List<BasicDrone> drones){
		
	}
	private static void removeWarehouse(Location location) {
		if (warehouses.contains(new Warehouse(location)) == true) {
			warehouses.remove(new Warehouse(location));
		} else {
			// TODO: No such warehouse to remove
		}
	}
/*
	public static void doRequest(Request request) {
		if (request instanceof SupplyRequest) {
			//later we will put another parameter (the warehouse location). For now it's constant;
			//indexOfWarehouse gets index of warehouse we put in
			int indexOfWarehouse = warehouses.indexOf(new Warehouse(location));
			indexOfWarehouse=0;
			if (indexOfWarehouse != -1) {
				for (Map.Entry<Product, Integer> entry : (request.getProducts()).entrySet()) {
					warehouses.get(indexOfWarehouse).supply(entry.getKey(), entry.getValue());
				}
			} else {
				// TODO: exception for no existing warehouse where to do supplyRequest
			}
		} else if (request instanceof DeliveryRequest) {
			ArrayList<Drone> drones=new ArrayList<>();
			drones.add(new Drone(1,2000,500,5));
			/*DroneManager droneManager=new DroneManager(drones,new Warehouse(location));
			droneManager.executeDelivery(request.getProducts(), request.getLocation(), request.getID());
		}
	}
	
	*/
	public boolean productsAvailabilityChecker(Map<Product, Integer> products) {
		int numberOfAvailableProducts=0;
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			if((warehouses.get(0)).isProductAvailable(entry.getKey(), entry.getValue())==true){
				numberOfAvailableProducts++;
			}else{
				break;
			}
		}
		if(numberOfAvailableProducts==products.entrySet().size()){
			return true;
		}else{
			return false;
		}
	}
	
	
	public void supply(Map<Product, Integer> products){
		int indexOfWarehouse = warehouses.indexOf(new Warehouse(location));
		indexOfWarehouse=0;
		if (indexOfWarehouse != -1) {
			for (Map.Entry<Product, Integer> entry : products.entrySet()) {
				warehouses.get(indexOfWarehouse).supply(entry.getKey(), entry.getValue());
			}
		} else {
			// TODO: exception for no existing warehouse where to do supplyRequest
		}
	}
}
