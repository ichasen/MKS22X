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
    @SuppressWarnings("unchecked")
    public void resize(){
	E[] temp = (E[])new Object[data.length * 2];
	if(firstIndex < lastIndex){
	    for (int i = firstIndex;i <= lastIndex;i++){
		temp[i] = data[i];
	    }
	}
	else{
	    int current = 0;
	    for(int i = firstIndex;i < data.length;i++){
		temp[current] = data[i];
		current++;
	    }
	    for(int i = 0;i <= lastIndex;i++){
		temp[current] = data[i];
		current++;
	    }
	}
	data = temp;
	firstIndex = 0;
	lastIndex = size() - 1;
    }
    public void addFirst(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size == data.length){
	    resize();
	}
	if(size == 0){
	    data[firstIndex] = element;
	}
	else if (firstIndex == 0){
	    data[data.length - 1] = element;
	    firstIndex = data.length -1;
	}
	else{
	    data[firstIndex - 1] = element;
	    firstIndex--;
	}
	size++;
    }
    public void addLast(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size == 0){
	    data[lastIndex] = element;
	}
	else if (lastIndex == data.length - 1){
	    data[0] = element;
	    lastIndex = 0;
	}
	else{
	    data[lastIndex + 1] = element;
	    lastIndex++;
	}
	size++;
    }
    public E removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	E ans  = data[firstIndex];
	data[firstIndex] = null;
	if(firstIndex == data.length - 1){
	    firstIndex = 0;
	    size--;
	    return ans;
	}
	size--;
	firstIndex++;
	return ans;
    }
    public E removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	E ans = data[lastIndex];
	data[lastIndex] = null;
	if(lastIndex == 0){
	    lastIndex = data.length - 1;
	    size--;
	    return ans;
	}
	lastIndex--;
	size--;
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
	
