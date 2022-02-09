package com.gaida.BankAccountProject;

public class Banking {

	public static void main(String[] args) {

		BankAccount myAccount = new BankAccount(100.50,200);
		BankAccount yourAccount = new BankAccount(345.90,500);
		
		myAccount.deposit(true, 50);
		myAccount.withdraw(true, 50);
		
		myAccount.display();
		
		System.out.println(BankAccount.accountsInHouse());
		System.out.println(BankAccount.bankAssetVolume());

	}

}
