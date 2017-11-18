import java.util.*;
import java.io.*;

public abstract class User implements Serializable{
	protected String emailID;
	protected String password;
	protected String name;

	public User(String emailID, String password, String name){
		this.emailID = emailID;
		this.password = password;
		this.name = name;
	}

	@Override
	public boolean equals(Object o){
		User oo = (User) o;
		return oo.getEmailID().equals(emailID) && oo.getPassword().equals(password);
	}

	public void setPassword(String x){
		this.password = x;
	}
	
	
	//public boolean roomIsAvailable(String room, String time, String date){

	//}

	public String getEmailID(){
		return emailID;
	}

	public String getPassword(){
		return password;
	}

	public String getNaam(){
		return name;
	}

	/*public viewRooms(){

	}
	*/

	public abstract void viewBookedRooms();
}