package sheet4.prison;

public class Prison {
	
	private Guard[] guards;

	public Prison(Guard[] guards) {
		this.guards = guards;
	} 
	
	public void nextDay() {
		for (Guard guard : guards) {
			guard.nextDay();
		}
	}
	
	public boolean isSafe() {
		int healthyGuards = 0;
		int experiencedGuards = 0; 
		
		for(Guard guard : guards) {
			if (!guard.isSick()) {
				healthyGuards++; 
				if (guard.getAge() > 40) {
					experiencedGuards++; 
				}
			}
		}
		return healthyGuards >= 15 && experiencedGuards >= 2; 
	}
}
