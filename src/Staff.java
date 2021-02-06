import java.text.ParseException;
import java.util.Date;

public class Staff extends Person {
	
	Date startDate;
	
	
	public Staff(int id_C, String name_C, char gender_C, String sDateOfBirth_C,String sStartDate_C) {
		this.setId(id_C);
		this.setName(name_C);
		this.setGender(gender_C);
		this.setDateOfBirth(sDateOfBirth_C);
		this.setStartDate(sStartDate_C);
	}
	public Staff() {
		
		this.setId(0);
		this.setName("undefined");
		this.setGender('-');
		this.setDateOfBirth("00/00/0000");
		this.setStartDate("00/00/0000");
	}
	public void setStartDate(String sDate) {
		
		try {
			this.startDate=formatter.parse(sDate);
		} catch (ParseException e) {
			
			System.out.println("Unparseable using " + formatter);
		}    
	}

}
