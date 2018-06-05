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
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[])new Object[initialCapacity];
	firstIndex = 0;
	lastIndex = 0;
    }
    public int size(){
	return size;
    }
    @SuppressWarnings("unchecked")
    public void resize(){
	E[] newArray = (E[]) new Object[size * 2];
	for (int i = 0; i < data.length; i++) {
	    newArray[i] = data[i];
	}
	data = newArray;
	firstIndex = 0;
	lastIndex = size-1;
    }
    public void addFirst(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size == data.length){
	    resize();
	}
	if (size != 0){
	    firstIndex = (firstIndex - 1 + data.length) % data.length;
	}
	data[firstIndex] = element;
	size++;
    }
    public void addLast(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size() == data.length){
	    resize();
	}
	if (size!=0){
	    lastIndex = (lastIndex + 1) % data.length;
	}
	data[lastIndex] = element;
	size++;
    }
    public E removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	E ans  = data[firstIndex];
	data[firstIndex] = null;
	if (size>1){
	    firstIndex = (firstIndex + 1) % data.length;
	}
	size--;
	return ans;
    }
    public E removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	E ans = data[lastIndex];
	data[lastIndex] = null;
	if (size>1){
	    lastIndex = (lastIndex - 1 + data.length) % data.length;
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
	if(firstIndex < lastIndex){
	    for (int i = firstIndex; i < lastIndex; i++){
		ans += data[i]+" , ";
	    }
	}
	else{
	    for(int j = firstIndex; j<data.length; j++){
		ans+=data[j]+", ";
	    }
	    for(int x=0; x<=lastIndex; x++){
		ans+=data[x]+", ";
	    }
	}
	ans=ans.substring(0, ans.length()-2)+"]";
	return ans;
    }	
}
	
