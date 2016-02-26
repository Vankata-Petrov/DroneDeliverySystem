package droneDeliverySystem;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import interfaces.Request;

public class DeliveryRequest implements Request{
	
	private String id;
	private Date timestamp;
	private Location location;
	private Map<Product, Integer> products;
	
	public DeliveryRequest(Date timestamp, Location location, Map<Product, Integer> products) {
		id = UUID.randomUUID().toString();
		this.timestamp = timestamp;
		this.location = location;
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
	public Location getLocation() {
		return location;
	}

}
