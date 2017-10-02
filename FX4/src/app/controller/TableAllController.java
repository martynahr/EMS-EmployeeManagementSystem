package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.UserRepModel;
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

public class TableAllController {
	

    @FXML
    private ImageView iv_back;
    @FXML
    private TableView<UserRepModel> tb_userRslts;

    @FXML
    private TableColumn<UserRepModel, Integer> tb_id;

    @FXML
    private TableColumn<UserRepModel, String> tb_fname;

    @FXML
    private TableColumn<UserRepModel, String> tb_lname;

    @FXML
    private TableColumn<UserRepModel, Integer> tb_mnth;

    @FXML
    private TableColumn<UserRepModel, Double> tb_tserv1;

    @FXML
    private TableColumn<UserRepModel, Double> tb_tserv2;

    @FXML
    private TableColumn<UserRepModel, Double> tb_ttln;

    @FXML
    private TableColumn<UserRepModel, Double> tb_ttlg;
    
    @FXML
    private Button get_delete;

    @FXML
    void action_delete(MouseEvent event) throws ClassNotFoundException, SQLException {
    	java.sql.PreparedStatement preparedStatement= null;
    	double id_del= tb_userRslts.getSelectionModel().getSelectedItem().getTtl_net();
    	Connection conn=db.Connection();
    	
    	String sql= "DELETE FROM summary WHERE ttl_net="+id_del+";";
    	preparedStatement=conn.prepareStatement(sql);
    	preparedStatement.executeUpdate();

    }

    @FXML
    void action_getResults(MouseEvent event) throws SQLException, ClassNotFoundException {
    	Connection conn= db.Connection();
    	
    	data=FXCollections.observableArrayList();
    	ResultSet rs1=conn.createStatement().executeQuery("Select * From userss_earnings;");
    	while (rs1.next()){
    	data.add(new UserRepModel(rs1.getInt(1), rs1.getString(2),rs1.getString(3),rs1.getInt(4), rs1.getDouble(5),rs1.getDouble(6),rs1.getDouble(7),rs1.getDouble(8) )); 
    	}
    	tb_id.setCellValueFactory(new PropertyValueFactory<UserRepModel, Integer>("id"));
    	tb_fname.setCellValueFactory(new PropertyValueFactory<UserRepModel, String>("FirstName"));
    	tb_lname.setCellValueFactory(new PropertyValueFactory<UserRepModel, String>("LastName"));
    	tb_mnth.setCellValueFactory(new PropertyValueFactory<UserRepModel, Integer>("Month"));
    	tb_tserv1.setCellValueFactory(new PropertyValueFactory<UserRepModel, Double>("ttl_service1"));
    	tb_tserv2.setCellValueFactory(new PropertyValueFactory<UserRepModel, Double>("ttl_service2"));
    	tb_ttln.setCellValueFactory(new PropertyValueFactory<UserRepModel, Double>("ttl_net"));
    	tb_ttlg.setCellValueFactory(new PropertyValueFactory<UserRepModel, Double>("ttl_gross"));
    	tb_userRslts.setItems(null);
    	tb_userRslts.setItems(data);
    	get_reports.setText("refresh");
        
    }

    @FXML
    private Button get_reports;

    public DBConnector db;
    public ObservableList<UserRepModel> data=FXCollections.observableArrayList();

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
    public void initialize(){
  	   db=new DBConnector();
     }

}
