package app.controller;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

	public class AdminMenuController {

	    @FXML
	    private Button btn_users_mngmnt;

	    @FXML
	    private Button btn_accounts_mngmnt;

	    @FXML
	    private Button btn_other;

	    @FXML
	    private Button btn_exit;
	    
	    @FXML
	    private Label lbl_pro;
	    
	    @FXML
	    void action_accounts_management(ActionEvent event) throws IOException {
	    	Stage stageTable = new Stage();
    		Parent root;
    		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/TableLoginsView.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("Admin View");
				stageTable.show();
				((Stage)btn_accounts_mngmnt.getScene().getWindow()).close();
	    }
	    
	    @FXML
	    void action_users_management(ActionEvent event) throws IOException {
	    	Stage stageTable = new Stage();
    		Parent root;
    		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/TableAll.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("All data");
				stageTable.show();
				((Stage)btn_users_mngmnt.getScene().getWindow()).close();

	    }



	    @FXML
	    void action_inbox(ActionEvent event) throws IOException {
	    	Stage stageTable = new Stage();
    		Parent root;
    		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/InboxView.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("Inbox");
				stageTable.show();
				((Stage)btn_other.getScene().getWindow()).close();


	    }
	    
	    @FXML
	    void action_exit(MouseEvent event) {
	    	lbl_pro.setText("");
	    }
	    @FXML
	    private ImageView iv_logout;

	    @FXML
	    void action_logout(MouseEvent event) throws IOException {
	    	Stage stageTable = new Stage();
    		Parent root;
    		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/LoginView.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("Login View");
				stageTable.show();
				((Stage)iv_logout.getScene().getWindow()).close();
	    }

	    @FXML
	    void exit(ActionEvent event) {
	    	System.exit(1);
	    }

	}
	
	

