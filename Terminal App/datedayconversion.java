import java.util.*;
import java.io.*;


class App{
	public static void main(String[] args) {
		int dateNumber = 0;
		int monthCode = 0;
		int month = 0;
		int year = 0;
		int yearCode = 0;
		int leapYearCode = 0;

		Scanner sc = new Scanner(System.in);

		String in = sc.next();

		int i = 0;
		int c = 0;
		int j = 0;

		while(c<2){
			if(in.charAt(i)=='/'){
				if(c==0){
					dateNumber = Integer.valueOf(in.substring(0,i));
					j = i+1;

				}
				else if(c==1){
				    month = Integer.valueOf(in.substring(j,i));
				}
				c++;
			}
			i++;
		}

		year = Integer.valueOf(in.substring(i));
		yearCode = Integer.valueOf(in.substring(i+2));


	


		yearCode = yearCode + (yearCode/4);
		yearCode%=7;

		month--;

		int[] codeForMonths = {0,3,3,6,1,4,6,2,5,0,3,5};

		monthCode = codeForMonths[month];

		if(year%400==0 || (year%100!=0 && year%4==0)){
			leapYearCode = 1;
		}




		int day = (yearCode+monthCode+6+dateNumber-leapYearCode)%7;


		String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		System.out.println(daysOfWeek[day]);

		
	}
}