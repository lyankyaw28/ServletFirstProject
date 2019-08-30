import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String args[]) {
		Date date1 = new Date();
		Calendar d1 = Calendar.getInstance();
		d1.setTime(date1);
		System.out.println(d1.get(Calendar.DAY_OF_MONTH));
	}
}
