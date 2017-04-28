///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class InsertionSort<T extends Comparable<? super T>> {

   private Node topNode, lastNode;
   public int total;
   
   private class Node
   {
	  T data;
	  Node next;
	  Node prev;
	  
	  //---------------------------------------------------------------------------
	  public Node(T entry)       //constructor to initialized with a given value
	  {
		 this.data = entry;
	  }
	  
	  //---------------------------------------------------------------------------
	  public Node()              //default constructor
	  {
		 this.next = null;
		 this.prev = null;
	  }
	  
	  //---------------------------------------------------------------------------
	  public void setNext(Node next)     //set next node to a given node
	  {
		 this.next = next;
	  }
	  
	  //---------------------------------------------------------------------------
	  public void setPrev(Node prev)     //set previous node to a given node
	  {
		 this.prev = prev;
	  }
	  
	  //---------------------------------------------------------------------------
	  public T getData()                 //get data of a node
	  {
		 return data;
	  }
	  
	  //---------------------------------------------------------------------------
	  public Node getNext()              //get to the next node
	  {
		 return next;
	  }

   }
   
   //------------------------------------------------------------------------------
   public InsertionSort()        //default constructor
   {
	  topNode = null;
	  total = 0;
   }
   
   //------------------------------------------------------------------------------
   private void insertInOrder(Node nodeToInsert)   //determine where to insert
   {
	  T item = nodeToInsert.getData();
	  Node currentNode = topNode;
	  Node previousNode = null;
	  
	  while (item.compareTo(currentNode.getData()) > 0) //compare the data of chosen node  to the current node
	  {                                                 //if is greater
		 previousNode = currentNode;                    //set current node to previous
		 currentNode = currentNode.getNext();           //and set next node to current node
		 if (currentNode == null)                       //break if reach the end of the linked list
		 {
			break;
		 }
	  }
	  
	  if (currentNode == null)                   //if reaches end and the value is still greater
	  {
		 previousNode.setNext(nodeToInsert);     //put the nodeToInsert at the end of the linked list
		 nodeToInsert.setPrev(previousNode);
	  }
		
	  else if (previousNode == null)             //if data of nodeToInsert is less than the first
	  {                                          //node in the sorted part, insert to the front
		 currentNode.setPrev(nodeToInsert);
		 nodeToInsert.setNext(currentNode);
		 topNode = nodeToInsert;
	  }
	  
	  else                                       //otherwise, insert between previous and current
	  {
		 previousNode.setNext(nodeToInsert);
		 nodeToInsert.setPrev(previousNode);
		 nodeToInsert.setNext(currentNode);
		 currentNode.setPrev(nodeToInsert);
	  }
   }
   //------------------------------------------------------------------------------
   public void addToLast(T entry)       //method to add the entry to the linked list
   {                                    //is used in driver
	  if (topNode == null)
	  {
		 Node temp = new Node();
		 temp.data = entry;
		 topNode = temp;
		 lastNode = temp;
		 total++;
	  }
	  else
	  {
		 Node temp = new Node();
		 temp.data = entry;
		 temp.prev = lastNode;
		 lastNode.next = temp;
		 lastNode = lastNode.next;
		 total++;
	  }
   }
   //------------------------------------------------------------------------------
   public void insertionSort()            //sort algorithm
   {
	  if (total > 1)                      //check empty
	  {
		 assert topNode != null;
		 Node unsortedPart = topNode.getNext();    //make the next node of the topNode to be the first in unsorted part
		 assert unsortedPart != null;              //make sure unsorted part is not empty, otherwise doesn't need to sort
		 topNode.getNext().setPrev(null);          //break the linked list into two part, sorted and unsorted
		 topNode.setNext(null);
			
		 while (unsortedPart != null)              //if unsorted part is not empty
		 {
			Node nodeToInsert = unsortedPart;      //make the first node in the unsorted part to be the node to insert
			unsortedPart = unsortedPart.getNext(); //exclude this node from unsorted part
			if (nodeToInsert.next != null)         //if the node to insert is not the last node of the unsorted part
			{
			   nodeToInsert.getNext().setPrev(null);  //break the node to insert from the unsorted part
			   nodeToInsert.setNext(null);
			}
			
			insertInOrder(nodeToInsert);           //insert to the sorted part
			
		 }
	  }
   }
   
   //------------------------------------------------------------------------------
   public String toString()      //convert linked list to string
   {
	  String element = new String("");
	  Node current = topNode;
	  
	  while (current != null)
	  { 
		 element = element + current.getData() + " ";
		 current = current.getNext();
	  }
	  
	  return element;
   }	
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////