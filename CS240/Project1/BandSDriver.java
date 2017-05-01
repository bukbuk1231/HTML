// Junda Lou
// CS240
// 10.18.2016

import java.util.Scanner;
public class BandSDriver
{
    public static void main(String[] args)
    {
	Scanner keyboard = new Scanner(System.in);
	getDataStructure();
	System.out.print("You choose: ");
	int dataStructure = keyboard.nextInt();
	getImplementMethod();
	System.out.print("You choose: ");
	int implementMethod = keyboard.nextInt();
	getOperations();
	System.out.print("You choose: ");
	int operations = keyboard.nextInt();
	makeImplements(dataStructure, implementMethod, operations);
    }
    public static void getDataStructure()
    { 
	System.out.println("What kind of data structure would you like?");
	System.out.println("1) Set");
	System.out.println("2) Multiset");
	System.out.println("3) Bag");
    }

    public static void getImplementMethod()
    {
	System.out.println("1) Array");
	System.out.println("2) Linked List");
    }

    public static void getOperations()
    {
	System.out.println("1) Get Current Size");
	System.out.println("2) Check if the it's empty");
	System.out.println("3) Add item");
	System.out.println("4) Remove a specific entry");
	System.out.println("5) Remove a unspceific entry");
	System.out.println("6) Clear");
	System.out.println("7) Check if it contains a certain entry");
	System.out.println("8) toArray");
	if(dataStructure > 1)
	    System.out.println("9) Get Frequency of a certain entry");
    }

    public static void makeImplements(int dataStructure, int implementMethod, int operations)
    {
	if(dataStructure == 1 && implementMethod == 1)	
	    ArraySet<T> arraySet = new ArraySet();	

	if(dataStructure == 1 && implementMethod == 2)
	{
        LinkedListSet<T> linkedSet = new LinkedListSet();
	int size = linkedSet.getCurrentSize();
	System.out.println(size);
	}	



	if(dataStructure == 2 && implementMethod == 1)
	    ArrayMultiSet<T> arrayMultiset = new Arraymultiset();

	if(dataStructure == 2 && implementMethod == 2)
	    LinkedListMultiSet<T> linkedMultiset = new LinkedListMultiSet();

	if(dataStructure == 3 && implementMethod == 1)
	    ArrayBag<T> arrayBag = new ArrayBag();
     
	if(dataStructure == 3 && implementMethod == 2)
	    LinkedListBag<T> linkedBag = new LinkedListBag();

    }
	/*
    public static void makeOpreations(int operations)
    {

	if(operations >= 1 && operations <= 9)
	    System.out.println("See different Outputs");
	 Too long to write everything, and it's unable to try different inputs
	   using Scanner 

*/	

}