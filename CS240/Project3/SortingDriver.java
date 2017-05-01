import java.util.Scanner;
///////////////////////////////////////////////////////
public class SortingDriver
{
    //------------------------------------------------------------
    public static void main(String[] args)
    {
	int entry, choice, i;
	Scanner kb = new Scanner(System.in);
	System.out.print("enter the length of array: ");
	int arraylength = kb.nextInt();
	@SuppressWarnings("unchecked")
	Integer[] array = new Integer[arraylength];
	@SuppressWarnings("unchecked")
	DoublyLinkedListInsertionSort<Integer> list = new DoublyLinkedListInsertionSort();
	for(i = 0; i < arraylength; i++)
	{
	    System.out.print("enter the #" + i + " entry: "); 
	    entry = kb.nextInt();
	    array[i] = entry;
	    list.add(entry);
	}
	System.out.println("Select the Sort Method:");
	System.out.print("1)Merge Sort\n2)Quick Sort\nYour Choice: ");   
	choice = kb.nextInt();
	if(choice == 1)	    
	    ArrayMergeSort.mergeSort(array, 0, array.length - 1);
	else
	    ArrayQuickSort.quickSort(array, 0, array.length - 1);
	System.out.println("Your sorting result is:");
	for(i = 0; i < array.length; i++)
	    System.out.println(array[i]);       	
	System.out.println("Your insertion sort result is:");
	list.insertionSort();
	list.printOut();	
    }
    //----------------------------------------------------------
}

/////////////////////////////////////////////////////