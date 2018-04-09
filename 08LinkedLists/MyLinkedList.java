public class MyLinkedList{
    Node start;
    Node end;
    int size;
    public MyLinkedList(){
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
    public Integer get(int index){
	return getNode(index).getValue();
    }
    public Integer set(int index,int newValue){
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
	public Integer getValue(){
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
	
