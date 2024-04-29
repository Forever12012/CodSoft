package Assignments;

import java.util.Scanner;

// ATM Assignment

public class ThirdAssignment {

	// Class for Bank Account
	static class BankAccount {
		
		private double accountBalance;
		
		// constructor to initialize the initial/starting balance
		public BankAccount(double initialBalance) {
			accountBalance = initialBalance;
		}
		
		// Deposit Method
		public void deposit(double amount)
		{
			accountBalance += amount;
			System.out.println("Deposited $" + amount + " successfully");
		}
		
		// Withdraw method
		public void withdraw(double amount) {
			if(amount <= accountBalance)
			{
				accountBalance -= amount;
				System.out.println("Withdrawn $" + amount + " successfully");
			}
			else
			{
				System.out.println("Insufficient Funds !!");
			}
		}
		
//		Check balance
		public void checkBalance()
		{
			System.out.println("Your current balance is : $" + accountBalance);
		}
	}
	
	// Class for ATM
	// This setup ensures that ATM class operates on specific bank accounts
	static class ATM
	{
		// this variable stores an instance to BankAccount class object
		private BankAccount bAccount;
		
		Scanner sc;
		
		// Used to initialize the 
		public ATM(BankAccount bAmount)
		{
			// this allows the ATM instance to associate with particular bank specific bank account
			this.bAccount = bAmount;
			sc = new Scanner(System.in);
		}
		
		public void displayMenu()
		{
			int choice;
			do {
				System.out.println("\nATM Menu :");
				System.out.println("1. Deposit Money");
				System.out.println("2. Withdraw Money");
				System.out.println("3. Check Balance");
				System.out.println("4. Exit");
				System.out.println("Enter your choice : ");
				choice = sc.nextInt();
				
				switch (choice) {
				case 1: 
					System.out.println("Enter the amount to be deposited : ");
					double depositAmount = sc.nextDouble();
					bAccount.deposit(depositAmount);
					break;
				
				case 2: 
					System.out.println("Enter the amount to be withdrawn : ");
					double withdrawAmount = sc.nextDouble();
					bAccount.withdraw(withdrawAmount);
					break;
				
				case 3: 
					bAccount.checkBalance();
					break;
				
				case 4:
					System.out.println("Thank you for using our bank");
					break;
	
				default :
					System.out.println("Invalid choice. Plese try again !");
				}
			}while(choice != 4);
		}
	}
	
	public static void main(String[] args) {
	
		// create a bank account with initial balance of 10000 
		BankAccount ba = new BankAccount(10000);
		
		// create an atm instance
		ATM atm = new ATM(ba);
		
		atm.displayMenu();
	}

}
