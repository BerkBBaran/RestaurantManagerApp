
public class OnlineOrder extends Order {
	
	String paymentType;
	Junior deliveredBy;
	
	public OnlineOrder(int id_C, String sorderDate_C, String orderDetails_C, String extraNotes_C,String paymentType_C,Junior deliveredBy_C) {
		this.setOrderID(id_C);
		this.setOrderDate(sorderDate_C);
		this.setOrderDetails(orderDetails_C);
		this.setExtraNotes(extraNotes_C);
		this.setPaymentType(paymentType_C);
		this.setDeliveredBy(deliveredBy_C);
	}
	
	public OnlineOrder() {
		
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public Junior getDeliveredBy() {
		return deliveredBy;
	}


	public void setDeliveredBy(Junior deliveredBy) {
		this.deliveredBy = deliveredBy;
	}

	@Override
	public void processPayment() {
		
		System.out.println("Online order payment has processed");
	}
	

}
