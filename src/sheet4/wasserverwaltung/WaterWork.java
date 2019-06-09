package sheet4.wasserverwaltung;

public class WaterWork {

	private final int NUMBER_OF_WATER_TANKS = 15;
	private WaterTank[] waterTanks;

	WaterWork() {
		waterTanks = new WaterTank[NUMBER_OF_WATER_TANKS];

		for (int i = 0; i < waterTanks.length; i++) {
			waterTanks[i] = new WaterTank(2000); 
		}
	}

	public double getTotalWaterLevel() {
		double totalLevel = 0;
		for (WaterTank tank : waterTanks) {
			totalLevel += tank.getWaterLevel();
		}
		return totalLevel;
	}

	public double addWater(int tank, double liter) throws IllegalArgumentException {
		return waterTanks[tank].addWater(liter);
	}
}
