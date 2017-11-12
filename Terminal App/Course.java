import java.util.*;
import java.io.*;

class Slot implements Serializable{
	private String category;
	private String venue;
	private String time;

	public Slot(String category, String venue, String time){
		this.category = category;
		this.venue = venue;
		this.time = time;
	}
	public String getTime(){
		return time;
	}
	public String getCatVen(){
		return venue+" "+category;
	}
	public String toString(){
		return category+" "+time+" "+venue;
	}
}

public class Course implements Serializable{
	private String name;
	private String code;
	private String type;
	private String instructor;
	private int credits;
	private String preConditions;
	private String postConditions;
	private LinkedList[] schedule = new LinkedList[5];  // 0 = Monday, 1 = Tuesday ...

	public Course(String name, String code, String type, String instructor, int credits, String preConditions, String postConditions){
		this.name = name;
		this.code = code;
		this.type = type;
		this.instructor = instructor;
		this.credits = credits;
		this.preConditions = preConditions;
		this.postConditions = postConditions;
		for(int i=0; i<5; i++){
			schedule[i] = new LinkedList();
		}
		

	}
	public LinkedList[] getSchedule(){
		return schedule;
	}
	public void buildSchedule(int i, Slot s){
		schedule[i].add(s);
	}
	public String getCode(){
		return code;
	}
	public String toString(){
		return name+" "+code+" "+type+" "+instructor+" "+String.valueOf(credits);

	}

	public void printSchedule(){
		for(int i=0; i<5; i++){
			System.out.print(i+"->");  //day : 0 = Monday, 1= Tuesday...
			LinkedList l = schedule[i];
			for (int j = 0; j < l.size(); j++) {
            System.out.print(l.get(j));
        }
	System.out.println();
			
		}
	}



}
