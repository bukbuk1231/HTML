//Junda Lou
//CS140, section 01
//Project 5 - Display Diamonds program
//11.19.2015

import java.util.Scanner;
public class DisplayDiamond
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("enter diamond size (\"short\", \"average\", or \"tall\"): ");
      String a = kb.nextLine();
      int size;

      do
      {
      size =  checkSize(a);
      if (size != 6 && size != 12 && size !=24)
      {
      System.out.print("enter diamond size (\"short\", \"average\", or \"tall\"): ");
      a = kb.nextLine();
      }
      }   while (size != 6 && size != 12 && size != 24);
      
      System.out.print("enter pattern character: ");
      String patCh = kb.nextLine();
      char ch = patCh.charAt(0);
      displayDiamond(size, ch);
      System.out.println();
      displayHollowDiamond(size, ch);
   }
   public static int checkSize(String b)
   {
      int result1;
      String c = b.toLowerCase();
      if (c.equals("short"))
      {
      result1 = 6;
      return result1;
      }
      else if (c.equals("average"))
      {
      result1 = 12;
      return result1;
      }
      else if (c.equals("tall"))
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
   public static void displayDiamond(int size, char ch)
  // {
  // for (int i = 1-size/2;i<size/2;i++)
  // {
  // for (int j=0;j<Math.abs(i);j++)
  // System.out.print(" ");
  // for (int k=1; k<(size-Math.abs(2*i));k++)
  // System.out.print(ch);
  // System.out.println();
  // }

  // Ignore these. These are for real diamonds, not for this "two triangles stuff"...

   {
     int i, j, k, l=size/2;
     for (i=0;i<l;i++)
     {
     for (j=0;j<l-i-1;j++)
     System.out.print(" ");
     for (j=0;j<2*i+1;j++)
     System.out.print(ch);
     System.out.println();
     }
     
     for (i=0;i<l;i++)
     {
     for (j=0;j<i;j++)
     System.out.print(" ");
     for (k=0;k<2*(l-i)-1;k++)
     System.out.print(ch);
     System.out.println();
     }
   }

   public static void displayHollowDiamond(int size, char ch)
   {
   int i,j,k,l=size/2;
   for (i=1; i<=l; i++)
   {
   for (j=1; j<=l-i; j++)
   System.out.print(" ");
   if (i==1)
   {
   System.out.print(ch);
   System.out.println();
   }
   else
   {
   System.out.print(ch);
   for (k=1; k<=2*(i-1)-1; k++)
   System.out.print(" ");
   System.out.print(ch);
   System.out.println();
   }
   }

   for (i=l; i>=1; i--)
   {
   for (j=1; j<=l-i; j++)
   System.out.print(" ");
   if (i==1)
   {
   System.out.print(ch);
   System.out.println();
   }
   else
   {
   System.out.print(ch);
   for (k=1; k<=2*(i-1)-1; k++)
   System.out.print(" ");
   System.out.print(ch);
   System.out.println();
   }
   }


   } 

//This is so freaking BRIANSTORM...

}
       
       
      
