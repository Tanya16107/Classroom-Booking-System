import java.util.*;
import java.io.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;



public class RequestedRoom implements Serializable{
	private static final long serialVersionUID = 7L;
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

	}

	@Override
	public String toString(){
		return (preferredRoom+" "+capacity+" "+purpose);
	}
}
