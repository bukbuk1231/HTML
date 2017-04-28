/**
 * An interface for the Stack ADT.
 * 
 * @author Gilberto Perez
 * @version 1.0
 */
/////////////////////////////////////////////////////////////////////
public interface Stack<T> 
{
	// Core stack functions
	boolean push(T newEntry); // Attempt to add a new entry.
	T pop(); // Remove the top entry
	T peek(); // Returna reference to the top entry, but do not remove.
	
	// A few extra methods
	int getSize();
	boolean isEmpty();
	void clear(); // Remove all entries from stack
	String toString();
}
/////////////////////////////////////////////////////////////////////