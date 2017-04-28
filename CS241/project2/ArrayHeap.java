public class ArrayHeap<T extends Comparable<? super T>> 
{
    private T[] heap;
    private int lastIndex;
    private int insertionSwap = 0;
    private int reheapSwap = 0;
    private static final int DEFAULT_CAPACITY = 101;  // make it easier for the project
    
    
    public ArrayHeap()	
    {
	this(DEFAULT_CAPACITY);	
    }
    
    public ArrayHeap(int capacity)
    {
	@SuppressWarnings("unchecked")
        T[] tmp = (T[]) new Comparable[capacity];
	heap = tmp;	
	lastIndex = 0;
    }
	
    public ArrayHeap(T[] entries)   // optimal constructor here
    {
	this(entries.length);
	for(int i = 1; i < entries.length; i++)   // throw everything into the heap
	    heap[i] = entries[i];
	lastIndex = heap.length - 1;
	for(int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)  // do reheap() on every non-leaf nodes. The last leaf is at lastIndex, so the last non-leaf is at lastIndex / 2
	    reheap(rootIndex);
    }
	
    public void add(T newEntry)
    {
	int newIndex = lastIndex + 1;    // move one to the right to create the new space for newEntry
	int parentIndex = newIndex / 2; 
	while((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
        {   // if parentIndex == 0, get NullPointerException, so get its bool value first
	    heap[newIndex] = heap[parentIndex];
	    newIndex = parentIndex;    // if newEntry is bigger than the parent, move up and repeat the process
	    parentIndex = newIndex / 2;
	    insertionSwap++;   // varible to count swaps
	}
	heap[newIndex] = newEntry;
	lastIndex++;
	ensureCapacity();
    }
	
    public T removeRoot()
    {
	T root = null;
	if(!isEmpty())
	{
	    root = heap[1];
	    heap[1] = heap[lastIndex];
	    lastIndex--;
	    reheap(1);        // re-form the heap
	}
	return root;	
    }
    
    public void reheap(int rootIndex)
    {
	boolean done = false;
	T orphan = heap[rootIndex];  // start from root
	int leftChildIndex = rootIndex * 2;
	while(!done && (leftChildIndex <= lastIndex))
	{
	    int largerChildIndex = leftChildIndex;   // assume left is larger
	    int rightChildIndex = leftChildIndex + 1;
	    if((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
		largerChildIndex = rightChildIndex;   // get the larger child
	    if(orphan.compareTo(heap[largerChildIndex]) < 0)
	    {
		heap[rootIndex] = heap[largerChildIndex];
		rootIndex = largerChildIndex;      // swap root and larger, and repeat the process
		leftChildIndex = rootIndex * 2;
		reheapSwap++;   // variable to count swaps
 	    }
	    else
		done = true;    // end the loop
	}
	heap[rootIndex] = orphan;	// put this last piece onto the root		
    }
    
    public boolean isEmpty()
    {
	return lastIndex == 0;
    }
    
    public void ensureCapacity()   // dynamic array
    {
	if(lastIndex == heap.length)
	{
	    @SuppressWarnings("unchecked")
	    T[] tmp = (T[]) new Comparable[heap.length * 2];
	    for(int i = 0; i < heap.length; i++)
		tmp[i] = heap[i];
	    heap = tmp;	
	}
    }
    
    public int getSize()
    {
	return lastIndex;
    }
    
    public void clear()
    {
	while(lastIndex > -1)
	{
	    heap[lastIndex] = null;
	    lastIndex--;
	}
	lastIndex = 0;
    }
    
    public T getMax()
    {
	T root = null;
	if(!isEmpty())
		root = heap[1];
	return root;
    }
    
    public int getInsertionSwap()
    {
	return insertionSwap;
    }
    
    public int getReheapSwap()
    {
	return reheapSwap;
    }

    public T[] getHeap()
    {
	@SuppressWarnings("unchecked")
        T[] result = (T[]) new Comparable[heap.length];  // get the heap array back to where it is called
	for(int i = 0; i <= lastIndex; i++)
	    result[i] = heap[i];
	return result;
    }
}
