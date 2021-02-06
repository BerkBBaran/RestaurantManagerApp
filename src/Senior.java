public class Senior extends Staff implements IEmployee {
	
	private int grossSalaryYearly;
	private Staff responsibleFrom;
	
	
	public Senior(int id_C, String name_C, char gender_C, String sDateOfBirth_C, String sStartDate_C,int grossSalaryYearly, Staff responsibleFrom) {
		
		super(id_C, name_C, gender_C, sDateOfBirth_C, sStartDate_C);
		this.grossSalaryYearly = grossSalaryYearly;
		this.responsibleFrom = responsibleFrom;
	}
	
	public Senior() {
		
		this.setId(0);
		this.setName("undefined");
		this.setGender('-');
		this.setDateOfBirth("00/00/0000");
		this.setStartDate("00/00/0000");
		this.setGrossSalaryYearly(0);
		this.setResponsibleFrom(null);
	}

	public int getGrossSalaryYearly() {
		return grossSalaryYearly;
	}
	public void setGrossSalaryYearly(int grossSalaryYearly) {
		this.grossSalaryYearly = grossSalaryYearly;
	}
	public Staff getResponsibleFrom() {
		return responsibleFrom;
	}
	public void setResponsibleFrom(Staff responsibleFrom) {
		this.responsibleFrom = responsibleFrom;
	}
	
	public int getSalary() {
		return getGrossSalaryYearly();
	}
	

}
