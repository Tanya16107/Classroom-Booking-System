import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.*;



public class csvtoCourse {

	static void serialize(List<Course> db_Courses) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("db_Courses.txt"));
			out.writeObject(db_Courses);
		}

		finally{
			out.close();
		}
	}

	static int dayNum(String day){
		int out = -1;

		switch(day){
			case "Monday": out = 0; break;
			case "Tuesday": out = 1; break;
			case "Wednesday": out = 2; break;
			case "Thursday": out = 3; break;
			case "Friday": out = 4; break;
		}

		return out;
	}


	public static void main(String[] args) throws IOException{

		List<Course> db_Courses = new ArrayList<Course>();
		try {
			
			CsvReader products = new CsvReader("project.csv");
		
			products.readHeaders();

			while (products.readRecord())
			{
				String b = products.get("Mandatory/Elective");
				String a = products.get("Course Name");
				String c = products.get("Course Code");
				String d = products.get("Instructor");
				int e = Integer.valueOf(products.get("Credits"));
				String m = products.get("Pre-conditions");
				String n = products.get("Post-conditions");
				Course course = new Course(a, c, b, d, e, m, n);
				try{
				String[] f = products.get("Monday Time$Venue").split("\\$");
				course.buildSchedule(0, new Slot("Lecture", f[1], f[0]));
				}
				catch(ArrayIndexOutOfBoundsException exception){
				}

				try{
				String[] g = products.get("Tuesday Time$Venue").split("\\$");
				course.buildSchedule(1, new Slot("Lecture", g[1], g[0]));
				}
				catch(ArrayIndexOutOfBoundsException exception){
				}

				try{
				String[] h = products.get("Wednesday Time$Venue").split("\\$");
				course.buildSchedule(2, new Slot("Lecture", h[1], h[0]));
				}
				catch(ArrayIndexOutOfBoundsException exception){
				}

				try{
				String[] i = products.get("Thursday Time$Venue").split("\\$");
				course.buildSchedule(3, new Slot("Lecture", i[1], i[0]));
				}
				catch(ArrayIndexOutOfBoundsException exception){
				}

				try{
				String[] j = products.get("Friday Time$Venue").split("\\$");
				course.buildSchedule(4, new Slot("Lecture", j[1], j[0]));
				}
				catch(ArrayIndexOutOfBoundsException exception){
				}

				try{
				String[] k = products.get("Tut Day$Time$Venue").split(" :");
				
				for(int i=0; i<k.length; i++){
					try{
						String[] ar = k[i].split("\\$");

						if(ar[2].indexOf(';')==-1){
							course.buildSchedule(dayNum(ar[0].trim()), new Slot("Tutorial", ar[2], ar[1]));
						}
						else{
							String[] _ar = ar[2].split(";");
							for(int j=0; j<_ar.length; j++){
								course.buildSchedule(dayNum(ar[0].trim()), new Slot("Tutorial", _ar[j], ar[1]));
							}

						}
					}
					catch(ArrayIndexOutOfBoundsException exception){}
				}
			}
			catch(ArrayIndexOutOfBoundsException exception){}

			try{
				String[] l = products.get("Lab Day$Time$Venue").split("\\$");
				String dd = l[0].replaceAll(":","").trim();
				if(l[2].indexOf(';')==-1){
							course.buildSchedule(dayNum(dd), new Slot("Lab", l[2], l[1]));
						}
						else{
							String[] _ar = l[2].split(";");
							for(int j=0; j<_ar.length; j++){
								course.buildSchedule(dayNum(dd), new Slot("Lab", _ar[j], l[1]));
							}

						}
			}
			catch(ArrayIndexOutOfBoundsException exception){}



				db_Courses.add(course);
				
		
				//System.out.println(ii +" "+b+" "+c+" "+d+" "+e+" credits");
				//System.out.println(a);
				/*
				System.out.println("Monday Time & Venue-> " +f);
				System.out.println("Tuesday Time & Venue-> " +g);
				System.out.println("Wednesday Time & Venue-> " +h);
				System.out.println("Thursday Time & Venue-> " +i);
				System.out.println("Friday Time & Venue-> " +j);
				*/

				//System.out.println("Tut Day$Time$Venue-> " +k);

				//System.out.println("Lab Day$Time$Venue-> " +l);

				//System.out.println("Pre-conditions\n" +m);
				//System.out.println("Post-conditions\n" +n);
				
				//System.out.println();
				
				
			}
	
			products.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		serialize(db_Courses);
		/*for check
		for(int i=0; i<db_Courses.size(); i++){
			Course c = db_Courses.get(i);
			System.out.println(c);
			c.printSchedule();
		}
		*/
		
		
	}

}
