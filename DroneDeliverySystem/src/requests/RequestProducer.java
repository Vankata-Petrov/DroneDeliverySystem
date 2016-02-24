package requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import droneDeliverySystem.Location;
import droneDeliverySystem.Parser;
import droneDeliverySystem.Product;
import droneDeliverySystem.Request;
import droneDeliverySystem.SupplyRequest;

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
