// Junda Lou
// CS240
// 10.18.2016

public interface MultisetInterface<T>
{
    /* Gets the current number of entries in this Multiset.
    Return  The integer number of entries currently in the Multiset. */
    public int getCurrentSize();
	
    /* Sees whether this Multiset is empty.
    Return  True if the Multiset is empty, or false if not. */
    public boolean isEmpty();
	
    /* Adds a new entry to this Multiset.
    Parameter newEntry The object to be added as a new entry.
    Return True if the addition is successful, or false if not. */
    public boolean add(T newEntry);

    /* Removes one unspecified entry from this Multiset, if possible.
    Return Either the removed entry, if the removal was successful, or null. */
    public T remove();
   
    /* Removes one occurrence of a given entry from this Multiset.
    Parameter anEntry  The entry to be removed.
    Return  True if the removal was successful, or false if not. */
    public boolean remove(T anEntry);
	
    /* Removes all entries from this Multiset. */
    public void clear();
	
    /* Counts the number of times a given entry appears in this Multiset.
    Parameter anEntry  The entry to be counted.
    Return  The number of times anEntry appears in the Multiset. */
    public int getFrequencyOf(T anEntry);
	
    /* Tests whether this Multiset contains a given entry.
    Parameter anEntry The entry to locate.
    Return  True if the Multiset contains anEntry, or false if not. */
	public boolean contains(T anEntry);
   
    /* Retrieves all entries that are in this Multiset.
    Return  A newly allocated array of all the entries in the Multiset.
    If the Multiset is empty, the returned array is empty. */
	public T[] toArray();
}
// end MultiSetInterface