package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;



public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	public void runTask()
	{
		String command = "echo 12345678 | sudo -S -k service mysql start";


		try {
			Process process = Runtime.getRuntime().exec(command);


			System.out.println("Executing cmd");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{ 
		runTask();
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene  = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Auction System");
		primaryStage.show();
		
	}

}
