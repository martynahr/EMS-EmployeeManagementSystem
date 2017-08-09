package app.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserPreviewOldController {

    @FXML
    private Button btn_preview_old;

    @FXML
    private ImageView iv_back;

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

    }




	

