//Junda Lou
//CS140, section 01
//Project 5 - Display Diamonds program
//11.19.2015

import java.util.Scanner;
public class HollowDiamond
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("enter diamond size: ");
      String a = kb.nextLine();

      do
      {
      int size =  checkSize(a);
      if (size != 6 && size != 12 && size !=24)
      System.out.print("enter diamond size: ");
      size = kb.nextLine();
      }   while (size != 6 && size != 12 && size != 24)
      
      System.out.print("enter pattern character: ");
      String patCh = kb.nextLine();
      char ch = patCh.charAt(0);
      displayDiamond(size, ch);
      displayHollowDiamond(size, ch);
   }
   public static int checkSize(String b)
   {
      int result1;
      String c = b.toLowerCase();
      if (c.equals("short")
      {
      result1 = 6;
      return result1;
      }
      else if (c.equals("average")
      {
      result1 = 12;
      return result1;
      }
      else if (c.equals("tall")
      {
      result1 = 24;
      return result1;
      }
      else
      {
      result1 = -1;
      return result1;
      }
   }
