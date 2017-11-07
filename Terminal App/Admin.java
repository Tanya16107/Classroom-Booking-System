import java.util.*;
import java.io.*;

public class Admin extends User{

	private static final long serialVersionUID = 30L;
	private List<RequestedRoom> requests;
	private List<String> bookedRooms;

	public Admin(String emailID, String password){
		super(emailID, password);
		bookedRooms = new LinkedList<String>();
	}

	public void bookRoom(String room,  String fromTime, String toTime, String date){

	}

	public void cancel(String room, String time, String date){
	
	}


	public void acceptRequest(RequestedRoom r){
	
	}

	public void rejectRequest(RequestedRoom r){

	}


	public void viewBookedRooms(){
		for(int i=0; i<bookedRooms.size(); i++){
			System.out.println(bookedRooms.get(i));
		}

	}


}
