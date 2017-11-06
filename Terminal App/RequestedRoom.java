import java.util.*;
import java.io.*;

public class RequestedRoom{
	private String purpose;
	private String preferredRoom;
	private int capacity;
	private int timeSinceRequest;
	private String status;

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
}