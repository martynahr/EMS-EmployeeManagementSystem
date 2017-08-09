package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.model.TableModel;
import app.database.DBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TableLoginsController {
	@FXML
    private TableView<TableModel> Table;
    @FXML
    private TableColumn<TableModel,Integer> tb_id_e;
    @FXML
    private TableColumn<TableModel,String> tb_firstname;
    @FXML
    private TableColumn<TableModel,String> tb_lastname;
    
    @FXML
    private TableColumn<TableModel,String> tb_login;

    @FXML
    private TableColumn<TableModel,String> tb_pass;
    
    @FXML
    private Button btn_connect;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_insert;

    @FXML
    private Button btn_commitupd;
    @FXML
    private TextField tf_firstname;
    @FXML
    private TextField tf_lastname;

    @FXML
    private TextField tf_login;
    @FXML
    private TextField tf_pass;

    
    @FXML
    private Button btn_commit;
    
    public DBConnector db;
    public ObservableList<TableModel> data=FXCollections.observableArrayList();
    
    @FXML
    void exit(MouseEvent event) {
    	System.exit(1);
    }
    
    @FXML
    void btncommitactionupd(ActionEvent event) throws ClassNotFoundException, SQLException {
    	java.sql.PreparedStatement preparedStatement= null;
    	int id_update= Table.getSelectionModel().getSelectedItem().getId_e();
    	Connection conn=db.Connection(); 
        
    	String sql="UPDATE employee_accounts SET login_log=?, pass_log=?, firstName_employee=?,lastName_employee=? where id_e_employee=?";
    	preparedStatement=conn.prepareStatement(sql);
    	preparedStatement.setString(1, tf_login.getText());
    	preparedStatement.setString(2, tf_pass.getText());
    	preparedStatement.setString(3, tf_firstname.getText());
    	preparedStatement.setString(4, tf_lastname.getText());
    	preparedStatement.setInt(5, id_update);
    	preparedStatement.executeUpdate();
    	tf_firstname.clear();
    	tf_lastname.clear();
    	tf_login.clear();
    	tf_pass.clear();
 
    }
    
    @FXML
    void btncommitaction(ActionEvent event) throws ClassNotFoundException, SQLException {
    	java.sql.PreparedStatement preparedStatement= null;
    	Connection conn=db.Connection(); 	
    	String sql="INSERT into employee_accounts (login_log, pass_log, firstName_employee,lastName_employee) values (?,?,?,?)";
    	preparedStatement=conn.prepareStatement(sql);
    	preparedStatement.setString(1, tf_login.getText());
    	preparedStatement.setString(2, tf_pass.getText());
    	preparedStatement.setString(3, tf_firstname.getText());
    	preparedStatement.setString(4, tf_lastname.getText());
    	preparedStatement.executeUpdate();
    	tf_firstname.clear();
    	tf_lastname.clear();
    	tf_login.clear();
    	tf_pass.clear();
    }
    @FXML
    void btndeleteactioc(ActionEvent event) throws SQLException, ClassNotFoundException{
    	java.sql.PreparedStatement preparedStatement= null;
    	int id_del= Table.getSelectionModel().getSelectedItem().getId_e();
    	Connection conn=db.Connection();
    	
    	String sql= "DELETE FROM employee WHERE id_employee="+id_del+";";
    	preparedStatement=conn.prepareStatement(sql);
    	preparedStatement.executeUpdate();
    }
    
    @FXML
    void action_back(MouseEvent event) throws IOException {
    	Stage stageTable = new Stage();
		Parent root;
		
			root = (Parent) FXMLLoader.load(getClass().getResource("/app/view/AdminMenu.fxml"));
			Scene scene = new Scene(root);
			stageTable.setScene(scene);
			stageTable.setTitle("Admin Page");
			stageTable.show();

    }

    @FXML
    void btninsertaction(ActionEvent event) {
    	tf_firstname.clear();
    	tf_lastname.clear();
    	tf_login.clear();
    	tf_pass.clear();
    
    	
    	tf_firstname.setDisable(false);
    	tf_lastname.setDisable(false);
    	tf_login.setDisable(false);
    	tf_pass.setDisable(false);
    	btn_commit.setDisable(false);
    	btn_commitupd.setDisable(true);
    	
    }

    @FXML
    void btnrefreshaction(ActionEvent event) throws ClassNotFoundException {
	try{ 
		Connection conn= db.Connection();
		data= FXCollections.observableArrayList();
		ResultSet rs=conn.createStatement().executeQuery("SELECT * from employee_accounts");
		while(rs.next()){
		data.add(new TableModel(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5))); 
		}
	}catch (Exception ex){
		System.out.println("Error"+ ex);
	}
	tb_id_e.setCellValueFactory(new PropertyValueFactory<TableModel, Integer>("id_e"));
	tb_firstname.setCellValueFactory(new PropertyValueFactory<TableModel, String>("firstName"));
	tb_lastname.setCellValueFactory(new PropertyValueFactory<TableModel, String>("lastName"));
	tb_login.setCellValueFactory(new PropertyValueFactory<TableModel, String>("login"));
	tb_pass.setCellValueFactory(new PropertyValueFactory<TableModel, String>("pass"));
    
	Table.setItems(null);
	Table.setItems(data);
    
    }

    @FXML
    void btnupdateaction(ActionEvent event) throws ClassNotFoundException, SQLException {
    	tf_firstname.setDisable(false);
    	tf_lastname.setDisable(false);
    	tf_login.setDisable(false);
    	tf_pass.setDisable(false);
    	btn_commit.setDisable(true);
    	btn_commitupd.setDisable(false);
    	
    	java.sql.PreparedStatement preparedStatement= null;
    	int id_update= Table.getSelectionModel().getSelectedItem().getId_e();
    	Connection conn=db.Connection(); 
    	tf_firstname.setText(Table.getSelectionModel().getSelectedItem().getFirstName());
    	tf_lastname.setText(Table.getSelectionModel().getSelectedItem().getLastName());
    	tf_login.setText(Table.getSelectionModel().getSelectedItem().getLogin());
    	tf_pass.setText(Table.getSelectionModel().getSelectedItem().getPass());

    }
   public void initialize(){
	   db=new DBConnector();
   }

}
