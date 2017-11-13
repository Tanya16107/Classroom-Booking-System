import java.util.*;
import java.io.*;

public class Student extends User{

	private static final long serialVersionUID = 1L;

	private List<Course> myCourseList;
	private List<RequestedRoom> myBookedRooms;
	private Map<String, Course> postConditions;

	public Student(String emailID, String password){
		super(emailID, password);
		myCourseList = new LinkedList<Course>();
		myBookedRooms = new LinkedList<RequestedRoom>();
	}

//	public Course searchCourse(String keyword){
//	}
	public void AddMandatory(Course c){
	myCourseList.add(c);	
	}
	public void chooseCourse(Course c){
	}
	

	public void requestRoom(RequestedRoom r){
		myBookedRooms.add(r);

	}
	public List<Course> getCourses(){
		return myCourseList;	
	}

	public void viewTimeTable(){

	}

	public void viewBookedRooms(){
		for(int i=0; i<myBookedRooms.size(); i++){
			System.out.println(myBookedRooms.get(i));
		}

	}

}
