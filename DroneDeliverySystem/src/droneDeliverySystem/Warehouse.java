package droneDeliverySystem;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
	private final Location warehouseLocation;
	private Map<Product, Integer> availableProducts;
	
	public Warehouse(Location warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
		availableProducts=new HashMap<>();
	}

	public Location getLocation() {
		return warehouseLocation;
	}
	
	public boolean isProductAvailable(Product product, int quantity) {
		if(availableProducts.containsKey(product)) {
			int quantityInWarehouse = availableProducts.get(product);
			return quantityInWarehouse >= quantity;
		} 
		return false;
	}
	
	public void takeProduct(Product product, int quantity) {
		if(isProductAvailable(product, quantity)) {
			int originalQuantity = availableProducts.get(product);
			int newQuantity = originalQuantity - quantity;
			
			availableProducts.put(product, newQuantity);
		} else {
			//TODO exception maybe?
		}
	}
	
	public void supply(Product product, int quantity) {
		
		if(availableProducts.containsKey(product)) {
			int previousQuantity = availableProducts.get(product);
			availableProducts.put(product, previousQuantity + quantity);
		} else {
			availableProducts.put(product, quantity);
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(warehouseLocation.getXCoordinate())+
				String.valueOf(warehouseLocation.getYCoordinate())
				).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Warehouse)) {
			return false;
		}
		Warehouse secondWarehouse=(Warehouse)obj;
		
		if(warehouseLocation.getXCoordinate()==secondWarehouse.warehouseLocation.getXCoordinate()){
			if(warehouseLocation.getYCoordinate()==secondWarehouse.warehouseLocation.getYCoordinate()){
				return true;
			}
		}
		return false;
	}
	
}
