package app.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TableAllController {
	
	 @FXML
	    void action_back(ActionEvent event) throws IOException {
	    	Stage stageTable = new Stage();
 		Parent root;
 		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/AdminMenu.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("Admin Page");
				stageTable.show();

	    }

}
