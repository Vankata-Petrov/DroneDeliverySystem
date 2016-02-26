package managers;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import basicClasses.Location;
import basicClasses.Product;
import basicClasses.Warehouse;
import exceptions.DroneException;
import interfaces.Drone;

public class DroneManager {
	
	private Map<Drone, Date> drones;
	private Warehouse warehouse;
	
	public DroneManager() {
		drones = new ConcurrentHashMap<>();
		warehouse = null;
	}
	
	public DroneManager(Map<Drone, Date> drones, Warehouse warehouse){
		this.drones=drones;
		this.warehouse=warehouse;
	}
	

	public String executeDelivery(Map<Product, Integer> products, Location deliveryLocation, String requestId, Date requestTime) throws DroneException {

		Drone minDrone = null;
		Date arrivalTime = null;
		
		Map.Entry<Drone, Date> minEntry = null;

		// LOADING DRONES
		while(true) {
			
			// get the drone that would need the least time to get to the location
			synchronized (drones) {
				minEntry = findMin(drones, deliveryLocation);				
			}
			minDrone = minEntry.getKey();
			Date droneCurrentTime = minEntry.getValue();
			
			if(canCarryAll(products, minDrone)) {
				
				// load everything and directly deliver
				
				
				double distanceWarehouseToLocation = distanceWarehouseDeliveryLocation(deliveryLocation);
				long timeToLocation = Math.round(distanceWarehouseToLocation * 60_000);
				
				
				sendDrone(minDrone, droneCurrentTime, products, deliveryLocation, distanceWarehouseToLocation);
				arrivalTime = new Date(drones.get(minDrone).getTime() - timeToLocation);
				
				
				break;
			} else {
				
				// load drone with as much products as it can carry
				// returns map @toLoad with products to carry, meanwhile deleting them from @products
				Map<Product, Integer> toLoad = loadDrone(products, minDrone);
			
				// deliver the loaded drone
				double distanceWarehouseToLocation = distanceWarehouseDeliveryLocation(deliveryLocation);
				
				
				sendDrone(minDrone, droneCurrentTime, toLoad, deliveryLocation, distanceWarehouseToLocation);
				
			}
			// return Entry back to map
			//drones.put(minDrone, droneCurrentTime);
		}
		
		
		
		// return eta as string
		String estimatedETA = "Request ID: " + requestId + ", Delivery Location: " + deliveryLocation + " Request made at: " 
				+ requestTime.toString() + ", Delivery time: " + arrivalTime.toString();
		return estimatedETA; 
	}

	
	private Map.Entry<Drone, Date> findMin(Map<Drone, Date> drones, Location deliveryLocation) throws DroneException {
		long smallest = Long.MAX_VALUE;
		Map.Entry<Drone, Date> minEntry = null;
		
		long currentTimeToLocation = 0;
		for (Map.Entry<Drone, Date> entry : drones.entrySet()) {
			// check if the drones are capable (have big enough battery) to reaach the location and then come back to the warehouse
			if(entry.getKey().getBattery().getMaxBatteryLevel() >= distanceWarehouseDeliveryLocation(deliveryLocation) * 2) {
				
				currentTimeToLocation = timeToLocation(entry.getKey(), entry.getValue(), deliveryLocation);
				
				if(smallest > currentTimeToLocation) {
					smallest = currentTimeToLocation;
					minEntry = entry;
				}
			}
		}
		
		// no drone can reach this location 
		if(minEntry == null) {
			throw new DroneException("No drone can reach this location!");
		}
		
		drones.remove(minEntry.getKey());
		return minEntry;
	}

	private long timeToLocation(Drone currentDrone, Date warehouseArrivalTime, Location deliveryLocation) {
		
		long timeToLocation = 0;
		// get the time when the drone will be in the warehouse. if its already at the warehouse it's the current time
		if(warehouseArrivalTime.getTime() > System.currentTimeMillis()) {
			timeToLocation += warehouseArrivalTime.getTime();
			
		} else {
			timeToLocation += System.currentTimeMillis();

		}
		
		// get the time that would be needed  to charge the battery to get to the location and return to the warehouse
		int neededBattery = (int)Math.round(distanceWarehouseDeliveryLocation(deliveryLocation)* 2); 
		if(neededBattery > currentDrone.getBattery().getcurrentBatteryLevel()) {
			long chargingTime = getChargingTime(currentDrone, neededBattery);
			timeToLocation += chargingTime;
			
		}
		
		// get the time needed to get to the location
		double distanceWarehouseToLocation = distanceWarehouseDeliveryLocation(deliveryLocation);
		long timeWarehouseToLocation = Math.round(distanceWarehouseToLocation * 60_000);
		timeToLocation += timeWarehouseToLocation;
		

		return timeToLocation;
	}

	private long getChargingTime(Drone currentDrone, int neededBattery) {
		int batteryToCharge = neededBattery - currentDrone.getBattery().getcurrentBatteryLevel();
		
		return (long)(batteryToCharge / currentDrone.getChargingRate()) * 60_000;
		
	}

