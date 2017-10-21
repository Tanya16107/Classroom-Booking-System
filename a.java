import java.util.*;
import java.io.*;

abstract class User implements Serializable{
	protected String emailID;
	private String password;

	public User(String emailID, String password){
		this.emailID = emailID;
		this.password = password;
	}

	@Override
	public boolean equals(Object o){
		User oo = (User) o;
		return oo.getEmailID().equals(emailID) && oo.getPassword().equals(password);
	}
	
	//public boolean roomIsAvailable(String room, String time, String date){

	//}

	public String getEmailID(){
		return emailID;
	}

	public String getPassword(){
		return password;
	}

	/*public viewRooms(){

	}
	*/

	public abstract void viewBookedRooms();
}

class Student extends User{

	private List<Course> myCourseList;
	private List<RequestedRoom> myBookedRooms;
	private Map<String, Course> postConditions;

	public Student(String emailID, String password){
		super(emailID, password);
	}

//	public Course searchCourse(String keyword){
//	}

	public void chooseCourse(Course c){
	}

	public void requestRoom(String purpose, int capacity){

	}

	public void requestRoom(String purpose, String preferredRoom, int capacity){

	}

	public void viewTimeTable(){

	}

	public void viewBookedRooms(){

	}

}

class Admin extends User{
	private List<RequestedRoom> requests;
	private List<String> bookedRooms;

	public Admin(String emailID, String password){
		super(emailID, password);
	}

	public void bookRoom(String room, String time, String date){

	}

	public void cancel(String room, String time, String date){
	
	}

	public void viewRequests(){

	}

	public void acceptRequest(RequestedRoom r){
	
	}

	public void rejectRequest(RequestedRoom r){

	}


	public void viewBookedRooms(){

	}


}

class Faculty extends User{
	private List<String> bookedRooms;

	public Faculty(String emailID, String password){
		super(emailID, password);
	}

	public void bookRoom(String room, String time, String date){

	}

	public void cancel(String room, String time, String date){
	
	}

	public void viewBookedRooms(){

	}

}

class Room{
	private String schedule;

//	public boolean isAvailable(String time, String date){

//	}

//	public boolean book(String time, String date){

//	}

}

class Course{
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

class RequestedRoom{
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

class App{
	static void mainMenu(){
		System.out.println("1. Create User:\n1. Student\n2. Faculty\n3. Admin\n");
		System.out.println("2. Login:\n1. Student\n2. Faculty\n3. Admin");
	}

	static void serialize(Object p, int c) throws IOException{
		ObjectOutputStream out = null;
		try{
			switch(c){
				case 1:
				{out = new ObjectOutputStream(new FileOutputStream("studentList.txt"));
				out.writeObject(p);
				break;}
								
				case 2:
				{out = new ObjectOutputStream(new FileOutputStream("facultyList.txt"));
				out.writeObject(p);
				break;}
								
				case 3:
				{out = new ObjectOutputStream(new FileOutputStream("adminList.txt"));
				out.writeObject(p);
				break;}
			}
			
			
		}
		finally{
			out.close();
		}

	}

	public static LinkedList<Student> deserializeStudentList() throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("studentList.txt"));
			return (LinkedList<Student>) in.readObject();
		}
		finally{
			in.close();
		}
	}

	public static LinkedList<Faculty> deserializeFacultyList() throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("facultyList.txt"));
			return (LinkedList<Faculty>) in.readObject();
		}
		finally{
			in.close();
		}
	}

	public static LinkedList<Admin> deserializeAdminList() throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("adminList.txt"));
			return (LinkedList<Admin>) in.readObject();
		}
		finally{
			in.close();
		}
	}


	public static void main(String[] args) throws Exception {

		/*new 
		LinkedList<Student> studentList = new LinkedList<Student>();
		LinkedList<Faculty> facultyList = new LinkedList<Faculty>();
		LinkedList<Admin> adminList = new LinkedList<Admin>();
		serialize(studentList, 1);
		serialize(facultyList, 2);
		serialize(adminList, 3);
		*/


		LinkedList<Student> studentList = deserializeStudentList();
		LinkedList<Faculty> facultyList = deserializeFacultyList();
		LinkedList<Admin> adminList = deserializeAdminList();
		
		Scanner sc = new Scanner(System.in);
		mainMenu();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		switch(c){
			case 1:
			{
				System.out.print("emailID: ");
				String emailID = sc.next();
				System.out.print("password: ");
				String password = sc.next();
				
				switch(d){
					case 1:
					{
					Student newUser = new Student(emailID, password);
					studentList.add(newUser);
					serialize(studentList, 1);
					break;
					}

					case 2:
					{
					Faculty newUser = new Faculty(emailID, password);
					facultyList.add(newUser);
					serialize(facultyList, 2);
					break;
					}

					case 3:
					{
					Admin newUser = new Admin(emailID, password);
					adminList.add(newUser);
					serialize(adminList, 3);
					break;
					}
				}
				break;
			}
			case 2:{
				//deserialize

				System.out.print("emailID: ");
				String emailID = sc.next();
				System.out.print("password: ");
				String password = sc.next();
				switch(d){
					case 1:{

						Student student = new Student(emailID, password);
						if(studentList.indexOf(student)==-1){
							System.out.println("Wrong Username/password");
						}
						else{
							student = studentList.get(studentList.indexOf(student));
						}
						break;
					}
					case 2:{

						Faculty faculty = new Faculty(emailID, password);

						if(facultyList.indexOf(faculty)==-1){
							System.out.println("Wrong Username/password");
						}
						else{
							faculty = facultyList.get(facultyList.indexOf(faculty));
						}
						break;
					}
					case 3:{

						Admin admin = new Admin(emailID, password);

						if(adminList.indexOf(admin)==-1){
							System.out.println("Wrong Username/password");
						}
						else{
							admin = adminList.get(adminList.indexOf(admin));
						}
						break;
					}
				}
				break;


			}
		}

		
	}
}
