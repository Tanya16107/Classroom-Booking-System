import java.util.*;
import java.io.*;


class ClashCheckApp{
	public static void main(String[] args) throws Exception{
		FileInputStream F=new FileInputStream("db_Courses.txt");
		ObjectInputStream O=new ObjectInputStream(F);
		List<Course> L=(List<Course>)O.readObject();

		for(int i=0; i<L.size(); i++){
			Course a = L.get(i);
			//System.out.println("Checking for clash of any course with "+a.getName());
			for(int j=i+1; j<L.size(); j++){
				Course b = L.get(j);
				if(a.clashCheck(b)){
					System.out.println(a.getName()+" & "+b.getName() +" clash.");
				}

			}
		}
	}
}