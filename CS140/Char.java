import java.util.Scanner;

public class Char
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("enter a character: ");
//String answer = kb.nextLine();
//char ch = answer.charAt(0);
      char ch = kb.nextLine().charAt(0);
      if ('A' <= ch && ch <='Z')
	System.out.println("It is an uppercase letter");
      else if ('a' <= ch && ch <= 'z')
	System.out.println("It is a lowercase letter");
      else if ('0' <= ch && ch <= '9')
	System.out.println("It is a digit");
      else
	System.out.println("Others");
   }
}
