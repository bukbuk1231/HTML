/////////////////////////////////////////////////
public class ArrayQuickSort
{
    //-------------------------------------------------------------
    public static <T extends Comparable<? super T>> void quickSort(T[] array, int first, int last)
    {
	T tmp;
	int pivot;
	// when sub-array reaches a size of 2 or smaller, simply do a swap if needed
	if(last - first + 1 <= 2)
	{
	    if(array[first].compareTo(array[last]) == 1)
	    {
		tmp = array[first];
		array[first] = array[last];
		array[last] = tmp;
	    }
	}
	else
	{
	    // choose pivot
	    pivot = partition(array, first, last);
	    // skip if pivot < first, otherwise will cause IndexOutOfBound
	    if(pivot > first)
		quickSort(array, first, pivot - 1);
	    // skip if pivot > first, otherwise will cause IndexOutOfBound
	    if(pivot < last)
		quickSort(array, pivot + 1, last);
	}
    }

    //-------------------------------------------------------------
    
    public static <T extends Comparable<? super T>> int partition(T[] array, int left, int right)
    {
	int pivot = left;
	int index = right;
	T temp;     // array content swap intermedium T
	int tmp;    // index swap intermedium int
	// done if pivot = index
	while(pivot != index)
	{
	    // check it again because of the continues in the loop
	    if(pivot == index)
		break;
	    // index++ if pivot < index
	    if(pivot < index)
	    {
		if(array[pivot].compareTo(array[index]) == 1)
		    {
			temp = array[pivot];
			array[pivot] = array[index];
			array[index] = temp;
			tmp = pivot;
			pivot = index;
			index = tmp;
			index++;
			continue;
		    }	
		index--;
		continue;
	    }	   
	    // index-- if pivot > index
	    else if(pivot > index)
	    {
		if(array[pivot].compareTo(array[index]) == -1)
		    {
			temp = array[pivot];
			array[pivot] = array[index];
			array[index] = temp;
			tmp = pivot;
			pivot = index;
			index = tmp;
			index--;
			continue;
		    }
		index++;
		continue;
	    }			   
	}
	return pivot;
    }
    //-------------------------------------------------------------

}
        
///////////////////////////////////////////////