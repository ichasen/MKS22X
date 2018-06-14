import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")
public class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> data;
    public FrontierPriorityQueue(){
	data = new MyHeap<Location>();
    }
    public Location next(){
	return data.peek();
    }
    public void add(Location n){
	if (n != null){
	    data.add(n);
	}
    }
    public boolean hasNext(){
	if (data.size() > 0){
	    return true;
	}
	else{
	    return false;
	}
    }
}
