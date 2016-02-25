package droneDeliverySystem;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import interfaces.Request;

public class SupplyRequest implements Request {

	private String id;
	private Date timestamp;
	private Map<Product, Integer> products;
	
	public SupplyRequest(Date timestamp, Location location, Map<Product, Integer> products) {
		id = UUID.randomUUID().toString();
		this.timestamp = timestamp;
		this.products = products;
	}
	
	
	@Override
	public String getID() {
		return id;
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public Map<Product, Integer> getProducts() {
		return products;
	}


	@Override
	//We don't need it here
	public Location getLocation() {
		return null;
	}
	
}
