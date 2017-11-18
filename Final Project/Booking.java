import java.util.*;
import java.io.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;


public class Booking implements Serializable{
	private Datime a;
	private String room;

	public Booking(String room, Datime a){
		this.a = a;
		this.room = room;
	}


	public Datime getTime(){
		return a;
	}

	public String getRoom(){
		return room;
	}

	public StringProperty getDateProperty(){
		return new SimpleStringProperty(a.retDate());
	}

	public StringProperty getTimeProperty(){
		return new SimpleStringProperty(a.retTime());
	}

	public StringProperty getRoomProperty(){
		return new SimpleStringProperty(room);
	}

	@Override
	public String toString(){
		return getRoom()+" "+a.retDate()+" "+a.retTime();
	}




}