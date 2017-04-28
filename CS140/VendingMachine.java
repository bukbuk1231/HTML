import java.util.Scanner;
public class VendingMachine
{
   public static void main(String[] args)
   {  
      Scanner kb = new Scanner(System.in); 
      int money;
      System.out.print("Eneter price of item\n(from 25 cents to a dollar, in 5-cent increments): ");
      money = kb.nextInt();
      if (money < 25 || money > 100)
      {
      System.out.println("Invalid Amount. Please enter a number between 25 and 100.");
      System.exit(0);
      }
      int quarter, dime, nickel;
      quarter = (100 - money) / 25;
      dime = (100 - money - 25 * quarter) / 10;
      nickel = (100 - money - 25 * quarter - 10 * dime) / 5;
      System.out.printf("You bought an item for %s cents and gave me a dollar,\n", money);
      System.out.println("So your change is");
      System.out.printf("%d quarters,\n%d dimes, and\n%d nickels.", quarter, dime, nickel);
}
}
