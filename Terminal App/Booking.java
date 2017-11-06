import java.util.*;
import java.io.*;

public class Booking implements Serializable{
	String details;

	GregorianCalendar start;
	GregorianCalendar end;

	private boolean recurWeekly = false;
	private boolean recurMonthly = false;
	private boolean recurYearly = false;

	private int numRecurrences = 0;

	
	/* Day(s) of the week that the appointment recurs on 
	index - day
	0 - Sun
	1 - Mon
	2 - Tues
	3 - Wed
	4 - Thurs
	5 - Fri
	6 - Sat */

    private boolean[] recurOnDays;

    public Booking(GregorianCalendar start, GregorianCalendar end, String details){
    	this.start = start;
    	this.end = end;
    	details = details;
    }

    public void recurWeekly(){

    }

}