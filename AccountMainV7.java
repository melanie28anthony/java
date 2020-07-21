package com.montran.main;
import java.util.Scanner;
import com.montran.pojo.Current;
import com.montran.pojo.Saving;

public class AccountMainV7 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int accountNumber;
		String name;
		double balance;
		double amount=0;
		int trainsactionChoice;
		String continueChoice;
		int accountChoice;
		boolean isSalary = false;
		boolean issavings=false;
		boolean result;
		double overdraftBalance=0;
		Saving savings= null;
		Current current= null;
		
System.out.println(" Hello Welcome to XYZ Bank !!");
System.out.println("Menu");
System.out.println("1.. Savings");
System.out.println("2.. Current");
System.out.println("Enter your choice");
accountChoice = scanner.nextInt();

		switch (accountChoice) {
		case 1:
			issavings= true;
			System.out.println("Do you want to open salary account (true-false)");
			isSalary = scanner.nextBoolean();
			break;
			
		case 2:
			issavings = false;
			System.out.println("enter overdraft value");
			overdraftBalance= scanner.nextDouble();
			break;
		
		default:
			System.out.println("INavlid choice");
			break;
		}
		
		

		System.out.println("Enter account Number");
		accountNumber = scanner.nextInt();

		System.out.println("Enter Name");
		name = scanner.next();

		System.out.println("Enter Balance");
		balance = scanner.nextDouble();
if(issavings) 
{
	savings=new Saving(accountNumber,name,balance,isSalary);
	System.out.println(savings);
	}
else {
	current=new Current(accountNumber,name,balance,overdraftBalance);
	System.out.println("cuurent");
}
		

		do {
			System.out.println("Menu");
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. Balance");
			System.out.println("Enter your choice");
			trainsactionChoice = scanner.nextInt();

			switch (trainsactionChoice) {
			case 1:
				System.out.println("Enter amount to withdraw");
				amount = scanner.nextDouble();
				if(issavings)
				{
					result = savings.withdraw(amount);
					}
				else
				{
					result=current.withdraw(amount);
					
				}
			    if (result)
					System.out.println("Transaction Success !!");
				else
					System.out.println("Transaction Failed !!");
				break;
			case 2:
				System.out.println("Enter amount to deposit");
				amount = scanner.nextDouble();
				if(issavings)
				{
					result = savings.deposit(amount);
					}
				else
				{
					result=current.deposit(amount);
					
				}
				if (result)
					System.out.println("Transaction Success !!");
				else
					System.out.println("Transaction Failed !!");
				break;
			case 3:
				System.out.println("Account Balance :: ");
				if(issavings) {
					System.out.println(savings.getBalance());
					
				}
				else {
					System.out.println(current.getBalance());
					System.out.println("overdraftbalance:"+current.getOverdraftBalance());
				}
				
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

			System.out.println("Do you want to continue ?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));
		System.out.println("thannk you banking with us");
		



		
		scanner.close();	}
}

