import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
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

public class loginController
{
	@FXML
	TextField emailID;

	@FXML
	PasswordField password;

	@FXML
	RadioButton sel_student;
	
	@FXML
	RadioButton sel_admin;

	@FXML
	RadioButton sel_faculty;

	@FXML
	Button loginButton;


	
	
	
	// Add a public no-args constructor
	public loginController() 
	{

	}


	
	@FXML
	private void initialize() 
	{
	}
	
	@FXML
	private void login() throws Exception
	{	
		if(emailID.getText().length()==0 && password.getText().length()==0){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please enter the details");
			alert.showAndWait();
			return;
		}

		if(!userTypeSelected()){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please choose the user type");
			alert.showAndWait();
			return;
		}

		if(emailID.getText().length()==0){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please enter your Email-ID");
			alert.showAndWait();
			return;
		}

		if(password.getText().length()==0){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please enter a password");
			alert.showAndWait();
			return;
		}

		if(sel_student.isSelected()){
			ObjectInputStream in = null;			
			in = new ObjectInputStream(new FileInputStream("studentList.txt"));
			LinkedList<Student> studentList = (LinkedList<Student>) in.readObject();

			Student student = new Student(emailID.getText(), password.getText());
				if(studentList.indexOf(student)==-1){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Wrong Username/password");
					alert.showAndWait();
					return;
				}
				else{
					student = studentList.get(studentList.indexOf(student));
					Stage stage =(Stage) loginButton.getScene().getWindow(); 

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("student_home.fxml"));   
					Parent root = fxmlLoader.load();          
					StudentController sc = fxmlLoader.<StudentController>getController();
					
					sc.setUp(student, studentList); 
					Scene scene = new Scene(root); 
					stage.setScene(scene);    
					stage.show();   



      				/*

					System.out.println(student.getEmailID());
					studentController sc = new studentController(student);
					
     				Parent root = FXMLLoader.load(getClass().getResource("student_home.fxml"));
     				Scene scene = new Scene(root);
      				stage.setScene(scene);
      				stage.show();
      				*/
					/*
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Login Successful!");
					alert.showAndWait();
					*/
					return;
				}
		}

		if(sel_admin.isSelected()){
			ObjectInputStream in = null;			
			in = new ObjectInputStream(new FileInputStream("adminList.txt"));
			LinkedList<Admin> adminList = (LinkedList<Admin>) in.readObject();

			Admin admin = new Admin(emailID.getText(), password.getText());
				if(adminList.indexOf(admin)==-1){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Wrong Username/password");
					alert.showAndWait();
					return;
				}
				else{
					admin = adminList.get(adminList.indexOf(admin));

					Stage stage =(Stage) loginButton.getScene().getWindow();
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.fxml"));
					Parent root = fxmlLoader.load();  
					AdminController ac = fxmlLoader.<AdminController>getController();
					ac.setUp(admin);
     				Scene scene = new Scene(root);
      				stage.setScene(scene);
      				stage.show();
      				/*
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Login Successful!");
					alert.showAndWait();
					*/
					return;
				}
		}

		if(sel_faculty.isSelected()){
			ObjectInputStream in = null;			
			in = new ObjectInputStream(new FileInputStream("facultyList.txt"));
			LinkedList<Faculty> facultyList = (LinkedList<Faculty>) in.readObject();

			Faculty faculty = new Faculty(emailID.getText(), password.getText());
				if(facultyList.indexOf(faculty)==-1){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Wrong Username/password");
					alert.showAndWait();
					return;
				}
				else{
					faculty = facultyList.get(facultyList.indexOf(faculty));

      				Stage stage =(Stage) loginButton.getScene().getWindow();
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("faculty.fxml"));
					Parent root = fxmlLoader.load();  
					FacultyController fc = fxmlLoader.<FacultyController>getController();
					fc.setUp(faculty);
     				Scene scene = new Scene(root);
      				stage.setScene(scene);
      				stage.show();




      				/*
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Login Successful!");
					alert.showAndWait();
					*/
					return;
				}
		}
		
		
	}

	@FXML
	private boolean userTypeSelected(){
		return sel_admin.isSelected() || sel_student.isSelected() || sel_faculty.isSelected();
	} 

	@FXML
	public void signUp() throws Exception{

		if(emailID.getText().length()==0 && password.getText().length()==0){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please enter the details");
			alert.showAndWait();
			return;
		}

		if(!userTypeSelected()){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please choose the user type");
			alert.showAndWait();
			return;
		}

		if(emailID.getText().length()==0){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please enter your Email-ID");
			alert.showAndWait();
			return;
		}

		if(password.getText().length()==0){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please enter a password");
			alert.showAndWait();
			return;
		}

		if(emailID.getText().length()!=0 && password.getText().length()!=0 && userTypeSelected()){
			if(sel_student.isSelected()){
				Student newUser = new Student(emailID.getText(), password.getText());
					
					//deserialize
					ObjectInputStream in = null;
					
					in = new ObjectInputStream(new FileInputStream("studentList.txt"));
					LinkedList<Student> studentList = (LinkedList<Student>) in.readObject();

					if(studentList.indexOf(newUser)==-1){
					
					//add user 
					studentList.add(newUser);
					

					//serialize
					ObjectOutputStream out = null;
					out = new ObjectOutputStream(new FileOutputStream("studentList.txt"));
					out.writeObject(studentList);
					}

					else{
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("User already exists!");
						alert.showAndWait();
					}
					return;
				}
			}

			if(sel_admin.isSelected()){
				Admin newUser = new Admin(emailID.getText(), password.getText());
					//deserialize
					ObjectInputStream in = null;
					
					in = new ObjectInputStream(new FileInputStream("adminList.txt"));
					LinkedList<Admin> adminList = (LinkedList<Admin>) in.readObject();
					
					 if(adminList.indexOf(newUser)==-1){
					//add user 
					adminList.add(newUser);
					

					//serialize
					ObjectOutputStream out = null;
					out = new ObjectOutputStream(new FileOutputStream("adminList.txt"));
					out.writeObject(adminList);

					}

					else{
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("User already exists!");
						alert.showAndWait();
					}
					return;

			}

			if(sel_faculty.isSelected()){
				Faculty newUser = new Faculty(emailID.getText(), password.getText());
					//deserialize
					ObjectInputStream in = null;
					
					in = new ObjectInputStream(new FileInputStream("facultyList.txt"));
					LinkedList<Faculty> facultyList = (LinkedList<Faculty>) in.readObject();
					
				
					if(facultyList.indexOf(newUser)==-1){
					//add user 
					facultyList.add(newUser);
					

					//serialize
					ObjectOutputStream out = null;
					out = new ObjectOutputStream(new FileOutputStream("facultyList.txt"));
					out.writeObject(facultyList);
					}

					else{
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("User already exists!");
						alert.showAndWait();
					}
					return;
			}
			}


		}

	
	
