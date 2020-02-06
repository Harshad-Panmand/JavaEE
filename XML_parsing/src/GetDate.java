import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDate {
	public static void main(String[] args) throws ParseException {

		/*
		 * String datePattern = "dd-MM-yyyy"; SimpleDateFormat sdFormat = new
		 * SimpleDateFormat(datePattern); String curDateString = new
		 * SimpleDateFormat(datePattern).format(new Date());
		 * System.out.println("#########" + curDateString); Date d2 =
		 * sdFormat.parse(curDateString); String curDateFormatString =
		 * sdFormat.format(d2); System.out.println(curDateFormatString);
		 * 
		 * // Create SimpleDateFormat object SimpleDateFormat sdfo = new
		 * SimpleDateFormat("yyyy-MM-dd");
		 * 
		 * // Get the two dates to be compared Date d1 = sdfo.parse("2011-03-31"); //
		 * Date d2 = sdfo.parse("2012-03-31");
		 * 
		 * // Print the dates System.out.println("Date1 : " + sdfo.format(d1));
		 * System.out.println("Date2 : " + sdfo.format(d2));
		 * 
		 */

		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		Date currentDate = cal1.getTime();

		System.out.println("Date using calendar object1 " + currentDate);

		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		// cal2.set(Calendar.DATE, 5);
		Date d2 = cal2.getTime();

		System.out.println("Date using calendar object2 " + d2);

		// Compare the dates using compareTo()
		if (currentDate.compareTo(d2) > 0) {
			// When Date d1 > Date d2
			System.out.println("Date1 is after Date2");
		} else if (currentDate.compareTo(d2) < 0) {
			// When Date d1 < Date d2
			System.out.println("Date1 is before Date2");
		} else if (currentDate.compareTo(d2) == 0) {
			// When Date d1 = Date d2
			System.out.println("Date1 is equal to Date2");
		}

		if (currentDate.before(d2)) {
			System.out.println(currentDate + " is before " + d2);
		} else if (currentDate.after(d2)) {
			System.out.println(currentDate + " is after " + d2);
		} else if (currentDate.equals(d2)) {
			System.out.println(currentDate + " is equal " + d2);
		}
	}
}