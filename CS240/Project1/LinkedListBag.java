// Junda Lou
// CS240
// 10.18.2016

// everything similar to the previos ones, so less comments
import java.util.Random;
public class LinkedListBag<T> implements BagInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;

    public LinkedListBag()
    {
	firstNode = null;
	numberOfEntries = 0;
    }

    public int getCurrentSize()
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

    public boolean add(T newEntry)
    {
	Node newNode = new Node(newEntry);
	newNode.next = firstNode;
	firstNode = newNode;
	numberOfEntries++;
	return true;
    }

    private Node getReferenceTo(T anEntry)
    {
	boolean found = false;
	Node currentNode = firstNode;
	while(!found && (currentNode != null))
	{
	    if(anEntry.equals(currentNode.data))
		found = true;
	    else
		currentNode = currentNode.next;
	}
	return currentNode;
    }
	
    public boolean remove(T anEntry)
    {
	if(!contains(anEntry))
	    return false;
	if(isEmpty())
	    return false;
	Node nodeN = getReferenceTo(anEntry);
	if(nodeN != null)
	{
	    nodeN.data = firstNode.data;
	    firstNode = firstNode.next;
	    numberOfEntries--;
	}
	return true;
    }
    
    public T remove()
    {
        T removedEntry;
	Node nodeN = firstNode;
	Random removedEntryNumber = new Random(getCurrentSize());
	int entry = removedEntryNumber.nextInt();
	while(entry != 0)
	{
	    nodeN = nodeN.next;
	    entry--;
	}
	removedEntry = nodeN.data;
	if(nodeN != null)
	{
	    nodeN.data = firstNode.data;
	    firstNode = firstNode.next;
	    numberOfEntries--;
	}
	return removedEntry;
    }
    
    public void clear()
    {
	firstNode = null;
    }

    public int getFrequencyOf(T anEntry)
    {
        Node currentNode = firstNode;
        int frequency = 0;
	while(currentNode != null)
	{
	    if(currentNode.data.equals(anEntry))
		frequency++;
	}
	// add 1 time to the frequency Counter every time it matches
	return frequency;
    }

    public boolean contains(T anEntry)
    {
        boolean found = false;
	Node currentNode = firstNode;
	while(!found && (currentNode != null))
	{
	    if(anEntry.equals(currentNode.data))
		found = true;
	    else
		currentNode = currentNode.next;
	}
	return found;
    }

    public T[] toArray()
    {
	int i = 0;
	if(getCurrentSize() == 0)
	{
	    T[] resultArray = null;
	    return resultArray;
	}
	T[] resultArray = (T[]) new Object[getCurrentSize()];
	Node currentNode = firstNode;
	while((i < getCurrentSize()) && (currentNode != null))
	{
	    resultArray[i] = currentNode.data;
	    i++;
	    currentNode = currentNode.next;
	}
	return resultArray;
    }

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