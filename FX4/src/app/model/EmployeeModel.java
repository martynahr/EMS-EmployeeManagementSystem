package app.model;

public class EmployeeModel {
	private int id_e;
	private String FirstName;
	private String LastName;
	private String service1;	
	private String service2;
	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getService1() {
		return service1;
	}
	public void setService1(String service1) {
		this.service1 = service1;
	}
	public String getService2() {
		return service2;
	}
	public void setService2(String service2) {
		this.service2 = service2;
	}
	

	
	public int getId_e() {
		return id_e;
	}
	public void setId_e(int id_e) {
		this.id_e = id_e;
	}
	public EmployeeModel(){}
	public EmployeeModel(int id_e, String firstName, String lastName, String service1, String service2) {
		super();
		this.id_e = id_e;
		FirstName = firstName;
		LastName = lastName;
		this.service1 = service1;
		this.service2 = service2;
	
	}
	public String getPass() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getLogin() {
		// TODO Auto-generated method stub
		return null;
	}
}
