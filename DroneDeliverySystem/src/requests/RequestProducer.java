package requests;

import droneDeliverySystem.Parser;
import interfaces.Request;

public class RequestProducer extends Thread {

	private RequestManager requestManager;
	private Parser parser;
	
	public RequestProducer(RequestManager requestManager) {
		this.requestManager = requestManager;
	}
	
	public void run() {
		while (true) {
			Request request1 = parser.createSupplyRequest();
			Request request2 = parser.createDeliveryRequest();
			requestManager.addRequest(request1);
			requestManager.addRequest(request2);
		}
	}
	
}
