//Junda Lou
//CS140, section 01
//Project 6 - Driver License Exam
//12.3.2015

import java.util.Scanner;
public class DriverTest
{
   public static void main(String[] args)
   {
     Scanner kb = new Scanner(System.in);
     final int testNumber = 20;
     char[] corAnswer = {'a','a','a','a','a','b','b','b','b','b','c','c','c','c','c','d','d','d','d','d'};
     String[] answer = new String[testNumber];
     char[] ch = new char[testNumber];
     for (int i=0; i<testNumber; i++)
     {
        System.out.print("Question" + (i+1) +": ");
        answer[i] = kb.nextLine().toLowerCase();
        ch[i] = answer[i].charAt(0);
     }
     
     int numC = gradeExam(corAnswer, ch);
     int numInc = testNumber - numC;
     int[] missed = new int[numInc];
     missed = makeMissedArray(corAnswer, ch, numInc);
     
     System.out.println("** Correct answers: " + numC);
     System.out.println("** Incorrect answers: " + numInc);
     if (numInc > 5)
     System.out.println("** You failed the exam.");
     else
     System.out.println("** You passed the exam.");
     System.out.println("You missed the following questions: ");
     for (int i=0; i<numInc; i++)
     System.out.print((missed[i]+1) + " ");

   }


   public static int gradeExam(char[] correct, char[] student)
   {
     int numC = 0;
     for (int i=0; i<20; i++)
     {
        if (correct[i] == student[i])
        numC++;
     } 
     return numC;
   }
     
   public static int[] makeMissedArray(char[] correct, char[] student, int numIncorrect)
   {
     int[] missed = new int[numIncorrect];
     int j=0;
     for (int i=0; i<20; i++)
     {
        if (correct[i] != student[i])
        {
           missed[j] = i;
           j++;
        }
     }
     return missed;
   }
}
