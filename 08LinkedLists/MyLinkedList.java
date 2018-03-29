public class MyLinkedList{
    Node start;
    Node end;
    int size;
    public MyLinkedList(){
	size = 0;
    }
    private Node getNode(int index){
	
    }
    public int size(){
	return size;
    }
    public int get(int index){
	return getNode(index).getValue();
    }
    public int set(int index,int newValue){
	getNode(index).setData(newValue);
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
	    ans += "Previous: " + prev + "/n" + "Current: " + data + "/n" +  "Next: " + next;
	    return ans;
	}
    }
}
	
