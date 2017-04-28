public class FormattedOutput
   {
   public static void main(String[] args)
   {
       String name = "Junda Lou";
       String major = "Computer Science";
       String list = "CS\'130\', \'140\', and MAT \'115\'";      

       System.out.printf("Student:      \"%s\"\n", name);
       System.out.printf("Major:        \\%s\\\n", major);
       System.out.printf("Study List:%32s\n", list);
}  
}
