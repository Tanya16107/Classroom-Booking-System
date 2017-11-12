import java.util.*;
import java.io.*;

public class Faculty extends User{
	private static final long serialVersionUID = 2L;
	private List<String> bookedRooms;
	private List<Course> myCourseList;


	public Faculty(String emailID, String password){
		super(emailID, password);
		bookedRooms = new LinkedList<String>();
		myCourseList = new LinkedList<Course>();

	}

	public void bookRoom(String room, String fromTime, String toTime, String date){

	}

	public void cancel(String room, String time, String date){
	
	}

	public void viewBookedRooms(){

	}

	public void addMyCourse(Course c){
		myCourseList.add(c);
	}

	public void viewMyCourses(){
		for(int i=0; i<bookedRooms.size(); i++){
			System.out.println(bookedRooms.get(i));
		}
	}

}
