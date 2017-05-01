///////////////////////////////////////////////////////////////
public class PriorityQueue<T extends Comparable<? super T>> implements Queue<T>
{
    private int size;
    private Node firstNode;
    private Node lastNode;    
   
    //-----------------------------------------------------------
    public PriorityQueue()
    {
	firstNode = null;       
	lastNode = null;      // Default Constructor, set everything null
	size = 0;
    }

    //-----------------------------------------------------------

    public boolean enqueue(T newEntry)    
    {  
	Node currentNode = lastNode;   // control the position to add, start from the last position becasue entries are added at the end by default
	Node newNode = new Node(newEntry);
	if(isEmpty())    // same here as the DoublyLL implementation
	{
	    firstNode = newNode;
	    lastNode = firstNode;
	    size++;
	}
	else
	{    
	    while(newNode.data.compareTo(currentNode.data) > 1 && currentNode != firstNode)
		currentNode = currentNode.prev;    // currentNode would become null if it continues .prev
	    if(size == 1 && newNode.data.compareTo(currentNode.data) > 1)
	    {
		lastNode.prev = newNode;    // limit situation1 when currentNode = firstNode
		newNode.next = lastNode;    // insert the Node before the first, and make itself first
		firstNode = newNode;		
		size++;
	    }
	    else if(currentNode == lastNode)
	    {
		lastNode.next = newNode;     // limit situation2 when the priority is the smallest
		newNode.prev = lastNode;     // just add it after the lastNode
		lastNode = newNode;
		size++;
	    }
	    else
	    {
		newNode.prev = currentNode;         // normal situation
		newNode.next = currentNode.next;    // insert it between currentNode and currentNode.next
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	    }
	}
	return true;   
    }
    
    //-----------------------------------------------------------
    public T dequeue()   // same as the DoublyLL implementation
    {
	T removedEntry;
	if(isEmpty())
	    System.out.println("The queue does not contain any entry!");
	assert !isEmpty();
	removedEntry = firstNode.data;
	if(size >= 3)
	{
	    firstNode.data = firstNode.next.data;
	    firstNode.next = firstNode.next.next;
	    size--;	  
	}
	else if(size == 2)
	{
	    firstNode.data = lastNode.data;
	    firstNode.next = null;
	    lastNode = firstNode;
	    size--;
	}
	else
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
////////////////////////////////////////////////////////