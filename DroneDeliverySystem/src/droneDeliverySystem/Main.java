package droneDeliverySystem;

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
	}

}
