// Junda Lou
// CS240
// 11.6.2016

public class ArrayStack<T> implements Stack<T>
{
    private T[] Stack;
    private int NumberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    public ArrayStack()
    {
	this(DEFAULT_CAPACITY);
	NumberOfEntries = 0;
    }

    public ArrayStack(int capacity)
    {
	@SuppressWarnings("unchecked")
	T[] tmpStack = (T[]) new Object[capacity];
	Stack = tmpStack;
	NumberOfEntries = 0;
    }

    public int getSize()
    {
	NumberOfEntries = 0;
	int index = 0;
	while(index < Stack.length)
	{
	    if(Stack[index] != null)
		NumberOfEntries++;
	    index++;
	}
	return NumberOfEntries;
    }

    public boolean isEmpty()
    {
	if(getSize() == 0)
	    return true;
	return false;
    }

    public void clear()
    {
	for(int index = 0; index < Stack.length; index++)
	    Stack[index] = null;
    }

    public boolean isFull()
    {
	return Stack[Stack.length - 1] != null;
    }

    public boolean push(T newEntry)
    {
	if(!isFull())
	{
	    Stack[getSize()] = newEntry;
	    return true;
	}
	@SuppressWarnings("unchecked")
	T[] newStack = (T[]) new Object[(Stack.length) * 2];
	for(int index = 0; index < Stack.length; index++)
	    newStack[index] = Stack[index];
	newStack[Stack.length] = newEntry;
	Stack = newStack;
	return true;
    }
    
    public T peek()
    {
	if(isEmpty())
	    return null;
	return Stack[getSize() - 1];
    }

    public T pop()
    {
	assert !isEmpty();	   
	T removedEntry;
	removedEntry = Stack[getSize() - 1];
	Stack[getSize() - 1] = null;
	return removedEntry;
    }
    
    public String toString()
    {
	String stackString = "";
	for(int index = Stack.length; index > 0; index--)
	    stackString = stackString + Stack[index];
	return stackString;
    }
}
