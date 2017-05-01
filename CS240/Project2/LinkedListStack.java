public class LinkedListStack<T> implements Stack<T>
{
    private Node firstNode;
    private int numberOfEntries;

    public LinkedListStack()
    {
	firstNode = null;
	numberOfEntries = 0;
    }

    public int getSize()
    {
	while (firstNode != null)
	{
	    numberOfEntries++;
	    firstNode = firstNode.next;
	}
	return numberOfEntries;
    }

    public boolean isEmpty()
    {
	if(firstNode == null)
	    return true;
	return false;
    }

    public void push(T newEntry)
    {
	Node newNode = new Node(newEntry, firstNode);
	firstNode = newNode;
	numberOfEntries++;
    }
	
    public T pop()
    {
	if(isEmpty())
	    throws new EmptyStackException("The stack is empty.");
	T removedEntry;
	removedEntry = firstNode.data;
	firstNode = firstNode.next;
	return removedEntry;
    }
    
    public T peek()
    {
	return firstNode.data;
    }
    
    public void clear()
    {
	firstNode = null;
    }

    public Stirng toString()
    {
	Node currentNode = firstNode;
	if(isEmpty())
	    throws new EmptyStackException("The stack is empty.");
	String stackString = "";
	while(currentNode != null)
	{
	    stackString += currentNode.data;
	    currentNode = currentNode.next;
	}
	return stackString;

    private class Node
    {
	private T data;
	private Node next;

	private Node(T dataPortion)
	{
	    this(dataPortion, null);
	}

	private Node(T dataPortion, Node nextNode)
	{
	    data = dataPortion;
	    next = nextNode;
	}
    }
}