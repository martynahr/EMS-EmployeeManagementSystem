package app.model;

public class UserRepModel {
	
	private int id;
	private String FirstName;
	private String LastName;
	private int Month;
	private double ttl_service1;
	private double ttl_service2;
	private double ttl_net;
	private double ttl_gross;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getMonth() {
		return Month;
	}
	public void setMonth(int month) {
		Month = month;
	}
	public double getTtl_service1() {
		return ttl_service1;
	}
	public void setTtl_service1(double ttl_service1) {
		this.ttl_service1 = ttl_service1;
	}
	public double getTtl_service2() {
		return ttl_service2;
	}
	public void setTtl_service2(double ttl_service2) {
		this.ttl_service2 = ttl_service2;
	}
	public double getTtl_net() {
		return ttl_net;
	}
	public void setTtl_net(double ttl_net) {
		this.ttl_net = ttl_net;
	}
	public double getTtl_gross() {
		return ttl_gross;
	}
	public void setTtl_gross(double ttl_gross) {
		this.ttl_gross = ttl_gross;
	}
	public UserRepModel(){}
	public UserRepModel(int id, String firstName, String lastName, int month, double ttl_service1, double ttl_service2,
			double ttl_net, double ttl_gross) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		Month = month;
		this.ttl_service1 = ttl_service1;
		this.ttl_service2 = ttl_service2;
		this.ttl_net = ttl_net;
		this.ttl_gross = ttl_gross;
	}
	
	

}
