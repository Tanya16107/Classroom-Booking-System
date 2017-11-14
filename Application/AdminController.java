import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.io.*;
import java.util.*;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.scene.Parent;

public class AdminController
{
	@FXML
	Label email;

	@FXML
	Button logoutButton;
	
	
	
	// Add a public no-args constructor
	public AdminController() 
	{

	}


	
	@FXML
	private void initialize() 
	{
	}


	@FXML
	public void setUp(Admin s){
		this.email.setText(s.getEmailID());
	}

	@FXML
	public void logout() throws Exception{
		Stage stage =(Stage) logoutButton.getScene().getWindow(); 
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));		
		Scene scene = new Scene(root); 
		stage.setScene(scene);    
		stage.show();
	}
	

}