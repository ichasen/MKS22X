import java.util.LinkedList;
public class MyLinkedList{
    Node start;
    Node end;
    int size;
    public MyLinkedList(){
	size = 0;
    }
    private Node getNode(int index){
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
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
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
	if (size == 0){
	    start = n;
	    end = start;
	}
	else if (size == 1){
	    end = n;
	    start.setNext(end);
	    end.setPrev(start);
	}
	else{
	    end.setNext(n);
	    n.setPrev(end);
	    end = n;
	}
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
	if (index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node n = new Node();
	n.setValue(value);
	if (index == size){
	    add(value);
	    size++;
	}
	else if (index == 0){
	    start = new Node();
	    start = getNode(0);
	    start.setPrev(n);
	    n.setNext(start);
	    start = n;
	    size++;
	}
	else{
	    getNode(index-1).setNext(n);
	    n.setPrev(getNode(index-1));
	    n.setNext(getNode(index));
	    getNode(index).setPrev(n);
	    size++;
	}
    }
    public boolean remove(Integer value){
	if (indexOf(value) < 0 || indexOf(value) >= size){
	    return false;
	}
	remove(indexOf(value));
	return true;
    }
    public Integer remove (int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	Integer i = getNode(index).getValue();
	if (index - 1 >= 0 && index-1 < size){
	    getNode(index-1).setNext(getNode(index + 1));
	}
	if (index+1 < size){
	    getNode(index+1).setPrev(getNode(index - 1));
	}
	size--;
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
