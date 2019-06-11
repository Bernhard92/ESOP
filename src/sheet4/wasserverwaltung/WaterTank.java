package sheet4.wasserverwaltung;

public class WaterTank {
	
	private static final double MAX_LEVEL = 500;
	
	private double waterLevel;
		
	public double getWaterLevel() {
		return waterLevel; 
	}
	
	public double addWater(double liters) {
		double residue = MAX_LEVEL - waterLevel + liters;
		waterLevel = Math.min(MAX_LEVEL, waterLevel + liters); 
		return residue < 0 ? residue*-1 : 0.0;  
	}
}
