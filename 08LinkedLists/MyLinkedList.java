public class MyLinkedList{
    Node start;
    Node end;
    int size;
    public MyLinkedList(){
	size = 0;
    }
    private Node getNode(int index){
	int current = 0;
	Node n = first;
	while(current < index){
	    n = n.getNext();
	    current++;
	}
	return n
    }
    public int size(){
	return size;
    }
    public int get(int index){
	return getNode(index).getValue();
    }
    public int set(int index,int newValue){
	if (index<0 || index >= size){
	    throw new IndexOutOfBoundsException("index is less than 0 or greater than the length");
	Node n = getNode(index);
        n.setData(newValue);
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
	n.setData(value);
	getNode(size-1).setNext(n);
	n.setPrev(getNode(size-1));
	size += 1;
	return true;
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
	public int getValue(){
	    return data;
	}
	public void setNext(Node newNext){
	    next = newNext;
	}
	public void setPrev(Node newPrev){
	    prev = newPrev;
	}
	public void setData(int newData){
	    data = newData;
	}
	public String toString(){
	    String ans = "";
	    ans += data;
	    ans += "Previous: " + prev + "/n" + "Current: " + data + "/n" +  "Next: " + next;
	    return ans;
	}
    }
}
	
