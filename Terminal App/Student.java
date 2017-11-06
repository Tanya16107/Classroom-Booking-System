import java.util.*;
import java.io.*;

public class Student extends User{

	private static final long serialVersionUID = 21L;

	private List<Course> myCourseList;
	private List<RequestedRoom> myBookedRooms;
	private Map<String, Course> postConditions;

	public Student(String emailID, String password){
		super(emailID, password);
	}

//	public Course searchCourse(String keyword){
//	}

	public void chooseCourse(Course c){
	}

	public void requestRoom(String purpose, int capacity){

	}

	public void requestRoom(String purpose, String preferredRoom, int capacity){

	}

	public void viewTimeTable(){

	}

	public void viewBookedRooms(){

	}

}