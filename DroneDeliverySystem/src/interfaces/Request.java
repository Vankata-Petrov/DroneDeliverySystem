package interfaces;

import java.util.Date;
import java.util.Map;

import basicClasses.Location;
import basicClasses.Product;

public interface Request {
	String getID();
	Date getTimestamp();
	Map<Product, Integer> getProducts();
	// Think it will be useful
	Location getLocation();
}
