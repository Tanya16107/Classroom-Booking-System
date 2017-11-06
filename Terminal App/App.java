import java.util.*;
import java.io.*;

class App{
	static void mainMenu(){
		System.out.println("1. Create User:\n1. Student\n2. Faculty\n3. Admin\n");
		System.out.println("2. Login:\n1. Student\n2. Faculty\n3. Admin");
	}

	static void studentMenu(){
		System.out.println("1. Logout\n2. Search for Course\n3. View Timetable\n4. Check Availability of Room\n5. Request Booking\n6. View My Bookings");
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

 	static LinkedList<Student> deserializeStudentList() throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("studentList.txt"));
			return (LinkedList<Student>) in.readObject();
		}
		finally{
			in.close();
		}
	}

	static LinkedList<Faculty> deserializeFacultyList() throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("facultyList.txt"));
			return (LinkedList<Faculty>) in.readObject();
		}
		finally{
			in.close();
		}
	}

	static LinkedList<Admin> deserializeAdminList() throws IOException, ClassNotFoundException {
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
		int e;

		String roomName, date, fromTime, toTime;

		while(true){
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
							studentMenu();
							 e = sc.nextInt();
							switch(e){
								case 1:{

								}
								break;
								case 2:{

								}
								break;
								case 3:{
									System.out.println("Enter roomName, date, fromTime, toTime");
									roomName = sc.next();
									date = sc.next();
									fromTime = sc.next();
									toTime = sc.next();


								}
								break;
								case 4:{

								}
								break;
								case 5:{

								}
								break;
								case 6:{

								}
								break;
							}

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
}
