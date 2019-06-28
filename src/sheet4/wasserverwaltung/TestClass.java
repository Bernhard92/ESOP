package sheet4.wasserverwaltung;

public class TestClass {
	
	public static void main(String[]args) {
		WaterWork waterWork = new WaterWork(); 
		waterWork.addWater(5, 315);
		waterWork.addWater(6, 315); 
		waterWork.addWater(7, 315); 
		
		waterWork.addWater(5, 300); 
		
		System.out.println(waterWork.getTotalWaterLevel());
	}
}
