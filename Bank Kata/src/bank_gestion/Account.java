package bank_gestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class Account {
	private float balance;
	private final List<Transaction> transactions=new ArrayList<>();
	public Account(float balance){
		this.balance=balance;
	}
	public void deposit(float value, Date date)
	{
		Transaction t=new Transaction(0,value,balance,date);
		balance=t.getnewBalance();
		transactions.add(t);
	}
	public void withdrawal(float value, Date date){
		if (balance-value>0){
			Transaction t=new Transaction(1,value,balance,date);
			balance=t.getnewBalance();
			transactions.add(t);
		}
		else{
			System.out.println("Not enough money");
		}
	}
	public void printTransactions(){
		System.out.println("Transaction  Value  Date  Balance");
		for(Transaction t:transactions){
			t.printTransaction();
		}
	}
	

}
