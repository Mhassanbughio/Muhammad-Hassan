package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminLoginController implements Initializable{
	
	@FXML
	private Label msg;
	@FXML
	private PasswordField pass;
	@FXML
	public void getpassword(ActionEvent event) throws IOException 
	{
		Parent pane;
		String password = pass.getText();
		System.out.println(password);
		if(password.equals("password"))
			{
			System.out.println("Correct");
			msg.setText("valid");
			//FROM HERE WE NAVIGATE TO INITIAL BID PAGE
				try
				{
					pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AddBid.fxml"));
					Scene scene = new Scene(pane);
					Stage curStage = (Stage)((Node)event.getSource()).getScene().getWindow();
					curStage.setScene(scene);
					curStage.show();
				}catch(IOException e)
				{
					System.out.println(e);
				}
			}
			
			else
			{
				System.out.println("Incorrect");
				msg.setText("Invalid!");
			}
		}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
