
// Name: Joseph Wadley
// Assignment: PA11+12 Bank and Bank Account
// Description: This class defines a BankAccount object 
// Time spent: 2.5 hours
import java.util.Date;
import java.util.Random;

public class BankAccount {
	private String name;
	private double balance;
	private int acctNum;
	private Date date;
	private static int accountsCreated;

	public BankAccount(String name) {
		this.name = name;
		acctNum = generateAcctNum();
		date = new Date();
		accountsCreated++;
	}

	public double getBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return acctNum;
	}

	public boolean deposit(double amt) {
		if (amt < 0)
			return false;
		this.balance += amt;
		return true;
	}

	public boolean withdraw(double amt) {
		if (amt < 0 || amt > this.balance)
			return false;
		this.balance -= amt;
		return true;
	}

	public boolean transfer(BankAccount that, double amt) {
		if (amt > balance || amt <= 0) {
			return false;
		}
		this.balance -= amt;
		that.balance += amt;
		return true;
	}

	public String toString() {
		return name + " [" + acctNum + "]\n" + date + "\n" + String.format("$%,.2f", balance);
	}

	public boolean equals(BankAccount that) {
		return this.acctNum == that.acctNum;
	}

	private int generateAcctNum() {
		return (int) (Math.random() * 900000000) + 100000000;
	}

	public static int getAccountsCreated() {
		return accountsCreated;
	}

}