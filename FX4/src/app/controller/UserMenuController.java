package app.controller;
import java.io.IOException;
import app.database.DBConnector;
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
	    

	    @FXML
	    void action_create_report(ActionEvent event) throws IOException {
	    	Stage stageTable = new Stage();
    		Parent root;
    		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/UserCreateReport.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("Create Report");
				stageTable.show();
				((Stage)btn_create_report.getScene().getWindow()).close();
	    }

	    @FXML
	    void action_exit(MouseEvent event) {
	    	System.exit(1);
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
	    void action_send_msg(ActionEvent event) throws IOException {
	    	Stage stageTable = new Stage();
    		Parent root;
    		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/UserSendMsg.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("Send Message");
				stageTable.show();
				((Stage)btn_data_account.getScene().getWindow()).close();
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
				((Stage)btn_preview_old.getScene().getWindow()).close();

	    }

	    @FXML
	    void exit(ActionEvent event) {
	    	System.exit(1);
	    }
	    public void initialize(){
	  	   db=new DBConnector();
	     }

	}


