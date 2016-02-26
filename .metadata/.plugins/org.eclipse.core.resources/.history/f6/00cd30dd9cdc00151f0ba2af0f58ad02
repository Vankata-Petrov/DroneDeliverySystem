package droneDeliverySystem;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import basicClasses.BasicDrone;
import basicClasses.Location;
import basicClasses.Product;
import exceptions.DroneException;
import interfaces.Drone;
import managers.DroneManager;
/*<<<<<<< HEAD
=======
import managers.WarehouseManager;
import requests.RequestManager;
import requests.RequestProducer;
import requests.RequestsConsumer;
>>>>>>> 36df7563b32f527a216aea7294013e9807a44df7*/

public class Main {

	public static void main(String[] args) {
		
		Location location = new Location(54, 54);
		
		Drone firstDrone = new BasicDrone();
		Drone secondDrone = new BasicDrone();
		Drone thirdDrone = new BasicDrone();
		Drone fourthDrone = new BasicDrone();
		
		Map<Drone, Date> droneList = new ConcurrentHashMap<>();
		droneList.put(firstDrone, new Date(System.currentTimeMillis()));
		droneList.put(secondDrone, new Date(System.currentTimeMillis()));
		droneList.put(thirdDrone, new Date(System.currentTimeMillis()));
		droneList.put(fourthDrone, new Date(System.currentTimeMillis()));
		
		Product apple = new Product("apple", 10);
		Product banana = new Product("banana", 5);
		Product nescafe = new Product("nescafe", 8);
		Product milk = new Product("milk", 7);
		Product eggs = new Product("eggs", 4);
		
		
		Map<Product, Integer> products1 = new HashMap<>();
		products1.put(apple, 5);
		products1.put(banana, 3);
		products1.put(nescafe, 9);
		products1.put(milk, 2);
		products1.put(eggs, 20);
		
		
		Map<Product, Integer> products2 = new HashMap<>();
		products2.put(apple, 5);
		products2.put(banana, 3);
		products2.put(nescafe, 9);
		products2.put(milk, 2);
		products2.put(eggs, 20);
		
		Map<Product, Integer> products3 = new HashMap<>();
		products3.put(apple, 5);
		products3.put(banana, 3);
		products3.put(nescafe, 9);
		products3.put(milk, 2);
		products3.put(eggs, 20);
		
		Map<Product, Integer> products4 = new HashMap<>();
		products4.put(apple, 5);
		products4.put(banana, 3);
		products4.put(nescafe, 9);
		products4.put(milk, 2);
		products4.put(eggs, 20);
		
		Map<Product, Integer> products5 = new HashMap<>();
		products5.put(apple, 5);
		products5.put(banana, 3);
		products5.put(nescafe, 9);
		products5.put(milk, 2);
		products5.put(eggs, 20);
		
		/*RequestManager rm = new RequestManager();
		RequestProducer rp = new RequestProducer(rm);
		RequestsConsumer rc = new RequestsConsumer(rm);
		
		rp.start();
		rc.start();*/
		//rp.run();
		//rc.run();
		
	
		DroneManager d_manager = new DroneManager(droneList);
		try {
			System.out.println(d_manager.executeDelivery(products1, location, "0",new Date(System.currentTimeMillis())));
			System.out.println("===========================================================");
			System.out.println(d_manager.executeDelivery(products2, new Location(49, 49), "1", new Date(System.currentTimeMillis())));
			System.out.println("===========================================================");
			System.out.println(d_manager.executeDelivery(products3, new Location(120, 47), "2",new Date(System.currentTimeMillis())));
			System.out.println("===========================================================");
			System.out.println(d_manager.executeDelivery(products4, new Location(533, 503), "3",new Date(System.currentTimeMillis())));
			System.out.println("===========================================================");
			System.out.println(d_manager.executeDelivery(products5, new Location(112, 643), "4",new Date(System.currentTimeMillis())));
		} catch (DroneException e) {
			System.out.println(e.getMessage());
		}
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
