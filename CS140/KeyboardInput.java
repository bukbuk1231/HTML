import java.util.Scanner;
public class KeyboardInput
{
   public static void main(String[] agrs)
   {
       Scanner kb = new Scanner(System.in);
       String name, companyName;
       int age;
       double annualSalary;
       System.out.print("Input your name: ");
       name = kb.nextLine();
       System.out.print("Input your age: ");
       age = kb.nextInt();
       System.out.print("Input your Company Name: ");
       kb.nextLine();
       companyName = kb.nextLine();
       System.out.print("Input your Annual Salary: ");
       annualSalary = kb.nextDouble();

       System.out.printf("My name is %s, my age is %d and\nI hope to work for %s and earn $%,.2f per year.", name, age, companyName, annualSalary);
}
}
