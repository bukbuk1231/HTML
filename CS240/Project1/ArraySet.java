// Junda Lou
// CS240
// 10.18.2016

import java.util.Random;
public class ArraySet<T> implements SetInterface<T>
{
    private T[] Set;
    private int NumberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;    

    // Constructors
    public ArraySet()
    {
	this(DEFAULT_CAPACITY);
    }
    
    public ArraySet(int capacity)
    {
	    T[] tmpSet = (T[]) new Object[capacity];
	    Set = tmpSet;
	    NumberOfEntries = 0;
    }
    
    public int getCurrentSize()
    {
	for(int i = 0; i < Set.length; i++)
	{
	    if(Set[i] != null)
		NumberOfEntries++;
	}
	return NumberOfEntries;
    }

    public boolean isEmpty()
    {
	// the array is empty if every element is null
        int i = 0;
	while(Set[i] == null)
	    i++;
	if(i == Set.length)
	    return true;
	else
	    return false;
    }

    public boolean add(T newEntry)
    {
        int i = 0;
	if(contains(newEntry))   // a set cannot have duplicates
	    return false;
	if(isFull())             // cannot add more if the array is full
	    return false;
	while(Set[i] != null)    // find the first available position to add
	    i++;
	Set[i] = newEntry;
	return true;
    }
	
    public boolean remove(T anEntry)
    {
        int i = 0;
	if(!contains(anEntry))// cannot remove if the entry is not in the array
	    return false;
	if(isEmpty())         // cannot remove if the array is empty itself
	    return false;
	while(Set[i] != anEntry)          
	    i++;
	Set[i] = Set[getCurrentSize()];  
	Set[getCurrentSize()] = null;
	/* replace the position of the entry to be removed with the last entry
	in the array */
	return true;
    }

    public T remove()
    {
	T result;
	if(isEmpty())            // nothing to remove if the array is empty
	    return null;
	Random unspecifiedEntry = new Random(getCurrentSize());
	int entry = unspecifiedEntry.nextInt();
	result = Set[entry];
	/* generate a random int within the range of Number of Entries in the
        Set that to be the index of the entry to be removed */
	Set[entry] = Set[getCurrentSize()];
	Set[getCurrentSize()] = null;
	return result;
    }

    public void clear()
    {
	for(int i = 0; i < Set.length; i++)
	    Set[i] = null;            // set everything null
    }
	
    public boolean contains(T anEntry)
    {
	for(int i = 0; i < Set.length; i++)
	{    
	    if(Set[i].equals(anEntry))
		return true;
	}
	return false;
    }

    public T[] toArray()
    {
	if(isEmpty())
	{
	    T[] resultArray = Set;  // return an empty array if the set is empty
	    return resultArray;
	}
	T[] resultArray = (T[])new Object[getCurrentSize()];      
	for(int i = 0; i < getCurrentSize(); i++)
	{
	    resultArray[i] = Set[i];
	}
	return resultArray;
    }

    public boolean isFull()
    {
	return getCurrentSize() >= Set.length;
    }

    public int getSetSize()
    {
	return Set.length;
    }

    public T[] getSet()
    {
	return Set;
    }
    /*
    public SetInterface<T> union(SetInterface<T> a)
    {
        boolean removeSameEntry;
	T[] tmpUnionSet = (T[]) new Object[Set.length + a.getSetSize];
	for(int i = 0; i < Set.length; i++)
	{
	    tmpUnionSet[i] = Set[i];
	}
	for(int j = 0; j < a.getSetSize; j++)
	{
	    tmpUnionSet[i] = a.getSet[j];
	    i++;
	}
	for(i = 1; i < tmpUnionSet.length; i++)
	{
	    for(int currentEntryIndex = 0; currentEntryIndex < tmpUnionSet.length; currentEntryIndex++)
	    {
		if(tmpUnionSet[currentEntryIndex].equals(tmpUnionSet[i]))     
		    removeSameEntry = remove(tmpUnionSet[i]);
	    }
	}
	ArraySet unionSet = new ArraySet(tmpUnionSet.getCurrentSize());
	    for(i = 0; i < tmpUnionSet.getCurrentSize(); i++)
		unionSet.add(tmpUnionSet[i]);
    }
    */
}