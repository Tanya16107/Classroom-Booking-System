import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import javafx.scene.control.ComboBox;

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

public class StudentController
{

	Student student;

	LinkedList<Student> studentList;

	@FXML
	Label email;

	@FXML
	ComboBox roomCombo;

	@FXML
	TextField capacity;

	@FXML
	TextArea purpose;

	@FXML
	Button logoutButton;

	@FXML
	TableView<RequestedRoom> bookingsTable;

	@FXML
	TableColumn<RequestedRoom, String> purposeColumn;

	@FXML
	TableColumn<RequestedRoom, Integer> capacityColumn;

	@FXML
	TableColumn<RequestedRoom, String> prefRoomColumn;

	
	
	
	// Add a public no-args constructor
	public StudentController() 
	{

	}


	
	@FXML
	private void initialize() 
	{
		purposeColumn.setCellValueFactory(cellData -> cellData.getValue().getPurposeProperty());
		capacityColumn.setCellValueFactory(cellData -> cellData.getValue().getCapacityProperty().asObject());
		prefRoomColumn.setCellValueFactory(cellData -> cellData.getValue().getPreferredRoomProperty());


	}


	@FXML
	public void setUp(Student s, LinkedList<Student> studentList){
		this.student = s;
		this.studentList = studentList;
		this.email.setText(s.getEmailID());
		bookingsTable.setItems(s.getMyBookedRooms());
	}

	@FXML
	public void logout() throws Exception{
		Stage stage =(Stage) logoutButton.getScene().getWindow(); 
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));		
		Scene scene = new Scene(root); 
		stage.setScene(scene);    
		stage.show();
	}

	@FXML
	public void reqRoomButton() throws Exception{
		String prefRoom = roomCombo.getSelectionModel().getSelectedItem().toString();
		RequestedRoom r = new RequestedRoom(prefRoom, Integer.valueOf(capacity.getText()), purpose.getText());
		this.student.requestRoom(r);
		bookingsTable.setItems(this.student.getMyBookedRooms());
		ObjectOutputStream out = null;
		out = new ObjectOutputStream(new FileOutputStream("studentList.txt"));
		out.writeObject(studentList);
		
	}

	@FXML
	public void refresh(){
		bookingsTable.setItems(this.student.getMyBookedRooms());
	}
	

}
