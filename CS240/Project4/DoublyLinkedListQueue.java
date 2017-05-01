////////////////////////////////////////////////////////////////
public class DoublyLinkedListQueue<T> implements Queue<T>
{
    private int size;     // global varible controlling the size, not very useful in Linked List
    private Node firstNode;
    private Node lastNode;    
   
    //-----------------------------------------------------------
    public DoublyLinkedListQueue()
    {
	firstNode = null;       
	lastNode = null;      // Default Constructor, set everything null
	size = 0;
    }

    //-----------------------------------------------------------

    public boolean enqueue(T newEntry)    
    {  
	Node newNode = new Node(newEntry);
	if(firstNode == null)
	{
	    firstNode = newNode;   // if size is 0, just set the first and last node to newNode
	    lastNode = firstNode;
	    size++;
	}
	else
        {    
	    if(size == 1)  // only when size = 1, firstNode.next = null
		firstNode.next = newNode;    
	    newNode.prev = lastNode;   
	    lastNode.next = newNode;	    
	    lastNode = newNode;	  	
	    size++;
	}
	return true;   
    }
    
    //-----------------------------------------------------------
    public T dequeue()
    {
	T removedEntry;    
	if(isEmpty())    // Empty queue
	    System.out.println("The queue does not contain any entry!");
	assert !isEmpty();
	removedEntry = firstNode.data;
	if(size >= 3)   
	{
	    firstNode.data = firstNode.next.data;
	    firstNode.next = firstNode.next.next;
	    size--;	  
	}
	else if(size == 2)   // firstNode.next becomes null when size is 2
	{
	    firstNode.data = lastNode.data;
	    firstNode.next = null;
	    lastNode = firstNode;
	    size--;
	}
	else    // remove everything if size is 1
	{
	    firstNode = null;
	    lastNode = null;
	    size--;
	}
	return removedEntry;    
    }

    //-----------------------------------------------------------
    public boolean isEmpty()
    {
	return firstNode == null;
    }

    //-----------------------------------------------------------
    private class Node
    { 
	private T data;
	private Node next;
	private Node prev;
	
	private Node(T dataPortion)
	{
	    this(dataPortion, null, null);
	}

	private Node(T dataPortion, Node nextNode, Node prevNode)
	{
	    data = dataPortion;
	    next = nextNode;
	    prev = prevNode;
	}
    }
    //-----------------------------------------------------------
}
/////////////////////////////////////////////////////////