public class test
{
    public static void main(String[] args)
    {
	/*
	int b = 1;
	DoublyLinkedInsertionSort<Integer> a = new DoublyLinkedInsertionSort();
	a.add(0);
	a.add(b);
	a.add(b+2);
	a.InsertionSort();

	Integer[] array = a.toArray();	
	for(int i = 0; i < array.length; i++)
	    System.out.println(array[i]);
	

	
	Integer[] a = new Integer[8];
	a[0] = 2;
       	a[1] = 6;	
       	a[2] = 3;	
	a[3] = 5;
	a[4] = 4;
	a[5] = 8;
	a[6] = 20;
	a[7] = 9;
	
	//ArrayQuickSort.quickSort(a, 0, 7);
	//ArrayMergeSort.mergeSort(a, 0, 7);
	for(int i = 0; i < 8; i++)
	    System.out.println(a[i]);
	*/
	
	@SuppressWarnings("unchecked")
	DoublyLinkedList<Integer> list = new DoublyLinkedList();
	list.add(2);
	list.add(7);
	list.add(3);
	list.add(8);
	list.insertionSort();
	list.printOut();
	
	



	    
    }
}