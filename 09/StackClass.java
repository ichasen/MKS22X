import java.util.LinkedList;
public class StackClass{
    private LinkedList<Double> data;
    public StackClass(){
        data = new LinkedList<Double>();
    }
    public boolean empty(){
	if (data.size() == 0){
	    return true;
	}
	return false;
    }
    public Double peek(){
	Double ans = data.get(data.size() - 1);
	return ans;
    }
    public Double pop(){
	return data.remove(data.size() - 1);
    }
    public void push(Double item){
	data.add(item);
    }
    public int search(Object o){
	return data.indexOf(o);
    }
}
