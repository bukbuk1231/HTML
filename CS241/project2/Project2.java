import java.util.*;

public class Project2 
{
    public static void main(String[] args) 
    {
	Scanner kb = new Scanner(System.in);
	int userChoice = 3;
	do
	{
	    System.out.println("====================================================================");
	    System.out.println("Please select how to test the program:");
	    System.out.println("(1) 20 sets of 100 randomly generated integers");
	    System.out.println("(2) Fixed integer values 1-100");
	    System.out.println("(3) Quit");
	    System.out.print("Enter choice: ");
	    userChoice = kb.nextInt();
	    if(userChoice == 1)
		randomInt();
	    else if(userChoice == 2)
		fixedInt();
	} while(userChoice != 3);
    }
    
    public static void randomInt()
    {
	int insertionSwap = 0;
	int optimalSwap = 0;
	int j = 1;
	boolean duplicated = false;    // boolean var to deal with dups
	Random ran = new Random();
	Integer[] entries = new Integer[101];    // get NullPointerException if declear it inside the loop
	for(int i = 0; i < 20; i++)     // for loop to do it 20 times
	{	    
	    while(j < entries.length)
	    {
		entries[j] = ran.nextInt(100) + 1;       // make it between 1 - 100
		for(int m = 1; m < j; m++)        // check from start to current index to see if there are dups
		{
		    if(entries[m] == entries[j])
		    {
			duplicated = true;     // if yes, stop here and deal with it
			break;
		    }
		    else
			duplicated = false;   // if no, reset dup to false
		}
		if(duplicated)     // if dups, do it again, create another random number
		    continue;
		else
		    j++;	// everything OK, go on to the next index
	    }	 			    	 
	    insertionSwap += insertion(entries, false);   // get 2 swaps, false here to control whether to do
	    optimalSwap += optimal(entries, false);     // removals and show the first 10 elements or not since it is only for fixed integers
	}		
	System.out.println("Average swaps for series of insertions: " + insertionSwap / 20);
	System.out.println("Average swaps for optimal method: " + optimalSwap / 20);
		
    }
    
    public static void fixedInt()
    {
	int insertionSwap = 0;
	int optimalSwap = 0;
	Integer[] entries = new Integer[101];
	for(int i = 1; i <= 100; i++)        // fixed integers 1 - 100
	    entries[i] = i;
	insertionSwap += insertion(entries, true);   // true to tell the method it is fixed integers
	System.out.println("Number of swaps: " + insertionSwap);
	System.out.println();
	optimalSwap += optimal(entries, true);
	System.out.println("Number of swaps: " + optimalSwap);
	System.out.println();
    }
    
    public static int insertion(Integer[] entries, boolean fixed)
    {
	ArrayHeap<Integer> heap = new ArrayHeap<Integer>();   // default constructor
	for(int i = 1; i < entries.length; i++)
	    heap.add(entries[i]);               // add entries one by one
	if(fixed)        // do it only when fixed integers 1-100
	{
	    Comparable[] heapArray = heap.getHeap();      // get the heap array
	    System.out.print("Heap built using series of insertions: ");
	    for(int i = 1; i <= 10; i++)
		System.out.print(heapArray[i] + ",");   // print out first 10 elements
	    System.out.println("...");
	    heapArray = remove(heap);       // remove 10 times
	    System.out.print("Heap after 10 removals: ");
	    for(int i = 1; i <= 10; i++)
		System.out.print(heapArray[i] + ",");   // print out first 10 again
	    System.out.println("...");
	}
	return heap.getInsertionSwap();
    }
    
    public static int optimal(Integer[] entries, boolean fixed)
    {
	int reheapSwap = 0;
	ArrayHeap<Integer> heap = new ArrayHeap<Integer>(entries);  // optimal constructor
	reheapSwap = heap.getReheapSwap();
	if(fixed)
	{
	    Comparable[] heapArray = heap.getHeap();
	    System.out.print("Heap built using optimal method: ");
	    for(int i = 1; i <= 10; i++)
		System.out.print(heapArray[i] + ",");  
	    System.out.println("...");
	    heapArray = remove(heap);
	    System.out.print("Heap after 10 removals: ");
	    for(int i = 1; i <= 10; i++)
		System.out.print(heapArray[i] + ",");
	    System.out.println("...");
	}
	return reheapSwap;    // not do the same as insertion() because reheap() happens in remove() as well
    }

    public static Comparable[] remove(ArrayHeap<Integer> heap)
    {
	Integer root = 0;
	for(int i = 0; i < 10; i++)
	    root = heap.removeRoot();   // call removeRoot() in ArrayHeap<T> 10 times
	return heap.getHeap();
    }
}
