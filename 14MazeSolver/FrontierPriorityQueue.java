public class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> data;
    public Location next(){
	
    }
    public void add(Location n){
	data.add(n);
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
