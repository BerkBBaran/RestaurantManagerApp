import java.util.ArrayList;
import java.util.List;

public class PopulateData {

	private List<Staff> staffList = new ArrayList<>();
	private List<Customer> customerList = new ArrayList<>();
	

	
	@SuppressWarnings("unchecked")  //First staff initialized as Junior
	public PopulateData(List<Staff> staffList_C, List<Customer> customerList_C) {
		
		
		staffList_C.add(new Junior(100,"Can",'M',"22/01/1990","24/01/2011",3000,"26/01/1990"));
		staffList_C.add(new Junior(101,"Mahmut",'M',"23/01/1990","25/01/2011",3000,"27/01/1990"));
		staffList_C.add(new Senior(101,"Alice",'F',"28/01/1990","19/01/2011",5000,(Junior) staffList_C.get(0)));
		
		customerList_C.add(new Customer(100,"Can",'M',"22/02/2000","24/03/2011","Visa Card"));
		customerList_C.add(new Customer(100,"Can",'M',"22/04/1999","24/05/2011","Master Card"));
		customerList_C.add(new Customer(100,"Can",'M',"22/06/1998","24/07/2011","Visa Card"));
		setStaffList(staffList_C);
		setCustomerList(customerList_C);
		
		
	}
	public List<Staff> getStaffList() {
		return staffList;
	}
	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	

	
	
}
