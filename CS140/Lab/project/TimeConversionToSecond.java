//Junda Lou
//CS140, section 01
//Project 2 - Time Conversion
//10.11.2015

import java.util.Scanner;
public class TimeConversionToSecond
{
	public static void main(String[] args)
	{
		int hours, minutes, seconds, total;
		Scanner keyboard = new Scanner(System.in);

		System.out.print("enter number of hours:");
		hours = keyboard.nextInt();
		System.out.print("enter number of minutes:");
		minutes = keyboard.nextInt();
		System.out.print("enter number of seconds:");
		seconds = keyboard.nextInt();

		total = hours*3600 + minutes*60 + seconds;

		System.out.println("enter hours:" + hours);
		System.out.println("enter minutes:" + minutes);
		System.out.println("enter seconds:" + seconds);
System.out.println(hours + " hours, " + minutes + " minutes, " + seconds + " seconds is equivalent to " + total + " seconds.");
	}
}

