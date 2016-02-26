package droneDeliverySystem;

public class Drone {
	
	private static int count=0;	
	private final int ID;
	private final int weightCapacity;
	private final int maxBatteryLevel;
	private int currentBatteryLevel;
	private final int chargingRate;
	
	public Drone(int ID, int maxBattery, int capacity, int chargingRate) {
		this.ID = count;
		this.maxBatteryLevel = maxBattery;
		currentBatteryLevel = maxBatteryLevel;
		this.weightCapacity = capacity;
		this.chargingRate = chargingRate;
		count++;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public void setBatteryLevel(int currentLevel) {
		currentBatteryLevel = currentLevel;
	}
	
	public int getBattery() {
		return this.currentBatteryLevel;
	}
	
	public int getMaxBattery() {
		return this.maxBatteryLevel;
	}
	
	public int getCapacity() {
		return this.weightCapacity;
	}
	
	public int getChargingRate() {
		return this.chargingRate;
	}
	
	@Override
	public String toString() {
		String result = "Drone[ID: " + ID + ", Weight Capacity: " + weightCapacity + ", Max Battery Level: " + maxBatteryLevel +
				", Current Battery Level: " + currentBatteryLevel + ", Charging rate:" + chargingRate + "]";
		return result;
	}

}
