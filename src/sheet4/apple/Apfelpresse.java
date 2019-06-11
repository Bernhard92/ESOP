package sheet4.apple;

public class Apfelpresse {

	private double litersPressed;
	private double can;

	public Apfelpresse(int can) {
		this.can = can;
	}

	public void presse(Apfel apfel) {
		litersPressed = Math.min(can,
				litersPressed + apfel.getWeight() * 0.001 * apfel.getLiquidityRatio()); 		
	}
	
	public double getTotalApfelsaft() {
		return litersPressed; 
	}
	
	public double leereKanister() {
		double liters = litersPressed; 
		this.litersPressed = 0;
		return liters; 
	}
}
