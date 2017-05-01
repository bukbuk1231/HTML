//Junda Lou
//CS140, section 01
//Project 4 - Slot Machine Simulation
//11.9.2015

import java.util.*;
public class SlotMachineSimulation
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      Random rand = new Random();
      final int max = 6;
      String s1 = "Cherries";
      String s2 = "Oranges";
      String s3 = "Plums";
      String s4 = "Bells";
      String s5 = "Melons";
      String s6 = "Bars";
      String p1, p2, p3, again;
      double win, bt, wt;
      bt = 0;
      win = 0;
      wt = 0;
      char ch;

      System.out.println("Welcome to the Slot Machine Simulation.");
      System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
      
      do
      {
      System.out.println();
      System.out.print("Enter the amount you would like to bet: $");
      double bet = kb.nextDouble();
      System.out.println();
      int a1 = rand.nextInt(max);
      int a2 = rand.nextInt(max);
      int a3 = rand.nextInt(max);
      
      //Seems a little bit awkward here. Is there any way to make it easier?

      if (a1 == 0)
      p1 = s1;
      else if (a1 == 1)
      p1 = s2;
      else if (a1 == 2)
      p1 = s3;
      else if (a1 == 3)
      p1 = s4;
      else if (a1 == 4)
      p1 = s5;
      else
      p1 = s6;
      
      if (a2 == 0)
      p2 = s1;
      else if (a2 == 1)
      p2 = s2;
      else if (a2 == 2)
      p2 = s3;
      else if (a2 == 3)
      p2 = s4;
      else if (a2 == 4)
      p2 = s5;
      else
      p2 = s6;

      if (a3 == 0)
      p3 = s1;
      else if (a3 == 1)
      p3 = s2;
      else if (a3 == 2)
      p3 = s3;
      else if (a3 == 3)
      p3 = s4;
      else if (a3 == 4)
      p3 = s5;
      else
      p3 = s6;

      System.out.printf("- %s -- %s -- %s -\n", p1, p2, p3);
      System.out.println();
  
      if (p1 == p2 || p1 == p3 || p2 == p3)
      {  
      if (p1 == p2 && p1 == p3)
      {
      win = 3 * bet;
      System.out.println("Wow! All three match!");
      System.out.println("That triples your bet!");
      System.out.printf("You win $%,.2f\n", win);
      System.out.println();
      }
      else 
      {      
      win = 2 * bet;
      System.out.println("Great! Two match.");
      System.out.println("That doubles your bet!");
      System.out.printf("You win &%,.2f\n", win);
      System.out.println();
      }
      }
      else
      {
      System.out.println("Sorry, None match...");
      System.out.println("You win $0.00");
      System.out.println();
      }
      
      bt = bt + bet;
      wt = wt + win;

      kb.nextLine();
      System.out.println("Would you like to play again?");
      System.out.print("Enter Y for yes or N for no: ");
      again = kb.nextLine();
      ch = again.charAt(0);
      while (ch != 'Y' && ch != 'y' && ch != 'N' && ch != 'n')
      {
      System.out.print("Invalid value, input again: ");
      again = kb.nextLine();
      ch = again.charAt(0);
      }
      } while (ch == 'y' || ch == 'Y');

      System.out.println();
      System.out.printf("You bet a total of $%,.2f\n", bt);
      System.out.printf("You won a total of $%,.2f\n", wt);
//GOOD LUCK!!!!
   }
}
       
      
