import java.util.*;
import java.io.*;

public class RequestedRoom implements Serializable{
	private String purpose;
	private String preferredRoom;
	private int capacity;
	private int timeSinceRequest;
	private String status;

	public RequestedRoom(String preferredRoom, int capacity, String purpose){
		this.preferredRoom = preferredRoom;
		this.capacity = capacity;
		this.purpose = purpose;
	}

	public String getPurpose(){
		return purpose;

	}
	public String getPreferredRoom(){
		return preferredRoom;

	}

	public int getCapacityOfRequiredRoom(){
		return capacity;

	}

	public int getTimeSinceRequest(){
		return timeSinceRequest;

	}

	public String getStatus(){
		return status;

	}

	public void setStatus(String s){

	}

	@Override
	public String toString(){
		return (preferredRoom+" "+capacity+" "+purpose);
	}
}