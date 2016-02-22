package droneDeliverySystem;

public class Drone {
	
	private static int count=0;	
	private final int ID;
	private int batteryLevel;
	private final int capacity;
	private final int chargingRate;
	
	public Drone(int ID, int battery, int capacity, int chargingRate) {
		this.ID = count;
		this.batteryLevel = battery;
		this.capacity = capacity;
		this.chargingRate = chargingRate;
		count++;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public void setBatteryLevel(int currentLevel) {
		batteryLevel = currentLevel;
	}
	
	public int getBattery() {
		return this.batteryLevel;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public int getChargingRate() {
		return this.chargingRate;
	}

}
