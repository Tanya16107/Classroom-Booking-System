import java.util.*;
import java.io.*;

public class Datime{
	private String Date;
	private String Time;
	public Datime(String d,String t)
	{
		Date=d;
		Time=t;
	}
	public int retDay()
	{
		String S[]=Date.trim().split("/");
		int X=Integer.parseInt(S[0]);
		String D="";
		if(S[1].equals("8"))
		{
			X=(X)%7;
		}
		if(S[1].equals("9"))
		{
			X=(X+31)%7;
		}
		if(S[1].equals("10"))
		{
			X=(X+61)%7;
		}
		if(S[1].equals("11"))
		{
			X=(X+92)%7;
		}
		/*if(X==0)
			D="Monday";
		if(X==1)
			D="Tuesday";
		if(X==2)
			D="Wednesday";
		if(X==3)
			D="Thursday";
		if(X==4)
			D="Friday";
		if(X==5)
			D="Saturday";
		if(X==6)
			D="Sunday";*/
		return X;
	}
	public int retWeek()
	{
		String S[]=Date.trim().split("/");
		int X=Integer.parseInt(S[0]);
		String D="";
		if(S[1].equals("8"))
		{
			X=(X)/7;
		}
		if(S[1].equals("9"))
		{
			X=(X+31)/7;
		}
		if(S[1].equals("10"))
		{
			X=(X+61)/7;
		}
		if(S[1].equals("11"))
		{
			X=(X+92)/7;
		}
		return X+1;

	}
	public String retTime()
	{
		return this.Time;
	}
	public static void main(String[] args)
	{
		Datime W=new Datime("1/8/17","8:30-9:30");
		System.out.print(W.retDay()+" "+W.retWeek()+" "+W.retTime());
	}
}