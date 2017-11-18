import java.util.*;
import java.io.*;

import javafx.collections.ObservableList;

import javafx.collections.FXCollections;


//to view a student's TT: Time t = new Time(); String[][] table = T.viewStudent(student)
//to search courses: Search Temp = new Search(); ArrayList<String> S = Temp.ShowSearch(this,"proofs functions");
public class Student extends User{

	private static final long serialVersionUID = 1L;

	private List<Course> myCourseList;

	public Student(String emailID, String password, String name){
		super(emailID, password, name);
		myCourseList = new LinkedList<Course>();
	}

	public boolean studentMatch(Student s){
		return this.getEmailID().equals(s.getEmailID());
	}

//	public Course searchCourse(String keyword){
//	}
	public void AddMandatory(Course c){
		myCourseList.add(c);	
	}



	public List<Course> getCourses(){
		return myCourseList;	
	}



	public void viewBookedRooms(){
		

	}

}
