package lab06;

public class BankAccount {
	private double balance;
	private int idNum;
	private static int numAccounts = 0;
	
	public BankAccount(double aBalance) {
		balance = aBalance;
		if (balance < 0) {
			throw new IllegalArgumentException("Balance cannot be negative");
		}
		idNum = numAccounts;
		numAccounts++;
	}

	static void reset() {
		numAccounts = 0;
	}
	
	public double getBalance() {
		return balance;
	}

	public int getIdNum() {
		return idNum;
	}
	
	@Override
	public String toString() {
		return "Acct. #" + idNum + " has $" + balance;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public double withdraw(double amount) {
		double withdrawal = amount;
		if(balance < amount) {
			withdrawal = balance;
		}
		balance = balance - withdrawal;
		return withdrawal;
	}
}
