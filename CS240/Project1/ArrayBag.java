// Junda Lou
// CS240
// 10.18.2016

// everything similar to the previos ones, so less comments
import java.util.Random;
public class ArrayBag<T> implements BagInterface<T>
{
    private T[] Bag;
    private int NumberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;    

    public ArrayBag()
    {
	this(DEFAULT_CAPACITY);
    }
    
    public ArrayBag(int capacity)
    {
	    T[] tmpBag = (T[]) new Object[capacity];
	    Bag = tmpBag;
	    NumberOfEntries = 0;
    }
    
    public int getCurrentSize()
    {
	for(int i = 0; i < Bag.length; i++)
	{
	    if(Bag[i] != null)
		NumberOfEntries++;
	}
	return NumberOfEntries;
    }

    public boolean isEmpty()
    {
	int i = 0;
	while(Bag[i] == null)
	    i++;
	if(i == Bag.length)
	    return true;
	else
	    return false;
    }

    public boolean add(T newEntry)
    {
        int i = 0;
	if(isFull())
	    return false;
	while(Bag[i] != null)
	    i++;
	Bag[i] = newEntry;
	return true;
    }
	
    public boolean remove(T anEntry)
    {
        int i = 0;
	if(!contains(anEntry))
	    return false;
	if(isEmpty())
	    return false;
	while(Bag[i] != anEntry)
	    i++;
	Bag[i] = Bag[getCurrentSize()];
	Bag[getCurrentSize()] = null;
	return true;
    }

    public T remove()
    {
        T result = null;
	if(isEmpty())
	    return result;
	Random unspecifiedEntry = new Random(getCurrentSize());
	int entry = unspecifiedEntry.nextInt();
	result = Bag[entry];
	Bag[entry] = Bag[getCurrentSize()];
	Bag[getCurrentSize()] = null;
	return result;
    }

    public void clear()
    {
	for(int i = 0; i < Bag.length; i++)
	    Bag[i] = null;
    }
	
    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;
	for(int i = 0; i < Bag.length; i++)
	{    
	    if(Bag[i].equals(anEntry))
		frequency++;
	}
	return frequency;
    }

    public boolean contains(T anEntry)
    {
	for(int i = 0; i < Bag.length; i++)
	{    
	    if(Bag[i].equals(anEntry))
		return true;
	}
	return false;
    }

    public T[] toArray()
    {
	if(isEmpty())
	{
	    T[] resultArray = Bag;
	    return resultArray;
	}
	T[] resultArray = (T[])new Object[getCurrentSize()];	    
	for(int i = 0; i < getCurrentSize(); i++)
	{
	    resultArray[i] = Bag[i];
	}
	return resultArray;
    }

    public boolean isFull()
    {
	return getCurrentSize() >= Bag.length;
    }
}