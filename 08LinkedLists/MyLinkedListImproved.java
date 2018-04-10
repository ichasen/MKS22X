public class MyLinkedListImproved<T>{
    Node start;
    Node end;
    int size;
    public MyLinkedListImproved(){
	size = 0;
    }
    private Node getNode(int index){
	if (index<0 || index>=size){
	    throw new IndexOutOfBoundsException();
	}
	int current = 0;
	Node n = start;
	while(current < index){
	    n = n.getNext();
	    current++;
	}
	return n;
    }
    public int size(){
	return size;
    }
    public T get(int index){
	return getNode(index).getValue();
    }
    public T set(int index,int newValue){
	Node n = getNode(index);
        n.setValue(newValue);
	return n.getValue();
    }
    public String toString(){
	String ans = "[";
	for (int i = 0;i<size;i++){
	    ans += get(i);
	    ans += ",";
	}
	ans += "]";
	return ans;
    }
    public boolean add(int value){
	Node n = new Node();
	n.setValue(value);
	getNode(size-1).setNext(n);
	n.setPrev(getNode(size-1));
	size += 1;
	return true;
    }
    public void clear(){
	size = 0;
	start = null;
	end = start;
    }
    public int indexOf(Integer value){
	for (int i = 0;i<size;i++){
	    if (getNode(i).getValue() == value){
		return i;
	    }
	}
	return -1;
    }
    public void add(int index,Integer value){
	T i = getNode(index).getValue();
	getNode(index).setValue(value);
	for (int j = size;j<size + (size-index);j++){
	    add(getNode(index + j).getValue());
        }
	for (int x = 0;x<size;x++){
	    remove(x);
	}
    }
    public boolean remove(Integer value){
	for (int i = 0;i<size;i++){
	    if (getNode(i).getValue() == value){
		for (int j = i;j<size;j++){
		    if (j==size-1){
			getNode(j).setValue(null);
		    }else{
			getNode(j).setValue(getNode(j+1).getValue());
		    }
		    return true;
		}
	    }
	}
	return false;
    }
    public Integer remove (int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	T i = getNode(index).getValue();
	for (int j = index;j<size;j++){
	    if (j==size-1){
		getNode(j).setValue(null);
	    }else{
		getNode(j).setValue(getNode(j+1).getValue());
	    }
	}
	return i;
    }
    private class Node{
	Node next;
	Node prev;
	int data;
	public Node getNext(){
	    return next;
	}
	public Node getPrev(){
	    return prev;
	}
	public void setNext(Node newValue){
	    next = newValue;
	}
	public void setPrev(Node newValue){
	    prev = newValue;
	}
	public T getValue(){
	    return data;
	}
	public void setValue(Integer newValue){
	    data = newValue;
	}
	public String toString(){
	    String ans = "";
	    ans += data;
	    ans += "Previous: " + prev + "/n" + "Current: " + data + "/n" +  "Next: " + next;
	    return ans;
	}
    }
}
