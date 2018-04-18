import java.util.LinkedList;
public class StackClass{
    private LinkedList<Double> data;
    public StackClass(){
	data.clear();
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
	Double ans = data.get(data.size() - 1);
	data.remove(data.size() - 1);
	return ans;
    }
    public Double push(Double item){
	int index = data.indexOf(item);
	data.add(item);
	data.remove(index);
	return item;
    }
    public int search(Object o){
	return data.indexOf(o);
    }
}
