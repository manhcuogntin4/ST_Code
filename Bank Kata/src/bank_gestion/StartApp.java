package bank_gestion;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat; 
import java.text.DateFormat;
import java.text.ParseException;
public class StartApp {
	public static void main(String[] args) {
		Account account = new Account(0);
		account.deposit(100, convertDate("04/12/2012"));
		account.deposit(200, convertDate("05/12/2012"));
		account.withdrawal(150, convertDate("08/12/2012"));
		account.printTransactions();
		
		Account account2 = new Account(100);
		account2.deposit(100, convertDate("04/12/2012"));
		account2.deposit(200, convertDate("05/12/2012"));
		account2.withdrawal(150, convertDate("08/12/2012"));
		account2.printTransactions();
		
	}
	public static Date convertDate(String dateString) { 
		DateFormat formatter;
		Date date=new Date();
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
