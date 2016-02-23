package droneDeliverySystem;

import java.util.Date;
import java.util.Map;

public interface Request {
	String getID();
	Date getTimestamp();
	Map<Product, Integer> getProducts();
}
