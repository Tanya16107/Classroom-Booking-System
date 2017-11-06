import java.util.*;
import java.io.*;

public class Course{
	private String room;
	private String timeSlot;
	private String audience;
	private String postConditions;

	public String getVenue(){
		return  room;
	}

	public String getTimeSlot(){
		return timeSlot;

	}
	
	public String getAudience(){
		return audience;
	}

	public String getPostConditions(){
		return postConditions;

	}
}