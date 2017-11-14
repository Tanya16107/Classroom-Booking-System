import java.util.*;
import java.io.*;

public class Room{
	private String Name;
	private LinkedList<Datime> SpecialBooking;
	public Room(String Name)
	{
		this.Name=Name;
		SpecialBooking=new LinkedList<Datime>();
	}
	public String getRoom()
	{
		return Name;
	}
	public void Show(int Week)
	{
		Time T=new Time();
		T.ViewRoom(this,Week);
	}
	public LinkedList<Datime> getBook()
	{
		return SpecialBooking;
	}
	public static void main(String[] args)
	{
		/*
		List<Course> L=new ArrayList<Course>();
		FileInputStream F=new FileInputStream("db_Courses.txt");
		ObjectInputStream O=new ObjectInputStream(F);
		L=(List<Course>)O.readObject();
		for(int i=0;i<O.size();i++)
		{	
			LinkedList[] Temp=O.get(i).getSchedule();
			for(int j=0;j<5;j++)
			{
				LinkedList Temp2=Temp[j];
				
				Similar approach as in Time.java
				
			}
		}
		*/
		Room M=new Room("C21");
		M.book("8:30-9:30","1/8/17");
		M.Show(1);
		M.book("10:00-11:00","9/8/17");
		M.Show(2);
	}		

/*	public boolean isAvailable(String fromtime, String date){

	}
*/
	public void book(String time, String date){
		Datime M=new Datime(date,time); 
		SpecialBooking.add(M);
	}

}
