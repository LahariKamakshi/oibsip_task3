import java.util.*;
import java.io.*;

class AtmAccount 
{
	
	String name,userName,password,accountNo;
	float balance;
	int transac = 0;
	String transactionHistory = "";

	
	public void registration() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Name - ");
		this.name = sc.nextLine();
		System.out.print("\nEnter Your Username - ");
		this.userName = sc.nextLine();
		System.out.print("\nEnter Your Password - ");
		this.password = sc.nextLine();
		System.out.print("\nEnter Your Account Number - ");
		this.accountNo = sc.nextLine();
        System.out.print("\nEnter the amount to be deposited - ");
        this.balance=sc.nextFloat();
		System.out.println("\nRegistration completed successfully..Now you can login");
	}
	
	public boolean login() 
	{
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isLogin ) 
		{
			System.out.print("\nEnter Your Username - ");
			String Username = sc.nextLine();
			if ( Username.equals(userName) )
			 {
				while ( !isLogin ) 
				{
					System.out.print("\nEnter Your Password - ");
					String Password = sc.nextLine();
					if ( Password.equals(password) ) 
					{
						System.out.print("\nLogin successful!!");
						isLogin = true;
					}
					else 
					{
						System.out.println("\nIncorrect Password");
					}
				}
			}
			else 
			{
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}
	
	public void withdrawamount() 
	{
		
		System.out.print("\nEnter amount to withdraw - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			
			if ( balance >= amount ) 
			{
				transac++;
				balance -= amount;
				System.out.println("\n------------------------------------");
				System.out.println("\nwithdraw Successful");
				System.out.println("\n------------------------------------");
				String str = amount + " Rs withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
				
			}
			else 
			{
				System.out.println("\nInsufficient Balance");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void deposit() 
	{
		
		System.out.print("\nEnter amount to deposit - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try 
		{
			if ( amount <= 100000f ) 
			{
				transac++;
				balance += amount;
                System.out.println("\n------------------------------------");
				System.out.println("\nSuccessfully Deposited");
                System.out.println("\n------------------------------------");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else 
			{
                System.out.println("\n------------------------------------");
				System.out.println("\nSorry...Limit is 100000.00");
                System.out.println("\n------------------------------------");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void transfer() 
	{
		
		Scanner sc = new Scanner(System.in);
        System.out.println("\n------------------------------------");
		System.out.print("\nEnter Receipent's Name : ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter amount to be transferred:  ");
		float amount = sc.nextFloat();
        System.out.println("\n------------------------------------");
		
		try 
		{
			if ( balance >= amount ) 
			{
				if ( amount <= 50000f )
				 {
					transac++;
					balance -= amount;
                    System.out.println("\n------------------------------------");
					System.out.println("\nSuccessfully Transfered to " + receipent);
                    System.out.println("\n------------------------------------");
					String str = amount + " Rs transfered to " + receipent + "\n";
					transactionHistory = transactionHistory.concat(str);
				}
				else 
				{
                    System.out.println("\n------------------------------------");
					System.out.println("\nSorry...Limit is 50000.00");
                    System.out.println("\n------------------------------------");
				}
			}
			else 
			{
                System.out.println("\n------------------------------------");
				System.out.println("\nInsufficient Balance");
                System.out.println("\n------------------------------------");
			}
		}
		catch ( Exception e) {
		}
	}
	
	public void checkBalance()
	{
        System.out.println("\n------------------------------------");
		System.out.println("\nYour balance is:" + balance + " Rs");
        System.out.println("\n------------------------------------");
	}
	
	public void transHistory() 
	{
		if ( transac == 0 ) 
		{
            System.out.println("\n------------------------------------");
			System.out.println("\nEmpty");
            System.out.println("\n------------------------------------");
		}
		else 
		{
            System.out.println("\n------------------------------------");
			System.out.println("\n" + transactionHistory);
            System.out.println("\n------------------------------------");
		}
	}
}


public class TaskAtm 
{	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) 
		{
			try 
			{
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) 
				{
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) 
			{
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) 
	{
		
        System.out.println("\n------------------------------------");
		System.out.println("\n    WELCOME TO ATM SYSTEM    ");
        System.out.println("\n------------------------------------");
		System.out.println("1.registration \n2.Exit");
        System.out.println("\n------------------------------------");
		System.out.print("Enter Your Choice - ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) 
		{
			AtmAccount b = new AtmAccount();
			b.registration();
			while(true) 
			{
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Your Choice - ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) 
				{
					if (b.login()) 
					{
						System.out.println("\n---------------------------------------------");
						System.out.println("\n      WELCOME BACK " + b.name + "      ");
						System.out.println("\n---------------------------------------------");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice - ");
							int c = takeIntegerInput(6);
							switch(c) {
								case 1:
								b.withdrawamount();
								break;
								case 2:
								b.deposit();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.checkBalance();
								break;
								case 5:
								b.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}
