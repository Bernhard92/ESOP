package sheet4.wasserverwaltung;

public class WaterTank {
	
	private double waterLevel;
	private double maxLevel;
	
	WaterTank(double maxLevel) {
		this.maxLevel = maxLevel; 
	}
	
	public double getWaterLevel() {
		return waterLevel; 
	}
	
	public double addWater(double liters) {
		double residue = maxLevel - waterLevel + liters;
		waterLevel = Math.min(maxLevel, waterLevel + liters); 
		return residue < 0 ? residue*-1 : 0.0;  
	}
}
