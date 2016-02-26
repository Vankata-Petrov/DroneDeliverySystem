package droneDeliverySystem;

import interfaces.Battery;

public class AverageBattery implements Battery{
	private final int MAX_BATTERY_LEVEL;
	private int currentBatteryLevel;
	private final int chargingRate;
	
	public AverageBattery() { 
		MAX_BATTERY_LEVEL = 2000;
		currentBatteryLevel = MAX_BATTERY_LEVEL;
		chargingRate = 5;
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
