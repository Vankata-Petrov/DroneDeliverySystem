package droneDeliverySystem;

public class Product {
	
	private final String mName;
	private final double mWeightPerQuantity;
	
	public Product(String name, double weightPerQuantity) {
		mName = name;
		mWeightPerQuantity = weightPerQuantity;
	}

	public String getName() {
		return mName;
	}

	public double getWeightPerQuantity() {
		return mWeightPerQuantity;
	}
	
	@Override
	public String toString() {
		String result = "Product [Name: " + mName + ", Weight: " + mWeightPerQuantity +"]";
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		
		if(this.mName.equals(other.mName) && 
				Math.abs(this.mWeightPerQuantity - other.mWeightPerQuantity) < 0.0001) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		//TODO better hash code function maybe?
		return mName.hashCode();
	}

}
