/////////////////////////////////////////////////
public class ArrayMergeSort
{
    //---------------------------------------------------
    public static <T extends Comparable<? super T>> void mergeSort(T[] array, int first, int last)
    {
	@SuppressWarnings("unchecked")	    
	T[] tempArray = (T[]) new Comparable<?>[array.length];
	// Declare it only once, so seperate it by using two methods
	mergeSortMethod(array, tempArray, first, last);
    }

    //--------------------------------------------------

    public static <T extends Comparable<? super T>> void mergeSortMethod(T[] array, T[] tempArray, int first, int last)    
    {
	int mid = (first + last) / 2;   // initialize
	if(first < last)    // start merging when array has length 1
        {
	    mid = (first + last) / 2;
	    mergeSortMethod(array, tempArray, first, mid);
	    mergeSortMethod(array, tempArray, mid + 1, last);
	}
	merge(array, tempArray, first, mid, last);
    }	

    //-------------------------------------------------------------
    
    public static <T extends Comparable<? super T>> void merge(T[] array, T[] tempArray, int first, int mid, int last)    
    {
	int beginHalf1 = first;
	int endHalf1 = mid;
	int beginHalf2 = mid + 1;
	int endHalf2 = last;
	int index = 0;      
	while((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2))
	{
	    if(array[beginHalf1].compareTo(array[beginHalf2]) < 1)
	    {
		tempArray[index] = array[beginHalf1];
		beginHalf1++;
	    }
	    else
	    {
		tempArray[index] = array[beginHalf2];
		beginHalf2++;
	    }
	    index++;
	}
	// when the left part has completly copied to tempArray
	while((beginHalf1 >= endHalf1) && (beginHalf2 <= endHalf2))
	{
	    tempArray[index] = array[beginHalf2];
	    beginHalf2++;
	    index++;
	}
	// when the right part has completly copied to tempArray
	while((beginHalf2 >= endHalf2) && (beginHalf1 <= endHalf1))
        {   
	    tempArray[index] = array[beginHalf1];
	    beginHalf1++;
	    index++;
	}
	index = 0;   // copy entries to array, so clear the index here
	// copy entries to the range where they were in the original array
	for(int i = first; i <= last; i++)
	{
	    if(tempArray[index] != null)
		array[i] = tempArray[index];
	    index++;
	}
	
	//-------------------------------------------------------------

    }

}

//////////////////////////////////////////////////