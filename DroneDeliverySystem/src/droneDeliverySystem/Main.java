package droneDeliverySystem;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import managers.DroneManager;
import managers.WarehouseManager;
import requests.RequestManager;
import requests.RequestProducer;
import requests.RequestsConsumer;

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
		
		RequestManager rm = new RequestManager();
		RequestProducer rp = new RequestProducer(rm);
		RequestsConsumer rc = new RequestsConsumer(rm);
		
		rp.start();
		rc.start();
		//rp.run();
		//rc.run();
		
		
		//DroneManager d_manager = new DroneManager(droneList);
		//d_manager.executeDelivery(products, location, "232");
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
