import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {
	
	int id;
	String name;
	char Gender;
	Date dateOfBirth;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String sDateOfBirth) {
		
		try {
			this.dateOfBirth=formatter.parse(sDateOfBirth);
		} catch (ParseException e) {
			
			System.out.println("Unparseable using " + formatter);
		}    
	}
	
	
	
	
}
