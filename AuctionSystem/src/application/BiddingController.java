package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BiddingController implements Initializable
{

	@FXML
	public void goHome(ActionEvent event) throws Exception//goes back to the main page
	{
		Parent pane;
		System.out.println("Bidding go to home");
		try
		{
			pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));//loads the mainfxml 
			Scene scene = new Scene(pane);
			Stage curStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			curStage.setScene(scene);
			curStage.show();
		}catch(IOException e)
		{
			System.out.println(e);
		}

	}
	
	void sqlAddBid(String str,double val)//This Function Adds a newBid by the customer
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root","12345678");
			Statement stmt=con.createStatement();
			System.out.println("Connected Database");
			String query1 = "UPDATE auction SET PAST_BID = PRESENT_BID ,STATUS = 'N'"+"WHERE ITEM_TYPE ='"+str+"';";
			String query2 = "UPDATE auction SET PRESENT_BID = "+val+" ,STATUS = 'N'"+"WHERE ITEM_TYPE ='"+str+"';";
			stmt.execute(query1);
			stmt.execute(query2);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	double sqlPresentBid(String str)//This returns the present bid value
	{
		String value = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root","12345678");
			Statement stmt=con.createStatement();
			System.out.println("Connected Database");
			String query1 = "SELECT PRESENT_BID FROM auction WHERE ITEM_TYPE ='"+str+"';";
			ResultSet rs = stmt.executeQuery(query1);//create an object of result set
			while (rs.next())
			{
                value = rs.getString(1);//retrieving only value
			}
			System.out.println(value);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(Double.parseDouble(value));
	}
	double sqlPastBid(String str)//gets data from pastbid column of sql
	{
		String value = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root","12345678");
			Statement stmt=con.createStatement();
			System.out.println("Connected Database");
			String query1 = "SELECT PAST_BID FROM auction WHERE ITEM_TYPE ='"+str+"';";
			stmt.execute(query1);
			ResultSet rs = stmt.executeQuery(query1);
			while (rs.next())
			{
                value = rs.getString(1);
			}
			System.out.println(value);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return(Double.parseDouble(value));
	}
	
	@FXML
	public void Exxit(ActionEvent event) throws Exception
	{
		System.exit(0);
	}
	
	//C,S,O represents Coins, Structures and Others respectively
	
	@FXML
	private TextField CPastBid;
	@FXML
	private TextField CPresentBid;
	@FXML
	private TextField CBid;
	@FXML
	private void CshowBid(ActionEvent event)throws Exception
	{	
		double CPreValue = sqlPresentBid("COIN");//Pre-present-used to retrieve value from table
		String CPreTex = Double.toString(CPreValue);
		CPresentBid.setText(CPreTex);
		System.out.print(CPreTex);
		

		
		double CPasValue = sqlPastBid("COIN");//Pas-past
		String CPasTex = Double.toString(CPasValue);
		CPastBid.setText(CPasTex);
		System.out.print(CPasTex);
		
		String newVal = CBid.getText();
		if(Double.parseDouble(newVal)>CPreValue)
			sqlAddBid("COIN",Double.parseDouble(newVal));
			
	}
	
	//For Sculptures
	@FXML
	private TextField SPastBid;
	@FXML
	private TextField SPresentBid;
	@FXML
	private TextField SBid;
	@FXML
	private void SshowBid(ActionEvent event)throws Exception
	{	
		double SPreValue = sqlPresentBid("SCULPTURE");//Pre-present
		String SPreTex = Double.toString(SPreValue);
		SPresentBid.setText(SPreTex);
		System.out.print(SPreTex);
		

		
		double SPasValue = sqlPastBid("SCULPTURE");//Pas-past
		String SPasTex = Double.toString(SPasValue);
		SPastBid.setText(SPasTex);
		System.out.print(SPasTex);
		
		String newVal = SBid.getText();
		if(Double.parseDouble(newVal)>SPreValue)
			sqlAddBid("SCULPTURE",Double.parseDouble(newVal));
			
	}
	
	//For Others
	@FXML
	private TextField OPastBid;
	@FXML
	private TextField OPresentBid;
	@FXML
	private TextField OBid;
	@FXML
	private void OshowBid(ActionEvent event)throws Exception
	{	
		double OPreValue = sqlPresentBid("OTHER");//Pre-present
		String OPreTex = Double.toString(OPreValue);
		OPresentBid.setText(OPreTex);
		System.out.print(OPreTex);
		

		
		double OPasValue = sqlPastBid("OTHER");//Pas-past
		String OPasTex = Double.toString(OPasValue);
		OPastBid.setText(OPasTex);
		System.out.print(OPasTex);
		
		String newVal = OBid.getText();
		if(Double.parseDouble(newVal)>OPreValue)
			sqlAddBid("OTHER",Double.parseDouble(newVal));
			
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
