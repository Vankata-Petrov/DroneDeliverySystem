package droneDeliverySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import managers.DroneManager;

public class Main {

	public static void main(String[] args) {
		
		Location location = new Location(43, 43);
		Warehouse warehouse = new Warehouse(new Location(42, 42));
		
		Drone firstDrone = new Drone(5, 2000, 100, 5);
		Drone secondDrone = new Drone(5, 2000, 100, 5);
		Drone thirdDrone = new Drone(5, 2000, 100, 5);
		Drone fourthDrone = new Drone(5, 2000, 100, 5);
		
		List<Drone> droneList = new ArrayList<>();
		droneList.add(firstDrone);
		droneList.add(secondDrone);
		droneList.add(thirdDrone);
		droneList.add(fourthDrone);
		
		Product apple = new Product("apple", 10);
		Product banana = new Product("banana", 5);
		Product nescafe = new Product("nescafe", 8);
		Product milk = new Product("milk", 7);
		Product eggs = new Product("eggs", 4);
		
		
		Map<Product, Integer> products = new HashMap<>();
		products.put(apple, 5);
		products.put(banana, 3);
		products.put(nescafe, 9);
		products.put(milk, 2);
		products.put(eggs, 20);
		
		
		DroneManager d_manager = new DroneManager(droneList);
		d_manager.executeDelivery(products, location, "232");
		
	}

}
