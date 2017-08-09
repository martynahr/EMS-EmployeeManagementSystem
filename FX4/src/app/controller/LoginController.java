package app.controller;
import app.database.DBConnector;
import app.model.LoginModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {
    
    @FXML
    private TextField logF;

    @FXML
    private Label lbl_sign;

    @FXML
    private Label lbl_log;

    @FXML
    private Label lbl_pass;

    @FXML
    private Button btn_ent;

    @FXML
    private PasswordField passF;

    @FXML
    private Label lbl_title;

    @FXML
    private ImageView iv_main;

    @FXML
    private ImageView iv_help;

    @FXML
    private ImageView iv_contact;
    
    @FXML
    private Label lbl_info;
    
    @FXML
    private Label lbl_i;
    
    public DBConnector db;
    String logowanie;
    
    private static String login = "";
	private static String role = null;
	static LoginModel loginModel;
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		LoginController.login = login;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		LoginController.role = role;
	}
	
	public ObservableList<LoginModel> Logins;
    
    @FXML
    void action_contact(MouseEvent event) {
    	String txt=lbl_info.getText();
    	lbl_info.setText("contact us at: @@@");
    	
    }
    
    @FXML
    void action_exit(MouseEvent event) {
    	lbl_info.setText("");
    }

    @FXML
    void action_help(MouseEvent event) {
    	String txt=lbl_info.getText();
    	lbl_info.setText("contact with admin");
    }
    


    @FXML
    private void Login(ActionEvent event)  throws IOException, ClassNotFoundException, SQLException {
    	Connection conn1 = db.Connection();	
		Statement stat = conn1.createStatement();
       
        try{ ResultSet rs = stat.executeQuery("Select * From log where login= '"+logF.getText()+"' and pass= '"+passF.getText()+"' ;");
        while(rs.next())
		{	 	lbl_i.setText("");
			loginModel = new LoginModel(rs.getString(1), rs.getString(2), rs.getString(3));
			setLogin(rs.getString(2));
			setRole(rs.getString(4));
			
		}
		if(!getLogin().equals(""))
		{
		
			logF.setText("");
			passF.setText("");
			System.out.println("Successful log in");	
			System.out.println(getRole());
			if(getRole().toLowerCase().equals("admin"))
			{
				System.out.println("You've been logged as an admin");
	
				Stage stageTable = new Stage();
	    		Parent root;
				try {
					root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/AdminMenu.fxml"));
					Scene scene = new Scene(root);
					stageTable.setScene(scene);
					stageTable.setTitle("Admin Page");
					stageTable.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else
			{
				System.out.println("You've been looged as an user");
				Stage stageTable = new Stage();
	    		Parent root;
				try {
					root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/UserMenu.fxml"));
					Scene scene = new Scene(root);
					stageTable.setScene(scene);
					stageTable.setTitle("User Page");
					stageTable.show();
		
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		else 
		{
			//System.out.println("incorrect data");
			lbl_i.setText("Incorrect login or pass- try again!");	
			logF.setText(null);
			passF.setText(null);
			
		}

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (NullPointerException e) {
	System.out.println("log in unsuccessful");
	lbl_i.setText("Please complete all fields!");	
	logF.setText(null);
	passF.setText(null);
}

}	
        
    public void initialize(){
 	   db=new DBConnector();
    }

    }


