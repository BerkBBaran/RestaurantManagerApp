import java.text.ParseException;
import java.util.Date;


public class Junior extends Staff implements IEmployee{
	
	int monthlySalary;
	Date expectedEndDate;
	
	
	public Junior(int id_C, String name_C, char gender_C, String sDateOfBirth_C, String sStartDate_C, int monthlySalary,String sExpectedEndDate) {
		
		super(id_C, name_C, gender_C, sDateOfBirth_C, sStartDate_C);
		this.setMonthlySalary(monthlySalary);
		this.setExpectedEndDate(sExpectedEndDate);
	}
	public Junior() {  //default constructor
		
		this.setId(0);
		this.setName("undefined");
		this.setGender('-');
		this.setDateOfBirth("00/00/0000");
		this.setStartDate("00/00/0000");
		this.setMonthlySalary(0);
		this.setExpectedEndDate("00/00/0000");
	}
	public int getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(int grossSalaryYearly) {
		this.monthlySalary = grossSalaryYearly;
	}
	public Date getExpectedEndDate() {
		return expectedEndDate;
	}
	public void setExpectedEndDate(String sDate) {
		
		try {
			this.expectedEndDate=formatter.parse(sDate);
		} catch (ParseException e) {
			
			System.out.println("Unparseable using " + formatter);
		}    
	}
	@Override
	public int getSalary() {
		return getMonthlySalary();
	}

	
	

}
