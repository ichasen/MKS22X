public class MyLinkedList{
    Node start;
    Node end;
    int size;
    public MyLinkedList(){
	size = 0;
    }
    public int size(){
	return size;
    }
    public int get(int index){
	
    }
    public int set(int index,int newValue){
	return index;
    }
    public boolean add(int value){
	Node n = new Node();
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
	public String toString(){
	    String ans = "";
	    ans += data;
	    return ans;
	}
    }
}
	
