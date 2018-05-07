import java.util.*;
import java.io.*;
public class FrontierQueue implements Frontier{
    Deque frontier = new Deque();
    public Location next(){
	return frontier.removeFirst();
    }
    public void add(Location n){
	frontier.addLast(n);
    }
    public boolean hasNext(){
	if (frontier.size() > 0){
	    return true;
	}
	return false;
    }
}
