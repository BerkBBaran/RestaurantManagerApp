import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {

	Date bookingDate;
	int bookingID;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public Booking(String sbookingDate, int bookingID) {
		this.setBookingDate(sbookingDate);
		this.bookingID = bookingID;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	
	public void setBookingDate(String sDate) {
		
		try {
			this.bookingDate=formatter.parse(sDate);
		} catch (ParseException e) {
			
			System.out.println("Unparseable using " + formatter);
		}    
	}
	
}
