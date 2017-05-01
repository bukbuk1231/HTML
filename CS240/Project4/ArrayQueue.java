//////////////////////////////////////////////////////////
public class ArrayQueue<T> implements Queue<T>
{
    private T[] queue;
    private int size = 0;     // global varible through the whole class
    private int headIndex = 0;   // recording the position of the first entry in the queue
    public static final int DEFAULT_CAPACITY = 3;
     
    //-----------------------------------------------------------
    public ArrayQueue()
    {
	this(DEFAULT_CAPACITY);
	size = 0;
    }
    
    //-----------------------------------------------------------
    public ArrayQueue(int capacity)
    {
	@SuppressWarnings("unchecked")
        T[] tmpQueue = (T[]) new Object[capacity];
	queue = tmpQueue;
	size = 0;
	headIndex = 0;
    }

    //-----------------------------------------------------------
    public boolean enqueue(T newEntry)
    {
	checkCapacity();     // double the size of array if necessary
	queue[size + headIndex] = newEntry;   // make sure its added to the index after the last position
	size++;
	return true;
    }

    //-----------------------------------------------------------
    public T dequeue()
    {
	T removedEntry;
	if(isEmpty())
	    System.out.println("The queue doesn't contain any entry!");
	assert size != 0;    // quit here if size is 0
	removedEntry = queue[headIndex];
	queue[headIndex] = null;    // remove the head index of the queue
	headIndex++;
	size--;
	return removedEntry;
    }

    //-----------------------------------------------------------
    private void checkCapacity()
    {
	if(size == queue.length)
	{
	    @SuppressWarnings("unchecked")
	    T[] newQueue = (T[]) new Object[queue.length * 2];
	    for(int i = 0; i < queue.length; i++)
		newQueue[i] = queue[i];
	    queue = newQueue;
	}
    }
    
    //-----------------------------------------------------------
    public boolean isEmpty()
    {
	return size == 0;
    }

    //-----------------------------------------------------------
}
//////////////////////////////////////////////////////////////