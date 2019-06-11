package sheet4.prison;

public class PrisonSimulator {

	public static void main(String[] args) {
		simulateOneConfiguration();
		findNeededNumberOfGuards();
	}
	
	/*
	 * Task 3 i, ii, iii
	 */
	private static void simulateOneConfiguration() {
		Prison prison = new Prison(createGuards(24));
		startSimulation(prison, 50, 1000);
	}
	
	
	/*
	 * Task 3 iv, v
	 */
	private static void findNeededNumberOfGuards() {
		System.out.println("\n----Calculating needed number of guards----");
		
		for (int nGuards = 24; nGuards < 50; nGuards++) {
			Prison prison = new Prison(createGuards(nGuards)); 
			boolean prisonIsSave = true; 
			// The result of the simulation has to be "Save" for at least 10 simulation passes 
			for (int iSimulation = 0; iSimulation < 10; iSimulation++) {
				prisonIsSave = startSimulation(prison, 50, 1000);
				if(!prisonIsSave)
					iSimulation = 10; 
			}
			
			if(prisonIsSave) {
				System.out.println("The Prison was save for 10 runs. The number of needed guards is: " + nGuards);
				nGuards = 500;
			} else {
				System.out.println("The prison was unsave using " + nGuards + " guards. Let's try " + (nGuards+1) + "\n");
			}
		}
	}
	
	
	private static Guard[] createGuards(int numberOfGuards) {
		Guard[] guards = new Guard[numberOfGuards];

		for (int i = 0; i < guards.length; i++) {
			// Math.random()*(max - min + 1) + min)
			guards[i] = new Guard((int) (Math.random() * (55 - 18 + 1) + 18));
		}
		return guards;
	}

	
	private static boolean startSimulation(Prison prison, int numberOfSimulations, int numberOfDays) {
		boolean prisonIsSave = true;
		int saveSimulations = 0;
		int firstUnsaveDay = Integer.MAX_VALUE;

		for (int s = 0; s < numberOfSimulations; s++) {
			prisonIsSave = true;
			for (int d = 0; d < numberOfDays; d++) {
				prisonIsSave = (prisonIsSave && prison.isSafe());
				if (!prisonIsSave)
					firstUnsaveDay = Math.min(firstUnsaveDay, d);
				prison.nextDay();
			}
			if (prisonIsSave)
				saveSimulations++;
		}
		
		System.out.println("The prison was safe " + saveSimulations + " out of " + numberOfSimulations + " times");
		if (firstUnsaveDay < Integer.MAX_VALUE)
			System.out.println("The earliest jail break happened after " + firstUnsaveDay + " days.");

		return saveSimulations == numberOfSimulations;
	}
}