package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.InboxModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminInboxController {

    @FXML
    private ImageView iv_back;

    @FXML
    private TableView<InboxModel> TableInbox;

    @FXML
    private TableColumn<InboxModel, String> tb_from;

    @FXML
    private TableColumn<InboxModel, String> tb_to;

    @FXML
    private TableColumn<InboxModel, String> tb_subject;

    @FXML
    private TableColumn<InboxModel, String> tb_content;

    @FXML
    private Button get_messages;

    @FXML
    private Button get_delete;
    public DBConnector db;
    public ObservableList<InboxModel> data=FXCollections.observableArrayList();

    @FXML
    void action_back(MouseEvent event) throws IOException {
    	Stage stageTable = new Stage();
 		Parent root;
 		
				root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/AdminMenu.fxml"));
				Scene scene = new Scene(root);
				stageTable.setScene(scene);
				stageTable.setTitle("User Page");
				stageTable.show();
				((Stage)iv_back.getScene().getWindow()).close();
    }
    

    @FXML
    void action_delete(MouseEvent event) throws ClassNotFoundException, SQLException {
    	java.sql.PreparedStatement preparedStatement= null;
    	int id_del=TableInbox.getSelectionModel().getSelectedItem().getId_m();
    	//String id_del2= TableInbox.getSelectionModel().getSelectedItem().getMsg_from();
    	Connection conn=db.Connection();
    	
    	String sql= "DELETE FROM messages WHERE id_m="+id_del+";";
    	preparedStatement=conn.prepareStatement(sql);
    	preparedStatement.executeUpdate();


    }

    @FXML
    void action_getMessages(MouseEvent event) throws SQLException, ClassNotFoundException {
    	Connection conn= db.Connection();
    	
    	data=FXCollections.observableArrayList();
    	ResultSet rs1=conn.createStatement().executeQuery("Select * From messages;");
    	while (rs1.next()){
    	data.add(new InboxModel(rs1.getInt(1), rs1.getString(2),rs1.getString(3),rs1.getString(4), rs1.getString(5))); 
    	}
    	tb_from.setCellValueFactory(new PropertyValueFactory<InboxModel, String>("msg_from"));
    	tb_to.setCellValueFactory(new PropertyValueFactory<InboxModel, String>("msg_to"));
    	tb_subject.setCellValueFactory(new PropertyValueFactory<InboxModel, String>("msg_subject"));
    	tb_content.setCellValueFactory(new PropertyValueFactory<InboxModel, String>("msg_content"));
    
    	TableInbox.setItems(null);
    	TableInbox.setItems(data);
    	get_messages.setText("refresh");
    	

    }
    public void initialize(){
   	   db=new DBConnector();
      }

}
