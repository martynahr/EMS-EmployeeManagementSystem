package app.controller;

import java.io.IOException;

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

    @FXML
    void action_back(MouseEvent event) throws IOException {
    	Stage stageTable = new Stage();
		Parent root;
		
			root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/UserMenu.fxml"));
			Scene scene = new Scene(root);
			stageTable.setScene(scene);
			stageTable.setTitle("User Page");
			stageTable.show();
    }

    @FXML
    void action_send_msg(MouseEvent event) {

    }


}
