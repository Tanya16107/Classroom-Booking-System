import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login extends Application
{
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws IOException 
	{
		FXMLLoader fxmlLoader = new FXMLLoader();
		
		FileInputStream fxmlFile = new FileInputStream("login.fxml");

		AnchorPane root = (AnchorPane) fxmlLoader.load(fxmlFile);
		
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setResizable(false);

		stage.setTitle("Classroom Booking System");

		stage.show();
	}
}