package application;
import java.sql.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddBidController implements Initializable{
	@FXML
	private TextField sculpamt;
	@FXML
	private Text scultext;
	@FXML
	public void getInitSculp(ActionEvent event)throws IOException
	{
		
		
		System.out.print("Entered getINIT");
		String scamt = sculpamt.getText();
		scultext.setText("Saved");
		System.out.println(scamt);
		sqlconnect("SCULPTURE",Float.parseFloat(scamt));
	}
	
	@FXML
	private TextField coinamt;
	@FXML
	private Text cointext;
	@FXML
	public void getInitCoin(ActionEvent event)throws IOException
	{
		
		System.out.print("Entered getINIT");
		String coamt = coinamt.getText();
		cointext.setText("Saved");
		System.out.println(coamt);
		sqlconnect("COIN",Float.parseFloat(coamt));

	}
	
	@FXML
	private TextField othamt;
	@FXML
	private Text othtext;
	@FXML
	public void getInitOth(ActionEvent event)throws IOException
	{
	
		System.out.print("Entered getINIT");
		String otamt = othamt.getText();
		othtext.setText("Saved");
		System.out.println(otamt);
		sqlconnect("OTHER",Float.parseFloat(otamt));

	}
	
	void sqlconnect(String str,double val)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root","12345678");
			Statement stmt=con.createStatement();
			System.out.println("Connected Database");
			String query = "UPDATE auction SET PRESENT_BID = "+val+" ,PAST_BID = "+val+",STATUS = 'N'"+"WHERE ITEM_TYPE ='"+str+"';";
			stmt.execute(query);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@FXML
	public void goHome(ActionEvent event) throws Exception
	{
		Parent pane;
		System.out.println("Bidding go to home");
		try
		{
			pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(pane);
			Stage curStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			curStage.setScene(scene);
			curStage.show();
		}catch(IOException e)
		{
			System.out.println(e);
		}

	}
	
	@FXML
	public void eexit(ActionEvent event)throws IOException
	{
		System.exit(0);
	}

	@FXML
	private Circle logo;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		
	}
	

}
