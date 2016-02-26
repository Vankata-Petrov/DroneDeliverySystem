package droneDeliverySystem;

import interfaces.Battery;

public class ChineseBattery implements Battery{
	private final int MAX_BATTERY_LEVEL;
	private int currentBatteryLevel;
	private final int chargingRate;
	
	public ChineseBattery() { 
		MAX_BATTERY_LEVEL = 1200;
		currentBatteryLevel = MAX_BATTERY_LEVEL;
		chargingRate = 3;
	}
	
	
	@Override
	public int getMaxBatteryLevel() {
		return MAX_BATTERY_LEVEL;
	}
	@Override
	public int getcurrentBatteryLevel() {
		return currentBatteryLevel;
	}
	@Override
	public void setCurrentBatteryLevel(int currentBattery) {
		currentBatteryLevel = currentBattery;
	}
	@Override
	public int getChargingRate() {
		return chargingRate;
	}
}
