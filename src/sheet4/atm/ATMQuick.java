package sheet4.atm;

public class ATMQuick {

	private double balance;

	public ATMQuick(double balance) {
		this.balance = balance;
	}

	public void topup(double amount) {
		if(amount < 0) 
			throw new IllegalArgumentException("Amount is neagative"); 
		this.balance += amount; 
	}

	public void withdraw(double amount) {
		if(balance < amount)
			throw new IllegalArgumentException("Limit exceeded");
		else if(amount < 0) 
			throw new IllegalArgumentException("Amount is neagative"); 
		else 
			balance -= amount; 
	}

	public double credit() {
		return this.balance; 
	}
}


