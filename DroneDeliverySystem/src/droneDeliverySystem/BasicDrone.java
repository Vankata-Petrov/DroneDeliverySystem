package droneDeliverySystem;

import java.util.UUID;

import interfaces.Battery;
import interfaces.Drone;

public class BasicDrone implements Drone{
	
	private final String ID;
	private int weightCapacity;
	private Battery battery;
	
	public BasicDrone() {
		this(new AverageBattery(), 500);
	}
	
	public BasicDrone(Battery battery, int weightCapacity) {
		this.ID = UUID.randomUUID().toString();
		this.battery = battery;
		this.weightCapacity = weightCapacity;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public Battery getBattery() {
		return battery;
	}
	
	public int getWeightCapacity() {
		return this.weightCapacity;
	}
	
	public void setBatteryLevel(int currentLevel) {
		battery.setCurrentBatteryLevel(currentLevel);
	}
	
	public int getCurrentBatteryLevel() {
		return battery.getcurrentBatteryLevel();
	}
	
	
	public int getMaxBatteryCapacity() {
		return battery.getMaxBatteryLevel();
	}
	
	
	public int getChargingRate() {
		return battery.getChargingRate();
	}
	
	@Override
	public String toString() {
		String result = "Drone[ID: " + ID + ", Weight Capacity: " + weightCapacity + ", Max Battery Level: " + battery.getMaxBatteryLevel() +
				", Current Battery Level: " + battery.getcurrentBatteryLevel() + ", Charging rate:" + battery.getChargingRate() + "]";
		return result;
	}

	@Override
	public void setBattery(Battery newBattery) {
		this.battery = newBattery;
	}

	@Override
	public void setWeightCapacity(int weightCapacity) {
		this.weightCapacity = weightCapacity;
	}

}
