package bank_gestion;
import java.util.Date;
import java.util.ArrayList;
public class Transaction {
	private int type_transaction;
	private float value;
	private Date date;
	float current_balance;
	public Transaction(int type, float value, float current_balance, Date date){
		this.type_transaction=type;
		this.value=value;
		this.date=date;
		this.current_balance=current_balance;
	}
	public float getnewBalance(){
		if(type_transaction==0){
			current_balance=current_balance+value;
		}
		else{
			current_balance=current_balance-value;
		}
		return current_balance;
	}
	public void printTransaction(){
		if(type_transaction==0){
			System.out.println("Deposit"+" "+String.valueOf(value)+" "+String.valueOf(date)+" "+String.valueOf(current_balance));
		}
		else{
			System.out.println("Withdrawal"+" -"+String.valueOf(value)+" "+String.valueOf(date)+" "+String.valueOf(current_balance));
		}
	}
}
