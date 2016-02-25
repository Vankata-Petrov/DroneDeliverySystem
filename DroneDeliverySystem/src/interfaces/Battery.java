package interfaces;

public interface Battery {
	public int getMaxBatteryLevel();
	public int getcurrentBatteryLevel();
	public void setCurrentBatteryLevel(int currentBattery);
	public int getChargingRate();
	
}
