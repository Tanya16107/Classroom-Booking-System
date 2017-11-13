import java.util.*;
import java.io.*;

public abstract class User implements Serializable{
	protected String emailID;
	private String password;

	public User(String emailID, String password){
		this.emailID = emailID;
		this.password = password;
	}

	@Override
	public boolean equals(Object o){
		User oo = (User) o;
		return oo.getEmailID().equals(emailID) && oo.getPassword().equals(password);
	}
	
	
	//public boolean roomIsAvailable(String room, String time, String date){

	//}

	public String getEmailID(){
		return emailID;
	}

	public String getPassword(){
		return password;
	}

	/*public viewRooms(){

	}
	*/

	public abstract void viewBookedRooms();
}