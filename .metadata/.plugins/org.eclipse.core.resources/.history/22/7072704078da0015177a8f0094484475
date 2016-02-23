package droneDeliverySystem;

public class RequestsConsumer extends Thread {
	
	private RequestManager requestManager;
	private WarehouseManager warehouseManager;
	private DroneManager droneManager;
	
	public RequestsConsumer(RequestManager requestManager) {
		this.requestManager = requestManager;
	}
	
	public void run() {
		Request request = requestManager.sendRequest();
		if(request.getClass().getSimpleName() == "DeliveryRequest") {
			
			if(warehouseManager.productsAvailabilityChecker(request.getProducts())) {
				droneManager.manageDelivery(request.getLocation(), request.getProducts());
			}
			
		} else {
			warehouseManager.supply(request.getProducts());
		}
	}
	
	
	
}
