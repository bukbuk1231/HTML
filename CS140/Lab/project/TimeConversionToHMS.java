//Junda Lou
//CS140, section 01
//project 2 - Time Conversion
//10.11.2015

import java.util.Scanner;
public class TimeConversionToHMS
{
	public static void main(String[] args)
	{
		int total, hours, minutes, seconds;
		Scanner keyboard = new Scanner(System.in);

		System.out.print("enter number of total second:");
		total = keyboard.nextInt();

		hours = total/3600;
		minutes = (total - hours * 3600) / 60;
		seconds = total - hours * 3600 - minutes * 60;
System.out.println("enter total seconds: " + total);
System.out.println(total + " seconds is equivalent to " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");

	}
}
