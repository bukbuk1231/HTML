import java.util.Scanner;
public class stringComparison
{
   public static void main(Stirng[] args)
   {
      Scanner kb = new Scanner(System.in);
      String s1, s2, s3, s4;
      System.out.print("enter String1: ");
      s1 = kb.nextLine();
      kb.nextLine();
      System.out.print("enter String2: ");
      s2 = kb.nextLine();
      kb.nextLine();
      System.out.print("enter String3: ");
      s3 = kb.nextLine();

      System.out.printf("Please enter three strings:\n%s\n%s\n%s\n", s1,s2,s3);
      System.out.println("The inputs in sorted order are:");

      if (s1.compareTo(s2) > 0 && s2.compareTo(s3) > 0)
      System.out.printf("%s\n%s\n%s", s3,s2,s1);
      if (s1.compareTo(s2) < 0 && s2.compareTo(s3) < 0)
      System.out.printf("%s\n%s\n%s", s1,s2,s3);
      if (s1.compareTo(s3) < 0 && s3.compareTo(s2) > 0)
      System.out.printf("%s\n%s\n%s", s1,s3,s2);
      if (s3.compareTo(s1) < 0 && s1.compareTo(s2) < 0)
      System.out.printf("%s\n%s\n%s", s3,s1,s2);
      if (s2.compareTo(s1) < 0 && s1.compareTo(s3) < 0)
      System.out.printf("%s\n%s\n%s", s2,s1,s3);
      if (s2.compareTo(s3) < 0 && s3.compareTo(s1) < 0)
      System.out.printf("%s\n%s\n%s", s2,s3,s1);
  
}
}
      
      
