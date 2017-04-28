import java.util.*;

public class Dijkstra<T>
{
    DirectedGraph graph;
    Set visited;
    Set unvisited;
    int[] relax;
    int[] prev;
    
    public Dijkstra(DirectedGraph graphData)
    {
	graph = graphData;
	visited = new HashSet<T>();     // Default constructor, takes in a graph to form the algorithm
	unvisited = new HashSet<T>();
	for(int i = 0; i < graph.getSize(); i++)
	    unvisited.add(graph.getLabel(i));
	relax = new int[graph.getSize()];       // initial relax[] and prev[] base on the graph vertices
	prev = new int[graph.getSize()];
	for(int i = 0; i < relax.length; i++)	
	{  
	    relax[i] = Integer.MAX_VALUE;   // initialization
	    prev[i] = -1;   // -1 by default means no prev node
	}
    }
     
    public int[] getMinRoute(int source, int target)
    {
	minRoute(source, target);
	int count = 0, current = target;
	while(current != source && prev[current] != -1)
        {
	    current = prev[current];    // get the route length by searching through prev[]
	    count++;
	}
	current = target;
	int[] route = new int[count + 1];	
	for(int i = route.length - 1; i >= 0; i--)
	{
	    route[i] = current;
	    current = prev[current];   // get the route
	}
	return route;    
    }

    public int getMinDistance(int source, int target)
    {
	int distance = 0;
	int[] route = getMinRoute(source, target);     // get the distance base on the route[]
	for(int i = 0; i < route.length - 1; i++)
	    distance += graph.getWeight(route[i], route[i + 1]);
	return distance;
    }

    private void minRoute(int source, int target)
    {
	boolean found = false;
	int node = source;
	relax[source] = 0;    // set source to 0, all others infinity by default
	prev[source] = -1;  
	while(!found)
	{
	    node = findNextNode(node);
	    if(node == target)    // quit when reaches the target
		found = true;	
	    visited.add(graph.getLabel(node));    // add the current node to Set: visited
	    relaxEdge(node);   // relax the edges
	    unvisited.remove(graph.getLabel(node));  // remove the node from Set: unvisited, means it's done
	    if(unvisited.isEmpty()) {
		System.out.println("No route");    // if all nodes are visited and still in the loop, means there is no route
		break;
	    }	 
	}
    }
    
    private int findNextNode(int node)
    {
	int min = Integer.MAX_VALUE;    // default value
	for(int i = 0; i < relax.length; i++)
	    if(relax[i] < min && unvisited.contains(graph.getLabel(i)) && relax[i] > 0)  // get the next smallest relaxation value, and make sure it is in the unvisited Set
		min = relax[i];
	for(int i = 0; i < relax.length; i++)
	    if(min == relax[i] && min != Integer.MAX_VALUE && unvisited.contains(graph.getLabel(i)))
		node = i;	    // when you get it, get the index
	return node;
    }
    
    private void relaxEdge(int current)
    {	
	for(int i = 0; i < relax.length; i++) {
	    if((graph.getEdge())[current][i] && !visited.contains(graph.getLabel(i))) {
		if(relax[i] == Integer.MAX_VALUE || (relax[current] + graph.getWeight(current, i)) < relax[i]) {
		    relax[i] = graph.getWeight(current, i) + relax[current];
		    prev[i] = current;    // relax algorithm of Dijkstra
		}
	    }
	}
    }
 
    public void reset()    // reset everthing
    {
	visited.clear();
	unvisited.clear();
	for(int i = 0; i < graph.getSize(); i++)
	    unvisited.add(graph.getLabel(i));
	for(int i = 0; i < relax.length; i++) {	
	    relax[i] = Integer.MAX_VALUE; 
	    prev[i] = -1;
	}
    }

}