	private Map<Product, Integer> loadDrone(Map<Product, Integer> products, Drone drone) {
		int droneCapacity = drone.getWeightCapacity();
		int currentWeight = 0;
		
		// map to return
		Map<Product, Integer> resultMap = new HashMap<>();
		
		
		Iterator<Map.Entry<Product, Integer>> productsIter = products.entrySet().iterator();
		
		while(productsIter.hasNext()) {
			Map.Entry<Product, Integer> entry = productsIter.next();
			
			Product currentProduct = entry.getKey();
			int productQuantity = entry.getValue();
			
			for(int i = 0; i < productQuantity; i++) {
				// check if the current product can be carried by the drone; if yes - add it 
				if(currentWeight + currentProduct.getWeightPerQuantity() <= droneCapacity) {
					// add it to the result map
					if(resultMap.containsKey(currentProduct)) {
						int previousQuantity = resultMap.get(currentProduct);
						resultMap.put(currentProduct, previousQuantity + 1);
					} else {
						resultMap.put(currentProduct, 1);
					}
					// increment current weight
					currentWeight += currentProduct.getWeightPerQuantity();
					
					// decrement the value (count of product) by 1 in @products because we've just added it to resultmap
					// if value is 1, decrementing it will make it 0, so we just remove it
					if(products.get(currentProduct) == 1) {
						productsIter.remove();
					} else {
						int previousQuantity = products.get(currentProduct);
						products.put(currentProduct, previousQuantity - 1);
					}
				}
				
			}
		}
		
		return resultMap;
	}

	private void sendDrone(Drone drone, Date droneCurrentTime, Map<Product, Integer> productsToDeliver, Location deliveryLocation, double distanceWarehouseToLocation) {
		
		System.out.println("Old drone: " + drone);
		
		int updatedBatteryLevel = drone.getBattery().getcurrentBatteryLevel();
		
		
		
		long timeToWarehouse = 0;
		// get the time when the drone will be in the warehouse. if its already at the warehouse it's the current time
		if(droneCurrentTime.getTime() > System.currentTimeMillis()) {
			timeToWarehouse += droneCurrentTime.getTime();
		} else {
			timeToWarehouse += System.currentTimeMillis();
			
			//battery management
			int minutesAtTheWarehouse = (int)(System.currentTimeMillis() - droneCurrentTime.getTime()) / 60_000;
			int droneBattery = drone.getBattery().getcurrentBatteryLevel();
			while(droneBattery < drone.getBattery().getMaxBatteryLevel() || minutesAtTheWarehouse > 0) {
				updatedBatteryLevel += drone.getChargingRate();
				--minutesAtTheWarehouse;
			}
			//-
		}
		
		long chargingTime = 0;
		// get the time that would be needed  to charge the battery to get to the location and return to the warehouse
		int neededBattery = (int)Math.round(distanceWarehouseDeliveryLocation(deliveryLocation)* 2); 
		if(neededBattery > drone.getBattery().getcurrentBatteryLevel()) {
			chargingTime = getChargingTime(drone, neededBattery);
		}
		
		
		
		double distanceLocationToWarehouse = distanceWarehouseDeliveryLocation(deliveryLocation);
		// charge if needed
		updatedBatteryLevel += chargeBattery(drone, deliveryLocation);
		//substract the battery that would be needed to go to the location and come back 
		updatedBatteryLevel -= (int)(distanceLocationToWarehouse * 2);
		drone.setBatteryLevel(updatedBatteryLevel);
		
		
		// get the time needed to get to the location
		long timeToLocation = Math.round(distanceWarehouseToLocation * 60_000);
		
		
		int productsCount = 0;
		for (Map.Entry<Product, Integer> entry : productsToDeliver.entrySet()) {
			productsCount += entry.getValue();
		}
		
		System.out.println();
		System.out.println("Delivering products: " + productsToDeliver);
		System.out.println("At Warehouse: " + new Date(timeToWarehouse).toString());
		System.out.println("Start delivery: " + new Date(timeToWarehouse + chargingTime + productsCount * 60_000).toString());
		System.out.println("Delivery to location: " + new Date(timeToWarehouse + chargingTime + timeToLocation 
				+ productsCount * 2 * 60_000).toString());
		synchronized(drones) {
			drones.put(drone, new Date(timeToWarehouse + chargingTime + timeToLocation * 2
					+ productsCount * 2 * 60_000));
			
		}
		
		
		System.out.println("To Warehouse time: " + new Date(timeToWarehouse + chargingTime + timeToLocation * 2 
				+ productsCount * 2 * 60_000).toString());
		System.out.println("New drone: " + drone);
		System.out.println();
		
	}

	private int chargeBattery(Drone drone, Location deliveryLocation) {
		
		double distanceToLocation = distanceWarehouseDeliveryLocation(deliveryLocation);
		int neededBattery = (int)Math.round(distanceToLocation) * 2;
		int batteryToCharge = neededBattery - drone.getBattery().getcurrentBatteryLevel();
		
		if(batteryToCharge > 0) {
			return batteryToCharge;			
		} else {
			return 0;
		}
	}

	
	private double distanceWarehouseDeliveryLocation(Location deliveryLocation) {
		int xDelivery = deliveryLocation.getXCoordinate();
		int yDelivery = deliveryLocation.getYCoordinate();
		
		int xWarehouse = warehouse.getLocation().getXCoordinate();
		int yWarehouse = warehouse.getLocation().getYCoordinate();
		
		double distance = Math.sqrt( Math.pow((xDelivery - xWarehouse), 2) + Math.pow((yDelivery - yWarehouse), 2));
		// this one doesnt work
		//double distance = Math.pow(Math.pow((xWarehouse - xDelivery), 2) + Math.pow((yWarehouse - yDelivery), 2), -2);
		
		return distance;
	}
	
	// find the sum of all products' weights and check if they can be carried by one drone
	private boolean canCarryAll(Map<Product, Integer> products, Drone drone) {
		double allProductsWeight = getAllProductsWeight(products);
		return allProductsWeight <= drone.getWeightCapacity();
	}
	
	private double getAllProductsWeight(Map<Product, Integer> products) {
		double result = 0;
		
		for (Map.Entry<Product, Integer> product : products.entrySet()) {
			result += product.getKey().getWeightPerQuantity() * product.getValue();
		}
		return result;
	}

	
	public void addDrone() {
		
	}

}
