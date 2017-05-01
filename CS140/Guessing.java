import java.util.*;

public class Guessing
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      Random rd = new Random();
      int secret = rd.nextInt(100) + 1;
      System.out.print("guess what number I have: ");
      int userNum = kb.nextInt();
      int num = 1;
      while (userNum != secret)
      {
         if (userNum > secret)
         System.out.print("too high, try again: ");
         else
         System.out.print("too low, try again: ");
         userNum = kb.nextInt();
         num++;
      }
      System.out.println("You are right");
      System.out.println("You guessed " + num + " times");
   }
}
