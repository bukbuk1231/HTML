import java.util.Scanner;
public class leapYear
{
   public static void main(String[] args)
   {
	Scanner keyboard = new Scanner(System.in);
	int year;
	System.out.print("enter year: ");
	year = keyboard.nextInt();
	if (year % 4 == 0 && year % 100 !=0)
		System.out.println("It is a leap year");
	else if (year % 400 == 0)
		System.out.println("It is a leap year");
	else
		System.out.println("It is not a leap year");
   }
}
