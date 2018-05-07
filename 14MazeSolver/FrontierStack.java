import java.util.Stack;
public class FrontierStack implements Frontier{
    Stack frontier = new Stack();
    public Location next(){
	@SuppressWarnings("unchecked") Location ans = (Location)frontier.peek();
	return ans;
    }
    public void add(Location n){
	@SuppressWarnings("unchecked") frontier.push(n);
    }
    public boolean hasNext(){
	return frontier.empty();
    }
}
