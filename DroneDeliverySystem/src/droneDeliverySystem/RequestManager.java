package droneDeliverySystem;

import java.util.LinkedList;

public class RequestManager {
	
	private LinkedList<Request> requests;
	
	public Request getFront() {
		return requests.poll();
	}
	
	
	/**
	 * Adding supply requests in front of the queue to send them first
	 * Adding delivery requests at the end for later use
	 * @param request
	 */
	public void addRequest(Request request) {
		if(request.getClass().getSimpleName() == "DeliveryRequest") {
			requests.add(request);
		} else {
			requests.addFirst(request);
		}
		notifyAll();
	}
	
	public Request sendRequest() {
		while(requests.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return requests.poll();		
		
	}
	

}
