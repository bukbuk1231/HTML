public class test
{
    public static void main(String[] args)
    {       
	//ArrayHeap<Integer> heap = new ArrayHeap<Integer>();
	Integer[] array = new Integer[101];
	for(int i = 1; i <= 100; i++)
	    array[i] = i;
	ArrayHeap<Integer> heap = new ArrayHeap<Integer>(array);
	Comparable[] result = heap.getHeap();
	for(int i = 0; i < result.length; i++)
	    System.out.println(result[i]);
    }
}