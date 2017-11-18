import java.util.*;
import java.io.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;

import java.time.LocalDateTime;



public class RequestedRoom implements Serializable{
	private static final long serialVersionUID = 7L;
	private String purpose;
	private String preferredRoom;
	private int capacity;

	private String date;
	private String time;

	private String status = "Awaited";
	private String by;

	private LocalDateTime validTill;

	public RequestedRoom(String preferredRoom, int capacity, String purpose, String date, String time, String by){
		this.preferredRoom = preferredRoom;
		this.capacity = capacity;
		this.purpose = purpose;
		this.by = by;
		this.date = date;
		this.time = time;
		validTill = LocalDateTime.now().plusDays(5);


	}


	public boolean valid(){
		LocalDateTime current = LocalDateTime.now();
		if(current.isBefore(validTill)){
			return true;
		}
		else
			return false;
	}

	public String getBy(){
		return by;
	}

	public String getDate(){
		return date;

	}
	public String getTime(){
		return time;

	}

	@Override
	public boolean equals(Object o){
		RequestedRoom r = (RequestedRoom) o;
		return r.getPreferredRoom().equals(preferredRoom) && r.getCapacityOfRequiredRoom()==capacity && r.getPurpose().equals(purpose) && r.getBy().equals(by) && r.getDate().equals(date) && r.getTime().equals(time);
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
/*
	public int getTimeSinceRequest(){
		return timeSinceRequest;

	}
*/
	public String getStatus(){
		return status;

	}


	public StringProperty getPurposeProperty(){
		return new SimpleStringProperty(purpose);

	}
	public StringProperty getPreferredRoomProperty(){
		return new SimpleStringProperty(preferredRoom);

	}

	public IntegerProperty getCapacityProperty(){
		return new SimpleIntegerProperty(capacity);

	}

	public StringProperty getStatusProperty(){
		return new SimpleStringProperty(status);

	}

	public void setStatus(String s){
		this.status = s;
	}

	@Override
	public String toString(){
		return (getPurpose()+" "+getPreferredRoom()+" "+getCapacityOfRequiredRoom()+" "+getDate()+" "+getTime());
	}
}