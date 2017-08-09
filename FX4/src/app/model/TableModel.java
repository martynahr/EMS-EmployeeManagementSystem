package app.model;

public class TableModel {
	private int id_e;
	private String login;
	private String pass;
	private String firstName;
	private String lastName;
	
	
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public int getId_e() {
		return id_e;
	}
	public void setId_e(int id_e) {
		this.id_e = id_e;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public TableModel(){}
	public TableModel(int id_e, String login, String pass, String firstName, String lastName) {
		super();
		this.id_e = id_e;
		this.login = login;
		this.pass = pass;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	}


