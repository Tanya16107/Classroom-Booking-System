import java.util.*;
import java.io.*;

public class Student extends User{

	private static final long serialVersionUID = 1L;

	private List<Course> myCourseList;
	private List<RequestedRoom> myBookedRooms;

	public Student(String emailID, String password){
		super(emailID, password);
		myCourseList = new LinkedList<Course>();
		myBookedRooms = new LinkedList<RequestedRoom>();
	}

//	public Course searchCourse(String keyword){
//	}
	public void AddMandatory(Course c){
	myCourseList.add(c);	
	}
	public void chooseCourse(){
		Search Temp=new Search();
		ArrayList<String> S=Temp.ShowSearch(this,"proofs functions");
		for(int i=0;i<S.size();i++)
			System.out.println(S.get(i));
	}
	

	public void requestRoom(RequestedRoom r){
		myBookedRooms.add(r);

	}
	public List<Course> getCourses(){
		return myCourseList;	
	}

	public void viewTimeTable(){
		Time T=new Time();
		String[][] Table=T.ViewStud(this);
		for(int i=0;i<7;i++)
			{
				for(int j=0;j<20;j++)
					System.out.print(Table[i][j]+" ");
				System.out.println();
			}
	}

	public void viewBookedRooms(){
		for(int i=0; i<myBookedRooms.size(); i++){
			System.out.println(myBookedRooms.get(i));
		}

	}
	public static void main(String[] args)
	{
		try{
			List<Course> L=new ArrayList<Course>();
			FileInputStream F=new FileInputStream("db_Courses.txt");
			ObjectInputStream O=new ObjectInputStream(F);
			L=(List<Course>)O.readObject();
			Student S=new Student("lsd","69");
			//S.AddMandatory(L.get(0));
			S.AddMandatory(L.get(1));
			S.AddMandatory(L.get(2));
			S.AddMandatory(L.get(12));
			//S.AddMandatory(L.get(6));
			S.viewTimeTable();
			S.chooseCourse();
		}catch(Exception E)
		{
			E.printStackTrace();
		}
	}

}
