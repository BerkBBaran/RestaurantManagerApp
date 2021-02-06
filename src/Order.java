import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Order implements IPayment {

	int orderID;
	Date orderDate;
	String orderDetails;
	String extraNotes;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getExtraNotes() {
		return extraNotes;
	}
	public void setExtraNotes(String extraNotes) {
		this.extraNotes = extraNotes;
	}
	public void setOrderDate(String sDate) {
		
		try {
			this.orderDate=formatter.parse(sDate);
		} catch (ParseException e) {
			
			System.out.println("Unparseable using " + formatter);
		}    
	}
	public Date getOrderDate() {
		return orderDate;
	}
}
