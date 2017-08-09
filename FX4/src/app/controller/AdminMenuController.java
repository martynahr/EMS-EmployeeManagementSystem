package app.controller;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

	    }

	    /*@FXML
	    void move_to_am(MouseEvent event) throws IOException {
	    	Stage stageTable = new Stage();
    		Parent root;
    		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/TableView.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("Admin View");
				stageTable.show();
				
		*/

	    


	   

	    @FXML
	    void action_other(MouseEvent event) {
	    	String txt=lbl_pro.getText();
	    	lbl_pro.setText("Buy a PRO version :)");

	    }
	    
	    @FXML
	    void action_exit(MouseEvent event) {
	    	lbl_pro.setText("");
	    }


	    @FXML
	    void exit(ActionEvent event) {
	    	System.exit(1);
	    }

	}
	
	

