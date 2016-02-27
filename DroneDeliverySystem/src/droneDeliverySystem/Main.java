package droneDeliverySystem;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import basicClasses.BasicDrone;
import basicClasses.Location;
import basicClasses.Product;
import basicClasses.Warehouse;
import exceptions.DroneException;
import interfaces.Drone;
import managers.DroneManager;

import managers.WarehouseManager;
import requests.RequestManager;
import requests.RequestProducer;
import requests.RequestsConsumer;


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
		
		
		Map<Product, Integer> products1 = new ConcurrentHashMap<>();
		products1.put(apple, 5);
		products1.put(banana, 3);
		products1.put(nescafe, 9);
		products1.put(milk, 2);
		products1.put(eggs, 20);
		
		
		Map<Product, Integer> products2 = new ConcurrentHashMap<>();
		products2.put(apple, 5);
		products2.put(banana, 3);
		products2.put(nescafe, 9);
		products2.put(milk, 2);
		products2.put(eggs, 20);
		
		Map<Product, Integer> products3 = new ConcurrentHashMap<>();
		products3.put(apple, 5);
		products3.put(banana, 3);
		products3.put(nescafe, 9);
		products3.put(milk, 2);
		products3.put(eggs, 20);
		
		//WarehouseManager wm = new WarehouseManager();
		//wm.add();
		//wm.supply(products3);
		//wm.productsAvailabilityChecker(products3);
		
		RequestManager rm = new RequestManager();
		RequestProducer rp = new RequestProducer(rm, new File("/home/nikola/go.txt"));
		RequestsConsumer rc = new RequestsConsumer(rm);
		
		rp.start();
		rc.start();
		
		//Parser p = new Parser();
		
		//Request r = p.createRequest();
		
		/*DroneManager d_manager = new DroneManager(droneList);
		d_manager.executeDelivery(products, location, "0",new Date(System.currentTimeMillis()));
		d_manager.executeDelivery(products, new Location(32, 49), "1", new Date(System.currentTimeMillis()));
		d_manager.executeDelivery(products, new Location(120, 47), "2",new Date(System.currentTimeMillis()));
		d_manager.executeDelivery(products, new Location(533, 2412), "3",new Date(System.currentTimeMillis()));
		d_manager.executeDelivery(products, new Location(112, 643), "4",new Date(System.currentTimeMillis()));
		DroneManager d_manager = new DroneManager(droneList);
		d_manager.executeDelivery(products, location, "232");*/
		
		
		Map<Product, Integer> products4 = new ConcurrentHashMap<>();
		products4.put(apple, 5);
		products4.put(banana, 3);
		products4.put(nescafe, 9);
		products4.put(milk, 2);
		products4.put(eggs, 20);
		
		Map<Product, Integer> products5 = new ConcurrentHashMap<>();
		products5.put(apple, 5);
		products5.put(banana, 3);
		products5.put(nescafe, 9);
		products5.put(milk, 2);
		products5.put(eggs, 20);	
		
		Date parsedDate = null;
	
		/*DroneManager d_manager = new DroneManager(droneList, new Warehouse(new Location(42, 42)));
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
		}*/
		
		
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

