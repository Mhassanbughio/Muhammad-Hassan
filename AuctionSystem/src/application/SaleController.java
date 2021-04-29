package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SaleController {
	
	@FXML
	private TextField phno;
	
	@FXML
	
	private TextField amt;
	@FXML
	public void Exxxit(ActionEvent event) throws Exception
	{
		String pno = phno.getText();
		String am = amt.getText();
		
		System.out.println(pno+" "+am);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root","12345678");
			Statement stmt=con.createStatement();
			System.out.println("Connected Database");
			String query1 = "INSERT INTO payment VALUES("+"'"+pno+"',"+"'"+am+"');";
			stmt.execute(query1);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		System.exit(0);
	}

}
