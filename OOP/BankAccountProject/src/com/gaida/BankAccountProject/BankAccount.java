package com.gaida.BankAccountProject;
import java.util.ArrayList;

public class BankAccount {
	
	private double checkingBalance=0.00;
	private double savingsBalance=0.00;
	private static int totalAccounts=0;
	private static double totalAmount=0.00;
	private static ArrayList<Long> accountIDs = new ArrayList<Long>() ; 
	private long accountNumber; 
	
	public BankAccount() {
		totalAccounts+=1;
		setAccountNumber();
	}
	
	public BankAccount(double checking,double saving) {
		this.checkingBalance = checking;
		this.savingsBalance = saving;
		totalAccounts+=1;
		totalAmount+=saving+checking;		
		setAccountNumber();
	}
	
	
	// set account number at random... make sure it does not already exits, if it does recursive call to get a unique number. 
	private void setAccountNumber() {
		
		
		System.out.println("TEST NUMBER Random: "+Math.random()*100000);
		this.accountNumber=  Math.round(Math.random()*100000);
		
		System.out.println(this.accountNumber+"ACCOUNT NUMBER");
		System.out.println(this.accountNumber + "Generated Account number");
		if(!accountIDs.isEmpty()) {
			if(accountIDs.indexOf(this.accountNumber)>=0) {
				setAccountNumber();
				
			}
			else {
				accountIDs.add(this.accountNumber);
//				
			}
		}
		else {
			accountIDs.add(accountNumber);
		}
		System.out.println("your account number is:" +accountIDs);
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public static double accountsInHouse() {
		return totalAccounts;
	}
	
	public static double bankAssetVolume() {
		return totalAmount;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public boolean deposit(boolean checking,double amount) {
		if(amount>=0) {
			if(checking) {
				this.checkingBalance+=amount;
			}
			else {
				this.savingsBalance+=amount;
			}
			
			totalAmount+=amount;
			return true;
		}
		else {
			System.out.println("deposits must be a positive number");
			return false;
		}
	}
	
	public boolean withdraw(boolean checking, double amount) {
		boolean success = false;
		if(amount>=0) {
			
			if(checking && this.checkingBalance>=amount) {
				this.checkingBalance-=amount;
				totalAmount-=amount;
				success = true; 
			}
			else if(!checking && this.savingsBalance>=amount) {
				this.savingsBalance-=amount;
				totalAmount -=amount;
				success=true;
				}
				else if(checking){
					System.out.println("you don't have enough cash in checking to make this withdrawl");
				}
				else {
					System.out.println("you don't have enough cash in savings to make this withdrawl");
				}
					
			
						
		}
		else {
			System.out.println("please provide witdrawl amount as a positve number");
		}
		return success;
	}
	
	
	public void display() {
		System.out.println(String.format("Your Money:\nChecking Bal: %,.2f \nSaving Bal: %,.2f", this.checkingBalance,this.savingsBalance));
	}
	
	
	
	
	
	
	
	
}
