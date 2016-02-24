package droneDeliverySystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import managers.DroneManager;

public class Main {

	public static void main(String[] args) {
		
		Location location = new Location(43, 43);
		
		Drone firstDrone = new Drone(5, 2000, 100, 5);
		Drone secondDrone = new Drone(5, 2000, 100, 5);
		Drone thirdDrone = new Drone(5, 2000, 100, 5);
		Drone fourthDrone = new Drone(5, 2000, 100, 5);
		
		Map<Drone, Date> droneList = new ConcurrentHashMap<>();
		droneList.put(firstDrone, new Date(System.currentTimeMillis()));
		//droneList.put(secondDrone, new Date(System.currentTimeMillis()));
		//droneList.put(thirdDrone, new Date(System.currentTimeMillis()));
		//droneList.put(fourthDrone, new Date(System.currentTimeMillis()));
		
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
		d_manager.executeDelivery(products, location, "0",new Date(System.currentTimeMillis()));
		d_manager.executeDelivery(products, new Location(32, 49), "1", new Date(System.currentTimeMillis()));
		d_manager.executeDelivery(products, new Location(120, 47), "2",new Date(System.currentTimeMillis()));
		d_manager.executeDelivery(products, new Location(533, 2412), "3",new Date(System.currentTimeMillis()));
		d_manager.executeDelivery(products, new Location(112, 643), "4",new Date(System.currentTimeMillis()));
		//Trying the WarehouseManager
		/*
		Map<Product,Integer> productsToDeliver=new HashMap();
		productsToDeliver.put(eggs,4);
		Date d = new Date(2016, 02, 23);
		Request sr = new SupplyRequest(d, new Location(42,42), products);
		Request dr = new DeliveryRequest(d, location,productsToDeliver);
		WarehouseManager.warehouses.add(warehouse);
		WarehouseManager.doRequest(sr);
		WarehouseManager.doRequest(dr);
		for(Warehouse x:WarehouseManager.warehouses){
			System.out.println(x.isProductAvailable(eggs, 1));
		}*/
	}
}
/*=======
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Location location = new Location(1, 1);
		Product p = new Product("Bread", 1);
		Map<Product, Integer> products = new HashMap<>();
		products.put(p, 1);
		@SuppressWarnings("deprecation")
		Date d = new Date(2016, 02, 23);
		Request dr = new DeliveryRequest(d, location, products);
		Request sr = new SupplyRequest(d, location, products);
		System.out.println(dr.getClass().getSimpleName());
		System.out.println(sr.getClass().getSimpleName());
>>>>>>> 43de9819fb9b522f3cdf904971cd62e86870b602
	}

}*/
