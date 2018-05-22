import java.util.*;
import java.io.*;
public class MyDeque<E>{
    E[] data;
    int firstIndex;
    int lastIndex;
    int size;
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
	firstIndex = 0;
	lastIndex = 0;
	size = 0;
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[])new Object[initialCapacity];
	firstIndex = 0;
	lastIndex = 0;
	size = 0;
    }
    public int size(){
	return size;
    }
    public void resize(){
	@SuppressWarnings("unchecked")E[] newArray = (E[]) new Object[data.length * 2];
	for (int i = 0; i < data.length; i++) {
	    newArray[i] = data[i];
	}
	firstIndex = 0;
	lastIndex = newArray.length/2 - 1;
	data = newArray;
    }
    public void addFirst(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	if (size() == data.length || lastIndex == firstIndex - 1){
	    resize();
	}
	if (firstIndex == 0){
	    if (data[firstIndex] == null){
		data[firstIndex] = element;
		firstIndex = data.length-1;
	    }
	    else{
		firstIndex = data.length-1;
		data[firstIndex] = element;
	    }
	}
	else{
	    firstIndex--;
	    data[firstIndex] = element;
	}
	size++;
    }

    public void addLast(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	if (size == data.length || firstIndex == lastIndex+1 || lastIndex == firstIndex + 1){
	    resize();
	}
	lastIndex++;
	data[lastIndex] = element;
	size++;
    }
    public E removeFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E ans  = data[firstIndex];
	if (firstIndex == data.length - 1){
	    firstIndex = 0;
	}
	else{
	    firstIndex++;
	}
	size--;
	return ans;
    }
    public E removeLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E ans = data[lastIndex];
	if (lastIndex == 0){
	    lastIndex = data.length - 1;
	}
	else{
	    lastIndex--;
	}
	size--;
	return ans;
    }
    public E getFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[firstIndex];
    }
    public E getLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[lastIndex];
    }
    public String toString(){
	String ans = "[";
	if (firstIndex < lastIndex){
	    for (int x = firstIndex;x<=lastIndex;x++){
		ans += data[x] + ", ";
	    }
	}
	else if (firstIndex == lastIndex){
	    ans += "]";
	    return ans;
	}
	else{
	    for (int i = firstIndex;i<data.length;i++){
		ans += data[i] + ", ";
	    }
	    for (int j = 0;j<=lastIndex;j++){
		ans += data[j] + ", ";
	    }
	}
	ans = ans.substring(0,ans.length()-1) + "]";
	return ans;
    }
	    
    public static void main (String[] args){
	MyDeque<Integer> a = new MyDeque<>();
	System.out.println(a);
	a.addFirst(1);
	System.out.println(a);
	a.addFirst(10);
	System.out.println(a);
	a.addFirst(15);
	System.out.println(a);
	a.addLast(7);
	System.out.println(a);
	
	a.addLast(5);
	System.out.println(a);
	a.removeLast();
	System.out.println(a);
	a.removeFirst();
	System.out.println(a);
	a.addFirst(10);
	System.out.println(a);
	
    }
	
}
	
