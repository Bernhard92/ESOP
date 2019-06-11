package sheet4.prison;

public class Guard {
	private int age; 
	private boolean isSick;
	
	
	public Guard(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
	
	public boolean isSick() {
		return isSick;
	}
	
	public void nextDay() {
		isSick = Math.random() < 0.15; 
	}

	
}
