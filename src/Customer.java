import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer extends Person{
	
	Date registrationDate;
	String cardDetails;
	List<Order> orders = new ArrayList<>();
	

	public Customer(int id_C, String name_C, char gender_C, String sDateOfBirth_C,String sRegistrationDate_C,String cardDetails_C) {
		this.setId(id_C);
		this.setName(name_C);
		this.setGender(gender_C);
		this.setDateOfBirth(sDateOfBirth_C);
		this.setRegistrationDate(sRegistrationDate_C);
		this.setCardDetails(cardDetails_C);
	}
	public Customer() { //default
		this.setId(0);
		this.setName("undefined");
		this.setGender('-');
		this.setDateOfBirth("00/00/0000");
		this.setRegistrationDate("00/00/0000");
		this.setCardDetails("undefined");

	}


	public String getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(String cardDetails) {
		this.cardDetails = cardDetails;
	}
	
	public void setRegistrationDate(String sDate) {
		
		try {
			this.registrationDate=formatter.parse(sDate);
		} catch (ParseException e) {
			
			System.out.println("Unparseable using " + formatter);
		}    
	}
	public Date getRegistrationDate() {
			return registrationDate;
	}
	

}
