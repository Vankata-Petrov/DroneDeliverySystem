package droneDeliverySystem;

import java.util.LinkedList;
import java.util.Map;

public final class WarehouseManager {
	private static LinkedList<Warehouse> warehouses = new LinkedList<>();
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
	private static void removeWarehouse(Location location) {
		if (warehouses.contains(new Warehouse(location)) == true) {
			warehouses.remove(new Warehouse(location));
		} else {
			// TODO: No such warehouse to remove
		}
	}

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
		} else if (request instanceof SupplyRequest) {
			// TODO: Call DroneManager function
		}
	}
	
	
	public boolean productsAvailabilityChecker(Map<Product, Integer> products) {
		return true;
	}
	
	
	public void supply(Map<Product, Integer> products){
		
	}
}
