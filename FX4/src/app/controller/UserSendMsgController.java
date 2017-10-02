package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;




import app.database.DBConnector;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserSendMsgController {

    @FXML
    private ImageView iv_back;

    @FXML
    private TextField tf_send_from;

    @FXML
    private TextField tf_send_to;

    @FXML
    private TextField tf_subject;

    @FXML
    private TextArea tf_message;

    @FXML
    private ImageView iv_send;

    @FXML
    private Label lbl_msg_sent;
    
  
    
    public DBConnector db;

    @FXML
    void action_back(MouseEvent event) throws IOException {
    	Stage stageTable = new Stage();
		Parent root;
		
			root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/UserMenu.fxml"));
			Scene scene = new Scene(root);
			stageTable.setScene(scene);
			stageTable.setTitle("User Page");
			stageTable.show();
			((Stage)iv_back.getScene().getWindow()).close();
    }

    @FXML
    void action_send_msg(MouseEvent event) throws  ClassNotFoundException,SQLException {
    	java.sql.PreparedStatement preparedStatement= null;
    	Connection conn = db.Connection();
    	String sql="INSERT into messages (msg_from, msg_to, msg_subject, msg_content) values(?,?,?,?)";
    	preparedStatement=conn.prepareStatement(sql);
    	preparedStatement.setString(1, tf_send_from.getText());
    	preparedStatement.setString(2, tf_send_to.getText());
    	preparedStatement.setString(3, tf_subject.getText());
    	preparedStatement.setString(4, tf_message.getText());
    	preparedStatement.executeUpdate();
    	tf_send_from.clear();
    	tf_send_to.clear();
    	tf_subject.clear();
    	tf_message.clear();
    	lbl_msg_sent.setText("Your message has been sent!");
    	
    }
    public void initialize(){
 	   db=new DBConnector();
    }
}
