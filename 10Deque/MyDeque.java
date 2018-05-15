import java.util.*;
import java.io.*;
public class MyDeque<E>{
    E[] data;
    int firstIndex=0;
    int lastIndex=0;
    int size = 0;
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[])new Object[initialCapacity];
    }
    public int size(){
	return size;
    }
    public void resize(){
	@SuppressWarnings("unchecked")E[] newArray = (E[]) new Object[data.length + 1];
	for (int i = 0; i < size(); i++) {
	    newArray[i] = data[(firstIndex + i) % size()];
	}
	firstIndex = 0;
	lastIndex = size() - 1;
	data = newArray;
    }
    public void addFirst(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	resize();
	if (data.length == 0){
	    data[firstIndex] = element;
	    size++;
	}
	else{
	    if (firstIndex == 0){
		firstIndex = data.length - 1;
		data[firstIndex] = element;
	    }
	    else{
		firstIndex--;
		data[firstIndex] = element;
	    }
	    size++;
	}
    }

    public void addLast(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	resize();
	if (data.length == 0){
	    size++;
	    data[lastIndex] = element;
	}
	else if (lastIndex == data.length -1){
	    lastIndex = 0;
	}
	lastIndex++;
	data[lastIndex] = element;
	size++;
    }
    public E removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	E ans  = data[firstIndex];
	data[firstIndex] = null;
	firstIndex = (firstIndex + data.length + 1) % data.length;
	size--;
	return ans;
    }
    public E removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	E ans = data[lastIndex];
	if (lastIndex == 0){
	    data[lastIndex] = null;
	    lastIndex = data.length - 1;
	}
	else{
	    data[lastIndex] = null;
	    lastIndex--;
	}
	return ans;
    }
    public E getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[firstIndex];
    }
    public E getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[lastIndex];
    }
    public String toString(){
	String ans = "[";
	if(firstIndex < lastIndex){
	    for (int i = firstIndex; i <= lastIndex; i++){
		ans += data[i] + " , ";
	    }
	}
	else{
	    for(int i = firstIndex; i < data.length; i++){
		ans += data[i] + ", ";
	    }
	    for(int i = 0; i <= lastIndex; i++){
		ans += data[i] + ", ";
	    }
	}
	ans = ans.substring(0, ans.length() - 2) + "]";
	return ans;
    }
}
	
