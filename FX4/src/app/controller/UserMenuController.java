package app.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import app.database.DBConnector;
import app.model.LoginModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserMenuController {

	    @FXML
	    private Button btn_create_report;

	    @FXML
	    private Button btn_preview_old;

	    @FXML
	    private Button btn_data_account;

	    @FXML
	    private Button btn_exit;
	    

	    @FXML
	    private Label lbl_name;
	    public DBConnector db;
	    
	    /*@FXML
	    void action_welcome(MouseEvent event) {
	    	Connection conn1 = db.Connection();	
			Statement stat = conn1.createStatement();
	       
	        ResultSet rs = stat.executeQuery("Select FirstName From employee_accounts where login= '"+logF.getText()+"' and pass= '"+passF.getText()+"' ;");
	       (rs.next())
		lbl_i.setText("");
				loginModel = new LoginModel(rs.getString(1), rs.getString(2), rs.getString(3));
				setLogin(rs.getString(2));
				setRole(rs.getString(4));
				
			
	    	
	    	
	    String txt=lbl_name.getText();
    	lbl_name.setText("contact us at: @@@");
	    }*/
	    @FXML
	    void action_create_report(ActionEvent event) throws IOException {
	    	Stage stageTable = new Stage();
    		Parent root;
    		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/UserCreateReport.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("Create Report");
				stageTable.show();
	    }

	    @FXML
	    void action_exit(MouseEvent event) {
	    	System.exit(1);
	    }

	    @FXML
	    void action_send_msg(ActionEvent event) throws IOException {
	    	Stage stageTable = new Stage();
    		Parent root;
    		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/UserSendMsg.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("Send Message");
				stageTable.show();
	    }

	    @FXML
	    void action_preview_old(ActionEvent event) throws IOException {
	    	Stage stageTable = new Stage();
    		Parent root;
    		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/UserPreviewOld.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("Preview Old Reports");
				stageTable.show();

	    }

	    @FXML
	    void exit(ActionEvent event) {
	    	System.exit(1);
	    }

	}


