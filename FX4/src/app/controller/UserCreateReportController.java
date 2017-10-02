package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.ReportModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class UserCreateReportController {

	   @FXML
	    private ImageView iv_back;

	    @FXML
	    private TextField tf_serv1hours;

	    @FXML
	    private TextField tf_serv2hours;

	    @FXML
	    private Label lbl_rate1;

	    @FXML
	    private Label lbl_rate2;

	    @FXML
	    private Label lbl_serv2name;

	    @FXML
	    private Label lbl_serv1name;

	    @FXML
	    private Button btn_submit;

	    @FXML
	    private Label lbl_suma;

	    @FXML
	    private Slider sld_month;
	 
	    LoginController lu = new LoginController();
	    
	    



	    @FXML
	    void action_submit(MouseEvent event) throws ClassNotFoundException, SQLException {
	    	double sumServ1=0;
	    	double sumServ2=0;
	    	double sumNet=0;
	    	double sumGross=0;
	    	
	    	java.sql.PreparedStatement preparedStatement= null;
	    	Connection conn=db.Connection();
	    	ResultSet rs;
	    	//String emp_id = "Select id_em from employee,log where login='"+lu.getLogin()+"' and employee.id_e = log.id;";
	    	int IndxEmp = 0;
	    	System.out.println("Login: "+lu.getLogin());
	    	
	    	rs = conn.createStatement().executeQuery("Select id_e From employee, log where login= '"+lu.getLogin()+"' and employee.id_e = log.id ;");
	    	rs.next();
	    	IndxEmp=rs.getInt(1);
	    	System.out.println(IndxEmp);
	    	
	    	sumServ1= Double.valueOf(tf_serv1hours.getText())*10;
	    	sumServ2= Double.valueOf(tf_serv2hours.getText())*20;
	    	sumNet=sumServ1+sumServ2;
	    	sumGross=(sumNet*0.23)+sumNet;
	    	
	    	
	    	
	    	String sql1="INSERT into summary (id_em,Month, hrs_service1, hrs_service2, ttl_service1, ttl_service2, ttl_gross, ttl_net, ttl_sum) values (?,?,?,?,?,?,?,?,?) ";
	    	preparedStatement=conn.prepareStatement(sql1);
	    	preparedStatement.setInt(1,IndxEmp );
	    	preparedStatement.setInt(2, (int) (sld_month.getValue()));
	    	preparedStatement.setString(3,(String) tf_serv1hours.getText());
	    	preparedStatement.setString(4, (String)tf_serv2hours.getText());
	    	preparedStatement.setDouble(5, sumServ1);
	    	preparedStatement.setDouble(6, sumServ2);
	    	preparedStatement.setDouble(7, sumGross);
	    	preparedStatement.setDouble(8, sumNet);
	    	preparedStatement.setString(9, "0");
	    	preparedStatement.executeUpdate();
	    	tf_serv1hours.clear();
	    	tf_serv2hours.clear();
	    	
	    	lbl_suma.setText("Thank you for submitting your report");
	    	
	    }
   
    public DBConnector db;
    public ObservableList<ReportModel> data=FXCollections.observableArrayList();


    @FXML
    void select_month(ActionEvent event) {
    }
             
          //HBox hbox = new HBox(menuButton);
    
    
    
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
	    public void initialize(){
	  	   db=new DBConnector();
	}
	    }

	

