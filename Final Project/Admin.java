import java.util.*;
import java.io.*;

import javafx.collections.ObservableList;

import javafx.collections.FXCollections;

public class Admin extends User{

	private static final long serialVersionUID = 3L;
	private LinkedList<Booking> bookedRooms;

	public Admin(String emailID, String password, String name){
		super(emailID, password, name);
		bookedRooms = new LinkedList<Booking>();
	}


	public boolean adminMatch(Admin s){
		return this.getEmailID().equals(s.getEmailID());
	}


	public void addMyBooking(String room, String date, String time){
		Datime z = new Datime(date, time);
		Booking x = new Booking(room, z);
		bookedRooms.add(x);
	}

	public void cancelMyBooking(Booking z) throws Exception{
		bookedRooms.remove(z);
		
	}



	public LinkedList<Booking> getBookedRoomsLL(){
		return bookedRooms;
	}


	public ArrayList<String> getMyBookedRooms(){
		ArrayList<String> out = new ArrayList<String>();
		for(Booking b: bookedRooms){
			out.add(b.getRoom()+" "+b.getTime().retDate()+" "+b.getTime().retTime());
		}

		return out;

	}

	public void viewBookedRooms(){
		

	}


}
