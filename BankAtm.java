/**
* <h1>BankAtm</h1>
* This program demonstrates a bank ATM application
* if the amount withdrawn is greater than the balance or balance is less than 10000
* it will throw a custom exception 
* @author  Vikas
* @version 1.0
* @since   2017-05-27 
*/
package assignment6.session2;

public class BankAtm {
    int atmId; 
	String bankName; 
	String location;
	double balance = 0.0;
	
	//parameterized constructor to initialize bankAtm object
	public BankAtm(int atmId, String bankName, String location) {
		super();
		this.atmId = atmId;
		this.bankName = bankName;
		this.location = location;
	}

	public static void main(String[] args) {
		//creating the 3 BankAtm objects
		BankAtm atm1 = new BankAtm(102,"SBI","Delhi");
		BankAtm atm2 = new BankAtm(102,"PNB","Mumbai");
		BankAtm atm3 = new BankAtm(102,"UCO","Delhi");
		atm1.deposit(9000);//deposit the amount
		try {
			atm1.withdraw(2000);//withdraw the amount
		} catch (BankAtmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		atm2.deposit(30000);//deposit the amount
		try {
			atm2.withdraw(10000);//withdraw the amount
		} catch (BankAtmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		atm3.deposit(15000);//deposit the amount
		try {
			atm3.withdraw(25000);//withdraw the amount
		} catch (BankAtmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(atm1.bankName+" "+atm1.location+" available balance is: "+atm1.balance);
		System.out.println(atm2.bankName+" "+atm2.location+" available balance is: "+atm2.balance);
		System.out.println(atm3.bankName+" "+atm3.location+" available balance is: "+atm3.balance);
	}
	
	//this method will withdraw the given amount from the atm balance based on given conditions
	//otherwise will throw user defined exception
	public void withdraw(double amt) throws BankAtmException {
		if(balance < 10000 || amt > balance){
		 throw new BankAtmException("The amount can not be withdrawn"); 
		}
		
		else{
			balance = balance - amt;
		}
	}
	
	//this method will add the given amount to the atm balance
	public void deposit(double amt){
		balance = balance + amt;
	}
	
}

//user defined class for throwing an exception
class BankAtmException extends Exception{
	BankAtmException(String s){  
		super(s);   
	}  
}