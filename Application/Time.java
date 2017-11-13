import java.lang.*;
import java.io.*;
import java.util.*;
public class Time{
	public static void main(String[] args)
	{
		try{
			List<Course> L=new ArrayList<Course>();
			FileInputStream F=new FileInputStream("db_Courses.txt");
			ObjectInputStream O=new ObjectInputStream(F);
			L=(List<Course>)O.readObject();
			Student S=new Student("lsd","69");
			S.AddMandatory(L.get(0));
			S.AddMandatory(L.get(1));
			S.AddMandatory(L.get(2));
			S.AddMandatory(L.get(12));
			S.AddMandatory(L.get(6));
			List<Course> D=S.getCourses();
			
			String[][] Table=new String[5][30];
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<30;j++)
					Table[i][j]="      ";
			}
			for(int i=0;i<D.size();i++)
			{
				LinkedList[] LOL=D.get(i).getSchedule();
				for(int j=0;j<5;j++)
				{
					LinkedList Temp=LOL[j];
					for(int k=0;k<Temp.size();k++)
					{
						String X1=((Slot)Temp.get(k)).getTime();
						String[] X2=X1.trim().split("-");
						String[] X3=X2[0].trim().split(":");
						String[] X4=X2[1].trim().split(":");
						if(Integer.parseInt(X3[0])>=8)
						{
							if(X3[1].equals("00"))
							{
								Table[j][Integer.parseInt(X3[0])*2-16]=D.get(i).getCode();
								int TT=Integer.parseInt(X4[0]);
								if(TT>=8)
								{
									int XX=Integer.parseInt(X3[0])*2-16;
									if(X4[1].equals("00"))
									{
										TT=TT*2-16;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
									else if(X4[1].equals("30"))
									{
										TT=TT*2-16+1;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
								}
								else
								{
									int XX=Integer.parseInt(X3[0])*2-16;
									if(X4[1].equals("00"))
									{
										TT=(TT-1)*2+10;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
									else if(X4[1].equals("30"))
									{
										TT=(TT-1)*2+10+1;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}

								}

							}
							if(X3[1].equals("30"))
							{
								Table[j][Integer.parseInt(X3[0])*2-16+1]=D.get(i).getCode();
								int TT=Integer.parseInt(X4[0]);
								if(TT>=8)
								{
									int XX=Integer.parseInt(X3[0])*2-16+1;
									if(X4[1].equals("00"))
									{
										TT=TT*2-16;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
									else if(X4[1].equals("30"))
									{
										TT=TT*2-16+1;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
								}
								else
								{
									int XX=Integer.parseInt(X3[0])*2-16+1;
									if(X4[1].equals("00"))
									{
										TT=(TT-1)*2+10;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
									else if(X4[1].equals("30"))
									{
										TT=(TT-1)*2+10+1;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}

								}
							}
						}
						else if(Integer.parseInt(X3[0])<8)
						{
							if(X3[1].equals("00"))
							{
								Table[j][(Integer.parseInt(X3[0])-1)*2+10]=D.get(i).getCode();
								int TT=Integer.parseInt(X4[0]);
								if(TT>=8)
								{
									int XX=(Integer.parseInt(X3[0])-1)*2+10;
									if(X4[1].equals("00"))
									{
										TT=TT*2-16;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
									else if(X4[1].equals("30"))
									{
										TT=TT*2-16+1;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
								}
								else
								{
									int XX=(Integer.parseInt(X3[0])-1)*2+10;
									if(X4[1].equals("00"))
									{
										TT=(TT-1)*2+10;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
									else if(X4[1].equals("30"))
									{
										TT=(TT-1)*2+10+1;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}

								}
							}
							if(X3[1].equals("30"))
							{
								Table[j][(Integer.parseInt(X3[0])-1)*2+10+1]=D.get(i).getCode();
								int TT=Integer.parseInt(X4[0]);
								if(TT>=8)
								{
									int XX=(Integer.parseInt(X3[0])-1)*2+10+1;
									if(X4[1].equals("00"))
									{
										TT=TT*2-16;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
									else if(X4[1].equals("30"))
									{
										TT=TT*2-16+1;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
								}
								else
								{
									int XX=(Integer.parseInt(X3[0])-1)*2+10+1;
									if(X4[1].equals("00"))
									{
										TT=(TT-1)*2+10;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}
									else if(X4[1].equals("30"))
									{
										TT=(TT-1)*2+10+1;
										for(int l=XX+1;l<TT;l++)
										{
											Table[j][l]=D.get(i).getCode();
										}
									}

								}
							}
						}
					}
				}
			}
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<20;j++)
					System.out.print(Table[i][j]+" ");
				System.out.println();
			}
		}catch(Exception E){
			E.printStackTrace();
		}

	}
}