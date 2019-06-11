package sheet4.atm;

public class ATMQuickTest {
	public static void main(String[] args) {
		ATMQuick bankAccount = new ATMQuick(3000);
		System.out.println(bankAccount.credit());
		
		bankAccount.topup(1000);
		bankAccount.withdraw(200);
		
		System.out.println(bankAccount.credit());
		
		bankAccount.withdraw(-500);
		System.out.println(bankAccount.credit());
		
		
	}
}
