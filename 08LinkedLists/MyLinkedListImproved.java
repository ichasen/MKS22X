import java.util.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    Node start;
    Node end;
    int size;
    public MyLinkedListImproved(){
	size = 0;
    }
    public Node getNode(int index){
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
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getValue();
    }
    public T set(int index,T newValue){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	Node n = getNode(index);
	T ans = n.getValue();
        n.setValue(newValue);
	return ans;
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
    public boolean add(T value){
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
    // for sorts purposes
    public void add2(T value){
	Node n = new Node();
	n.setValue(value);
	getNode(size-1).setNext(n);
	n.setPrev(getNode(size-1));
	size += 1;
    }
    public void clear(){
	size = 0;
	start = null;
	end = start;
    }
    public int indexOf(T value){
	for (int i = 0;i<size;i++){
	    if (getNode(i).getValue() == value){
		return i;
	    }
	}
	return -1;
    }
    public void add(int index,T value){
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
	    n.setNext(start);
	    start.setPrev(n);
	    n.setNext(start);
	    start = n;
	    size++;
	}
	else{
	    Node x = getNode(index-1);
	    Node y = getNode(index);
	    n.setPrev(x);
	    n.setNext(y);
	    x.setNext(n);
	    y.setPrev(n);
	    size++;
	}
    }
    public boolean remove(T value){
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
    public T remove (int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	T i = getNode(index).getValue();
	if (index == 0){
	    start = start.getNext();
	    start.setPrev(null);
	}
	else if (index == size - 1){
	    end = end.getPrev();
	    end.setNext(null);
	}
	else{
	    Node x = getNode(index - 1);
	    Node y = getNode (index + 1);
	    x.setNext(y);
	    y.setPrev(x);
	}
	size--;
	return i;
    }
    public int max(){
	if (size == 0){
	    return -1;
	}
	if (size == 1){
	    return 0;
	}
	int max = 0;
	for (int i = 1;i<size;i++){
	    if (getNode(i).getValue().compareTo(getNode(max).getValue()) > 0){
		max = i;
	    }
	}
	return max;
    }
    public int min(){
	if (size == 0){
	    return -1;
	}
	if (size == 1){
	    return 0;
	}
	int min = 0;
	for (int i = 1;i<size;i++){
	    if (getNode(i).getValue().compareTo(getNode(min).getValue()) < 0){
		min = i;
	    }
	}
	return min;
    }
    public LLIterator iterator(){
	return new LLIterator();
    }
    public void extend(MyLinkedListImproved<T> other){
	end.setNext(other.start);
	other.start.setPrev(this.end);
	end = other.end;
	size = size + other.size();
    }
    public class Node{
	Node next;
	Node prev;
	T data;
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
	public void setValue(T newValue){
	    data = newValue;
	}
	public String toString(){
	    String ans = "";
	    ans += data;
	    ans += "Previous: " + prev + "/n" + "Current: " + data + "/n" +  "Next: " + next;
	    return ans;
	}
    }
    public class LLIterator implements Iterator<T>{
	Node next;
	T n;
	public boolean hasNext(){
	    if (next.getNext() == null){
		return false;
	    }
	    return true;
	}
	public T next(){
	    if (hasNext()){
		n = next.getValue();
		next = next.getNext();
		return n;
	    }else{
		System.exit(0);
		return null;
	    }
	}
    }
		    
}
