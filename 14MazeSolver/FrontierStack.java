import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")
public class FrontierStack implements Frontier{
    private LinkedList<Location> frontier;
    public FrontierStack(){
	frontier = new LinkedList();
    }
    public Location next(){
        return frontier.removeFirst();
    }
    public void add(Location n){
	frontier.addFirst(n);
    }
    public boolean hasNext(){
	return frontier.size() > 0;
    }
}
