public class calendar
{
    public static void main(String[] args)
    {
	int date[] = new int[31];
	for (int i = 0; i < 31; i++)
	    date[i] = i + 1;
	System.out.println("         Jan                     Feb                     Mar");
	for (int j = 0; j < 3 ; j++)
	System.out.print("Mo Tu We Th Fr Sa Su    ");
        System.out.println();
	
    }
}