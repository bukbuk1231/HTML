//Junda Lou
//CS140, section 01
//Project 3 - Bill Statement
//10.17.2015

import java.util.Scanner;

public class Bill
{
   public static void main(String[] argrs)
   {
      Scanner kb = new Scanner(System.in);
      int quan1, quan2, quan3;
      double price1, price2, price3;
      String item1, item2, item3;
      final double TAX = 0.0875;
      System.out.print("enter the name of item 1: ");
      item1 = kb.nextLine();
      System.out.print("enter the quantity of item 1: ");
      quan1 = kb.nextInt();
      if (quan1 < 0 || quan1 > 1000)
      {
         System.out.print("Invalid quantity, please enter quantity between 0 and 1,000");
         System.exit(0);
      }
      System.out.print("enter the price of item 1: ");
      price1 = kb.nextDouble();
      if (price1 < 0.0 || price1 > 10000.0)
      {
         System.out.println("Invalid price, please enter price between 0.0 and 10,000.0");
         System.exit(0);
      }
            
      System.out.print("enter the name of item 2: ");
      kb.nextLine();
      item2 = kb.nextLine();
      System.out.print("enter the quantity of item 2: ");
      quan2 = kb.nextInt();
      if (quan2 < 0 || quan2 > 1000)
      {
         System.out.print("Invalid quantity, please enter quantity between 0 and 1,000");
         System.exit(0);
      }
      System.out.print("enter the price of item 2: ");
      price2 = kb.nextDouble();
      if (price2 < 0.0 || price2 > 10000.0)
      {
         System.out.println("Invalid price, please enter price 3between 0.0 and 10,000.0");
         System.exit(0);
      }

      System.out.print("enter the name of item 3: ");
      kb.nextLine();
      item3 = kb.nextLine();
      System.out.print("enter the quantity of item 3: ");
      quan3 = kb.nextInt();
      if (quan3 < 0 || quan3 > 1000)
      {
         System.out.print("Invalid quantity, please enter quantity between 0 and 1,000");
         System.exit(0);
      }
      System.out.print("enter the price of item 3: ");
      price3 = kb.nextDouble();
      if (price3 < 0.0 || price3 > 10000.0)
      {
         System.out.println("Invalid price, please enter price between 0.0 and 10,000.0");
         System.exit(0);
      }
      double total1 = price1 * quan1;
      double total2 = price2 * quan2;
      double total3 = price3 * quan3;
      double subTotal = total1 + total2 + total3;
      double saleTax = subTotal * 0.0875;
      double totalAll = subTotal + saleTax;  

      System.out.println("Input name of item 1: " + item1);
      System.out.println("Input quantity of item 1: " + quan1);
      System.out.println("Input price of item 1: " + price1);
      System.out.println();
      System.out.println("Input name of item 2: " + item2);
      System.out.println("Input quantity of item 2: " + quan2);
      System.out.println("Input price of item 2: " + price2);
      System.out.println();
      System.out.println("Input name of item 3: " + item3);
      System.out.println("Input quantity of item 3: " + quan3);
      System.out.println("Input price of item 3: " + price3);
      System.out.println();
      System.out.println("Your bill:");
      System.out.println();
      System.out.println("Item                            Quantity     Price          Total");
      System.out.println("----                            --------     -----          -----");
      System.out.printf("%-30s %9d %9.2f %,14.2f\n",item1,quan1,price1,total1);
      System.out.printf("%-30s %9d %9.2f %,14.2f\n",item2,quan2,price2,total2);
      System.out.printf("%-30s %9d %9.2f %,14.2f\n",item3,quan3,price3,total3);
      System.out.println();
      System.out.printf("SubTotal %,56.2f\n", subTotal);
      System.out.printf("8.75%% sales tax %,49.2f\n", saleTax);
      System.out.printf("Total %,59.2f\n",totalAll);
   }
}
