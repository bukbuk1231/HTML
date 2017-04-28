import java.util.*;
import java.io.*;

public class test
{
    public static void main(String[] args) throws IOException
    {
	/*
	DirectedGraph<String> a = new DirectedGraph<String>(2);
	a.addEdge(0, 1, 2);
	a.addLabel(1, "A");
        Dijkstra<String> b = new Dijkstra<String>(a);
	b.test();
	*/

	//	Queue<String> x = new PriorityQueue<String>();

	/*
	Queue<String> x = new LinkedList<String>();

	x.add("math");
	x.add("english");
	x.add("Art");
	System.out.println(x.peek());
	*/

	String[] data;
	Scanner kb = new Scanner(System.in);
	System.out.println("input: ");
	data = kb.nextLine().split(" ");
	for(String x : data)
	    System.out.println(x);
	System.out.println(data.length);


	
    }

}