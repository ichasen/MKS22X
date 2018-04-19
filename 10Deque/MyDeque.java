import java.util.*;
import java.io.*;
public class MyDeque<E>{
    E[] data;
    int firstIndex;
    int lastIndex;
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
	return data.length;
    }
    public void addFirst(E element){
	if (element == null){
	    throw new NullPointerException();
	}
    }
    public void addLast(E element){
	if (element == null){
	    throw new NullPointerException();
	}
    }
    public E removeFirst(){
	if (data.length == 0){
	    throw new NoSuchElementException();
	}
	E ans = data[firstIndex];
	return ans;
    }
    public E removeLast(){
	if (data.length == 0){
	    throw new NoSuchElementException();
	}
	E ans = data[lastIndex];
	return ans;
    }
    public E getFirst(){
	if (data.length == 0){
	    throw new NoSuchElementException();
	}
	return data[firstIndex];
    }
    public E getLast(){
	if (data.length == 0){
	    throw new NoSuchElementException();
	}
	return data[lastIndex];
    }
    private int indexOf(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	for (int i = 0;i<data.length;i++){
	    if (data[i] == element){
		return i;
	    }
	}
	return -1;
    }
}
	
