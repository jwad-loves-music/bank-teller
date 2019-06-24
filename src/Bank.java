
// Name: Joseph Wadley
// Assignment: PA11+12 Bank and Bank Account
// Description: This class defines a BankAccount object 
// Time spent: 3.5 hours
public class Bank {
	private BankAccount[] accounts;
	private int count;

	public Bank(int size) {
		accounts = new BankAccount[size];
		count = 0;

	}

	private int indexOf(BankAccount a) {
		for (int i = 0; i < count; i++) {
			if (accounts[i].equals(a)) {
				return i;
			}
		}
		return -1;
	}

	private void doubleCapacity() {
		BankAccount[] accountstemp = new BankAccount[accounts.length * 2];
		for (int i = 0; i < accounts.length; i++) {
			accountstemp[i] = accounts[i];
			accounts = accountstemp;
		}

	}

	public boolean add(BankAccount a) {
		if (indexOf(a) >= 0) {
			return false;
		}
		if (accounts.length <= count) {
			doubleCapacity();
		}
		accounts[count] = a;
		count++;
		return true;
	}

	public boolean remove(BankAccount a) {
		if (indexOf(a) == -1) {
			return false;
		}
		int place = indexOf(a);
		accounts[place] = accounts[count-1];
		accounts[count-1] = null;
		count--;
		return true;
	}

	public boolean contains(BankAccount a) {
		if (indexOf(a) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public BankAccount find(int acct) {
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNumber() == acct) {
				return accounts[i];
			}
		}
		return null;
	}

	public int getCount() {
		return count;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(accounts[i].toString());
			sb.append("\n**********\n");
		}
		return sb.toString();
	}

	public void sort() {
		for (int i = 0; i < count - 2; i++) {
			int min = i;
			for (int j = i + 1; j < count - 1; j++) {
				if (accounts[j].getAccountNumber() < accounts[min].getAccountNumber())
					min = j;
			}
			BankAccount temp = accounts[i];
			accounts[i] = accounts[min];
			accounts[min] = temp;

		}

	}
}
