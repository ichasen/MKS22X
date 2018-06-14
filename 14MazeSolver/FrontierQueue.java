import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")
public class FrontierQueue implements Frontier{
    LinkedList<Location> frontier;
    public FrontierQueue(){
	frontier = new LinkedList<Location>();
    }
    public Location next(){
	return frontier.removeLast();
    }
    public void add(Location n){
	if (n == null){
	    throw new NullPointerException();
	}
	frontier.addFirst(n);
    }
    public boolean hasNext(){
	if (frontier.size() > 0){
	    return true;
	}
	return false;
    }
}
