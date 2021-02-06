
public class InRestrOrder extends Order {

	private int tableNumber;
	private Booking bookingOrder;
	
	public InRestrOrder(int id_C, String sorderDate_C, String orderDetails_C, String extraNotes_C,int tableNumber_C,Booking bookingOrder_C) {
		this.setOrderID(id_C);
		this.setOrderDate(sorderDate_C);
		this.setOrderDetails(orderDetails_C);
		this.setExtraNotes(extraNotes_C);
		this.setTableNumber(tableNumber_C);
		this.setBookingOrder(bookingOrder_C);
	}
	
	public InRestrOrder() {
		
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public Booking getBookingOrder() {
		return bookingOrder;
	}
	public void setBookingOrder(Booking bookingOrder) {
		this.bookingOrder = bookingOrder;
	}

	@Override
	public void processPayment() {
	
		System.out.println("InRestrOrder payment has processed");
	}
	
	
}
